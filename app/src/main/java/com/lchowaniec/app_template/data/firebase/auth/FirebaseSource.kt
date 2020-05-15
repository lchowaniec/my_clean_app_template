package com.lchowaniec.app_template.data.firebase.auth

import androidx.lifecycle.MutableLiveData
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.storage.FirebaseStorage
import com.google.firebase.storage.StorageReference
import com.lchowaniec.app_template.data.models.User
import io.reactivex.Completable
import okhttp3.internal.Internal.instance

class FirebaseSource {
    private val TAG = "FirebaseSource"
    private var instance: FirebaseSource? = null
    private var mUser: MutableLiveData<User> = MutableLiveData()

    private val firebaseAuth: FirebaseAuth by lazy {
        FirebaseAuth.getInstance()
    }
    private val mFirebaseDatabase: DatabaseReference by lazy {
        FirebaseDatabase.getInstance().reference
    }
    private val mFirebaseStorage: StorageReference by lazy {
        FirebaseStorage.getInstance().reference
    }
    fun getInstance(): FirebaseSource? {
        if(instance == null){
            instance = FirebaseSource()
        }
        return instance
    }
    fun login(email:String, password: String) = Completable.create{ emitter ->
        firebaseAuth.signInWithEmailAndPassword(email,password).addOnCompleteListener{
            if(!emitter.isDisposed){
                if(it.isSuccessful)
                    emitter.onComplete()
                else
                    emitter.onError(it.exception!!)
            }
        }
    }

    fun register(email:String,password: String, username: String) = Completable.create{emitter ->
        firebaseAuth.createUserWithEmailAndPassword(email,password).addOnCompleteListener{
            if(!emitter.isDisposed){
                if(it.isSuccessful) {
                    emitter.onComplete()
                }
                else
                    emitter.onError(it.exception!!)
            }
        }.addOnSuccessListener {
            val mUserId: String = firebaseAuth.currentUser?.uid.toString()
            val mUser = User(mUserId,email,username)
            mFirebaseDatabase
                .child("user")
                .child(mUserId)
                .setValue(mUser)
        }

    }
    fun resetPassword(email: String)= Completable.create{emitter ->
        firebaseAuth.sendPasswordResetEmail(email).addOnCompleteListener{
            if(!emitter.isDisposed){
                if(it.isSuccessful){
                    emitter.onComplete()
                }
                else
                    emitter.onError(it.exception!!)
            }
        }
    }
    fun logout() = firebaseAuth.signOut()

    fun currentUser() = firebaseAuth.currentUser
}
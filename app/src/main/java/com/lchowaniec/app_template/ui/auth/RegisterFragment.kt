package com.lchowaniec.app_template.ui.auth


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController

import com.lchowaniec.app_template.R
import com.lchowaniec.app_template.util.startMainActivity
import kotlinx.android.synthetic.main.fragment_login.view.*
import kotlinx.android.synthetic.main.fragment_login.view.input_password
import kotlinx.android.synthetic.main.fragment_register.*
import kotlinx.android.synthetic.main.fragment_register.view.*


class RegisterFragment : Fragment(), AuthListener {
    private lateinit var  viewModel: AuthViewModel


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_register, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(this).get(AuthViewModel::class.java)
        viewModel.authListener = this
        register_button.setOnClickListener{
            viewModel.username = input_username.text.toString()
            viewModel.email = input_email.text.toString()
            viewModel.password = input_password.text.toString()
            viewModel.register()

        }

    }

    override fun onSuccess() {
        activity?.startMainActivity()
    }

    override fun onStarted() {
        progress_bar_register.visibility = View.VISIBLE
    }

    override fun onFailure(message: String) {
        progress_bar_register.visibility = View.GONE
        Toast.makeText(requireContext(),message,Toast.LENGTH_SHORT).show()
    }


}

package com.lchowaniec.app_template.ui.First

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider

import com.lchowaniec.app_template.R
import com.lchowaniec.app_template.ui.auth.AuthViewModel
import com.lchowaniec.app_template.ui.main.MainViewModel
import com.lchowaniec.app_template.util.startAuthActivity
import kotlinx.android.synthetic.main.fragment_first.*


class FirstFragment : Fragment() {
    private lateinit var viewModel: MainViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_first, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setHasOptionsMenu(true)
        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)
        logout_button.setOnClickListener{
            viewModel.logout()
            activity?.startAuthActivity()
        }
    }

}

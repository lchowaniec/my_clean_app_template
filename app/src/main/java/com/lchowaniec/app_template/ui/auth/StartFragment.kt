package com.lchowaniec.app_template.ui.auth


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController

import com.lchowaniec.app_template.R
import kotlinx.android.synthetic.main.fragment_login.*
import kotlinx.android.synthetic.main.fragment_password.*
import kotlinx.android.synthetic.main.fragment_register.*
import kotlinx.android.synthetic.main.fragment_start.*


class StartFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_start, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        login.setOnClickListener{
            navLogin()
        }
        register.setOnClickListener{
            navRegitration()
        }
        forgot_password.setOnClickListener{
            navResetPassword()
        }

        focusable_view.requestFocus()
    }

    private fun navResetPassword() {
        findNavController().navigate(R.id.action_startFragment_to_passwordFragment)
    }

    private fun navRegitration() {
        findNavController().navigate(R.id.action_startFragment_to_registerFragment)
    }

    private fun navLogin() {
        findNavController().navigate(R.id.action_startFragment_to_loginFragment)
    }


}

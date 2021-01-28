package com.example.navflowapp

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.InputMethodManager
import android.widget.Toast
import androidx.core.content.ContextCompat.getSystemService
import androidx.fragment.app.Fragment
import androidx.navigation.NavDirections
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.navflowapp.databinding.FragmentHomeBinding
import com.example.navflowapp.databinding.FragmentLoginBinding


/**
 * Ahmed Ali Ebaid
 * ahmedali26002844@gmail.com
 * 27/01/2021
 */
class LoginFragment : Fragment() {
    lateinit var binding: FragmentLoginBinding
    private val args:LoginFragmentArgs by navArgs()
    lateinit var myEmail: String
    lateinit var myPassword: String
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentLoginBinding.inflate(inflater, container, false)
        binding.etEmail.setText(args.email.toString())

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)



        binding.btnLogin.setOnClickListener {
            myEmail = binding.etEmail.text.toString()
            myPassword = binding.etPassword.text.toString()
            Toast.makeText(activity,"the email : $myEmail the pass : $myPassword",Toast.LENGTH_SHORT).show()

            //------- to hide the keyword -------
            var imm =  requireActivity().getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            imm.hideSoftInputFromWindow(binding.root.windowToken,0)
            //-----------

            var action = LoginFragmentDirections.actionLoginFragmentToWelcomeFragment()
            action.email =myEmail
            action.password =myPassword
            findNavController().navigate(action)
        }
    }
}
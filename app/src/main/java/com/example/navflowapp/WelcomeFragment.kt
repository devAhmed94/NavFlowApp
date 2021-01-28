package com.example.navflowapp

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.NavArgs
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.navflowapp.databinding.FragmentWelcomeBinding


/**
 * Ahmed Ali Ebaid
 * ahmedali26002844@gmail.com
 * 28/01/2021
 */
class WelcomeFragment : Fragment() {
    lateinit var binding: FragmentWelcomeBinding
    private val arg :WelcomeFragmentArgs by navArgs()
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentWelcomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        with(binding){


            tvEmail.text = arg.email
            tvPassword.text =arg.password

            btnWelcome.setOnClickListener {
                val action =WelcomeFragmentDirections.actionWelcomeFragmentToHomeFragment()
                findNavController().navigate(action)


            }
        }
    }
}
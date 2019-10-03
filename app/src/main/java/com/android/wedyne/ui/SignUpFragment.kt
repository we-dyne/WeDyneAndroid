package com.android.wedyne.ui


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.findNavController

import com.android.wedyne.R
import com.android.wedyne.databinding.FragmentSignUpBinding
import com.android.wedyne.utils.setupBackground

/**
 * A simple [Fragment] subclass.
 */
class SignUpFragment : Fragment() {
     private lateinit var binding:FragmentSignUpBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_sign_up,container,false)
        init()


        return binding.root
    }

    private fun init() {
        binding.buttonCreateAccount.setupBackground()
        binding.buttonCreateAccount.setOnClickListener {
            findNavController().navigate(R.id.home)
        }
    }

}

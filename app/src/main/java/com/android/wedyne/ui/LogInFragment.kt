package com.android.wedyne.ui


import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.core.widget.addTextChangedListener
import androidx.databinding.DataBindingUtil
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController

import com.android.wedyne.R
import com.android.wedyne.databinding.FragmentLogInBinding
import com.android.wedyne.utils.setupBackground
import kotlinx.android.synthetic.main.fragment_log_in.*
import net.yslibrary.android.keyboardvisibilityevent.util.UIUtil

/**
 * A simple [Fragment] subclass.
 */
class LogInFragment : Fragment() {
private lateinit var binding:FragmentLogInBinding
    private lateinit var navController: NavController
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_log_in,container,false)
        init()

        binding.buttonLogin.setOnClickListener {
            findNavController().navigate(R.id.otp)
        }

        return binding.root
    }

    private fun init() {
        binding.buttonLogin.isEnabled = false
        binding.buttonLogin.setupBackground()

        binding.editPhoneNumber.addTextChangedListener {
            binding.buttonLogin.isEnabled = it.toString().length == 13
            binding.buttonLogin.setupBackground()
            if(it.toString().length == 13)
                UIUtil.hideKeyboard(activity)

        }
    }

}

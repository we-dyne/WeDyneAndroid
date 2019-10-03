package com.android.wedyne.ui


import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.core.widget.addTextChangedListener
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.NavigationUI
import com.android.wedyne.R
import com.android.wedyne.databinding.FragmentOtpBinding
import com.android.wedyne.utils.setupBackground
import net.yslibrary.android.keyboardvisibilityevent.util.UIUtil

/**
 * A simple [Fragment] subclass.
 */
class OtpFragment : Fragment() {
    private lateinit var binding: FragmentOtpBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_otp, container, false)
        NavigationUI.setupWithNavController(binding.toolbar,findNavController())
        init()


        return binding.root
    }

    private fun init() {
        binding.buttonEnterOtp.isEnabled = false
        binding.buttonEnterOtp.setupBackground()
        binding.buttonEnterOtp.setOnClickListener {
            findNavController().navigate(R.id.sign_up)
        }

            binding.editOtp.addTextChangedListener(object : TextWatcher {
                override fun afterTextChanged(s: Editable?) {
                    binding.buttonEnterOtp.isEnabled = s.toString().length == 4
                    binding.buttonEnterOtp.setupBackground()
                   if(s.toString().length == 4)
                       UIUtil.hideKeyboard(activity)

                }

                override fun beforeTextChanged(
                    s: CharSequence?,
                    start: Int,
                    count: Int,
                    after: Int
                ) {
                }

                override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                }

            })



    }


}

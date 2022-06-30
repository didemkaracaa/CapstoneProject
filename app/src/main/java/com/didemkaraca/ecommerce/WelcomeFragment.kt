package com.didemkaraca.e_commerceapplication

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation.findNavController
import androidx.navigation.fragment.findNavController
import com.didemkaraca.ecommerce.R
import com.didemkaraca.ecommerce.databinding.FragmentWelcomeBinding


class WelcomeFragment : Fragment() {
    private lateinit var fragmentWelcomeBinding: FragmentWelcomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        fragmentWelcomeBinding=DataBindingUtil.inflate(inflater, R.layout.fragment_welcome,container,false)
        return fragmentWelcomeBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        fragmentWelcomeBinding.button2.setOnClickListener {
            findNavController().navigate(R.id.action_welcomeFragment2_to_signinFragment2)
        }
        fragmentWelcomeBinding.imageView8.setOnClickListener {
            findNavController().navigate(R.id.action_welcomeFragment2_to_startFragment)
        }
    }

}

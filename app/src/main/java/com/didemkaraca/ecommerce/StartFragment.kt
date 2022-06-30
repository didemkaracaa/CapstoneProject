package com.didemkaraca.e_commerceapplication

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.findNavController
import com.didemkaraca.ecommerce.R
import com.didemkaraca.ecommerce.databinding.FragmentStartBinding


class StartFragment : Fragment() {
    private lateinit var fragmentStartBinding: FragmentStartBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        fragmentStartBinding=DataBindingUtil.inflate(inflater,R.layout.fragment_start,container,false)
        return fragmentStartBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        fragmentStartBinding.button.setOnClickListener {
            findNavController().navigate(R.id.action_startFragment_to_welcomeFragment2)
        }
    }

}

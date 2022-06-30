package com.didemkaraca.ecommerce

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.didemkaraca.ecommerce.databinding.FragmentProfileBinding
import com.didemkaraca.ecommerce.databinding.FragmentSigninBinding
import com.google.firebase.auth.FirebaseAuth


class ProfileFragment : Fragment() {

    private lateinit var firebaseAuth: FirebaseAuth
    private var _binding: FragmentProfileBinding?=null
    private val binding get()=_binding!!
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {

        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding= FragmentProfileBinding.inflate(inflater)


        firebaseAuth= FirebaseAuth.getInstance()

        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.profileFragment=this
        with(binding){
           button5.setOnClickListener {
               firebaseAuth.signOut()
               findNavController().navigate(R.id.action_profileFragment_to_loginFragment)
           }
            imageView7.setOnClickListener {
                findNavController().navigate(R.id.action_profileFragment_to_homeFragment)
            }
        }
        firebaseAuth.currentUser?.let {
            // binding.etEmail.text=it.
        }

    }

    override fun onDestroy() {
        super.onDestroy()
        _binding=null
    }

}
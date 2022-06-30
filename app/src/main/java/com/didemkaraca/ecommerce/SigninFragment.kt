package com.didemkaraca.ecommerce

import android.os.Bundle
import android.text.TextUtils
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.findNavController
import com.didemkaraca.ecommerce.databinding.FragmentSigninBinding
import com.google.firebase.auth.FirebaseAuth


class SigninFragment : Fragment() {
     private lateinit var fAuth: FirebaseAuth
     private var _binding:FragmentSigninBinding?=null
     private val binding get()=_binding!!
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        //fragmentSigninBinding=DataBindingUtil.inflate(inflater,R.layout.fragment_signin,container,false)
        // return fragmentSigninBinding.root
        _binding= FragmentSigninBinding.inflate(inflater)


        fAuth= FirebaseAuth.getInstance()

        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding.imageView4.setOnClickListener {
            findNavController().navigate(R.id.action_signinFragment2_to_loginFragment2)
        }
        binding.button3.setOnClickListener {
            EmptyText()
        }
        binding.imageView10.setOnClickListener {
            findNavController().navigate(R.id.action_signinFragment2_to_welcomeFragment2)
        }
    }
    private fun fAuthSignUp(){
        fAuth.createUserWithEmailAndPassword(binding.etEmail.text.toString(),binding.etPassword.text.toString()).addOnCompleteListener {
            task->
            if(task.isSuccessful){
                findNavController().navigate(R.id.action_signinFragment2_to_mainActivity2)
                Toast.makeText(context,"Login successful",Toast.LENGTH_LONG).show()
            }else{
                Toast.makeText(context,"Login Failed. Try again",Toast.LENGTH_LONG).show()
            }
        }
    }
    private fun EmptyText(){

             binding.apply {
                 when{
                 TextUtils.isEmpty(etEmail.text.toString().trim()) -> {
                 etEmail.setError("Please enter your email address")
             }
                 TextUtils.isEmpty(etPassword.text.toString().trim())-> {
                 etPassword.setError("Please enter your password")
             }
                 etPassword.text.toString().isNotEmpty() &&
                         etEmail.text.toString().isNotEmpty() ->
                 {

                     if(etPassword.text.toString().length>=6){
                         fAuthSignUp()
                     }
                     else{
                         etPassword.setError("Password must be 8 characters")
                     }

                 }
             }


        }
    }
}

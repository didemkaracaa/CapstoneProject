
import android.os.Bundle
import android.text.TextUtils
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.ImageView
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.R
import androidx.navigation.fragment.findNavController
import com.didemkaraca.ecommerce.databinding.FragmentLoginBinding
import com.didemkaraca.ecommerce.databinding.FragmentSigninBinding
import com.google.firebase.auth.FirebaseAuth


class LoginFragment : Fragment() {
    private lateinit var fAuth: FirebaseAuth
    private var _binding: FragmentLoginBinding?=null
    private val binding get()=_binding!!
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding= FragmentLoginBinding.inflate(inflater)


        fAuth= FirebaseAuth.getInstance()

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding.imageView6.setOnClickListener {
            findNavController().navigate(com.didemkaraca.ecommerce.R.id.action_loginFragment2_to_passwordFragment2)
        }
       binding.button2.setOnClickListener {
           EmptyText()
       }
        binding.imageView9.setOnClickListener {
            findNavController().navigate(com.didemkaraca.ecommerce.R.id.action_loginFragment2_to_signinFragment2)
        }
    }
    private fun fAuthLogin(){
        fAuth.signInWithEmailAndPassword(binding.etEmail.text.toString(),binding.etPassword.text.toString()).addOnCompleteListener {
                task->
            if(task.isSuccessful){
                findNavController().navigate(com.didemkaraca.ecommerce.R.id.action_loginFragment2_to_mainActivity2)
                Toast.makeText(context,"Login successful", Toast.LENGTH_LONG).show()
            }else{
                Toast.makeText(context,"Login Failed. Try again", Toast.LENGTH_LONG).show()
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
                        fAuthLogin()
                    }
                    else{
                        etPassword.setError("Password must be 8 characters")
                    }

                }
            }


        }
    }
}
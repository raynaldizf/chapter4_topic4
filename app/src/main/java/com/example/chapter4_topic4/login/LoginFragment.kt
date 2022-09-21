package com.example.chapter4_topic4.login

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.Navigation
import com.example.chapter4_topic4.R
import com.example.chapter4_topic4.databinding.FragmentLoginBinding
import kotlinx.android.synthetic.main.fragment_login.*

class LoginFragment : Fragment() {
    private lateinit var binding : FragmentLoginBinding
    private lateinit var sharedPrefs : SharedPreferences


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentLoginBinding.inflate(layoutInflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        sharedPrefs = requireActivity().getSharedPreferences("datauser",Context.MODE_PRIVATE)

        btnLogin.setOnClickListener{
            val inputUsername = binding.etUsername.text.toString()
            val inputPassword = binding.etPassword.text.toString()
            val usernameShared = sharedPrefs.getString("username","")
            val passwordShared = sharedPrefs.getString("password","")

            if (inputUsername.equals(usernameShared) && inputPassword.equals(passwordShared)){
                Navigation.findNavController(view).navigate(R.id.action_loginFragment_to_homeFragment)
            }else{
                Toast.makeText(context,"Data Salah!",Toast.LENGTH_SHORT).show()
            }
        }

        linkRegister.setOnClickListener{
            Navigation.findNavController(view).navigate(R.id.registerFragment)
        }
    }

}
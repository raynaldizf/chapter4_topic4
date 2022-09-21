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
import com.example.chapter4_topic4.databinding.FragmentRegisterBinding
import kotlinx.android.synthetic.main.fragment_register.*

class RegisterFragment : Fragment() {
    private lateinit var binding : FragmentRegisterBinding
    private lateinit var sharedPref : SharedPreferences

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentRegisterBinding.inflate(layoutInflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        sharedPref =requireActivity().getSharedPreferences("datauser",Context.MODE_PRIVATE)

        btnRegister.setOnClickListener{
            val userName = binding.etRegisterUsername.text.toString()
            val fullName = binding.etRegisterFullName.text.toString()
            val password = binding.etRegisterPassword.text.toString()
            val repeatPassword = binding.etRegisterRepeatPassword.text.toString()
            val addUser = sharedPref.edit()

            if (repeatPassword.equals(password)){
                addUser.putString("username",userName)
                addUser.putString("fullName",fullName)
                addUser.putString("password",password)
                addUser.putString("repeatPassword",repeatPassword)
                addUser.apply()
                Navigation.findNavController(view).navigate(R.id.loginFragment)
            }else{
                Toast.makeText(context,"Password Tidak Cocok!",Toast.LENGTH_SHORT).show()
            }
        }

        linkLogin.setOnClickListener{
            Navigation.findNavController(view).navigate(R.id.loginFragment)
        }
    }
}
package com.example.chapter4_topic4.login

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.os.Handler
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import com.example.chapter4_topic4.R
import com.example.chapter4_topic4.databinding.FragmentSplashBinding


@Suppress("DEPRECATION")
class SplashFragment : Fragment() {
    private lateinit var binding : FragmentSplashBinding
    private lateinit var sharedPref : SharedPreferences

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment

        binding = FragmentSplashBinding.inflate(layoutInflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val splashTime : Long = 3000

        sharedPref = requireActivity().getSharedPreferences("datauser",Context.MODE_PRIVATE)
        val getData = sharedPref.getString("username","")

        if (getData != ""){
            val getFullName = sharedPref.getString("fullName","")
            val bun = Bundle()
            bun.putString("fullName",getFullName)
            Handler().postDelayed({
                Navigation.findNavController(view).navigate(R.id.homeFragment,bun)

            },splashTime)
        }else{
            Handler().postDelayed({
                Navigation.findNavController(view).navigate(R.id.loginFragment)

            },splashTime)
        }

    }

    override fun onResume() {
        super.onResume()
        (activity as AppCompatActivity).supportActionBar?.hide()
    }

    override fun onStop() {
        super.onStop()
        (activity as AppCompatActivity).supportActionBar?.show()
    }
}
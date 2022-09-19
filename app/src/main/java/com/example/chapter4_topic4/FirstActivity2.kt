package com.example.chapter4_topic4

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.chapter4_topic4.databinding.ActivityFirst2Binding

class FirstActivity2 : AppCompatActivity() {
    lateinit var binding : ActivityFirst2Binding
    lateinit var sharedPrefs : SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityFirst2Binding.inflate(layoutInflater)
        setContentView(binding.root)

        sharedPrefs = getSharedPreferences("USERNAME",Context.MODE_PRIVATE)
        binding.btnSend.setOnClickListener{
            val user = binding.etUsername.text.toString()
            var addUser = sharedPrefs.edit()
            addUser.putString("username",user)
            addUser.apply()

            startActivity(Intent(this, SecondActivity2::class.java))

        }
    }
}
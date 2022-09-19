package com.example.chapter4_topic4

import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.chapter4_topic4.databinding.ActivitySecond2Binding

class SecondActivity2 : AppCompatActivity() {
    lateinit var binding : ActivitySecond2Binding
    lateinit var sharedPref : SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivitySecond2Binding.inflate(layoutInflater)
        setContentView(binding.root)

        sharedPref = this.getSharedPreferences("USERNAME",Context.MODE_PRIVATE)
        var getData = sharedPref.getString("username","")
        binding.hasil.text = getData

    }
}
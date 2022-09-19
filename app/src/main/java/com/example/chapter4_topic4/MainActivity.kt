package com.example.chapter4_topic4

import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.chapter4_topic4.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding : ActivityMainBinding
    lateinit var sharedPrefs : SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        sharedPrefs = getSharedPreferences("STUDENT",Context.MODE_PRIVATE)
        binding.btnSave.setOnClickListener{
            saveData()
            Toast.makeText(this,"Data Berhasil Disimpan",Toast.LENGTH_SHORT).show()
        }
        binding.btnShow.setOnClickListener{
            showData()
        }
        binding.btnReset.setOnClickListener{
            resetData()
        }
    }
    fun saveData(){
        var getNim = binding.etNim.text.toString()
        var getName = binding.etName.text.toString()

        var addData = sharedPrefs.edit()
        addData.putString("nim",getNim)
        addData.putString("name",getName)
        addData.apply()

    }

    fun showData(){
        binding.txtNim.text = sharedPrefs.getString("nim","")
        binding.txtName.text = sharedPrefs.getString("name","")

    }

    fun resetData(){
        var pref = sharedPrefs.edit()
        pref.clear()
        pref.apply()

        showData()
    }
}
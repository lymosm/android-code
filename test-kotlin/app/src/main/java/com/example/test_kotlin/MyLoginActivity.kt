package com.example.test_kotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.content.Intent
import android.widget.Button

class MyLoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)
        setContentView(R.layout.mylogin)

        setClick()
    }

    private fun setClick(){
        val btnHome: Button = findViewById(R.id.btn_home)
        btnHome.setOnClickListener{
            goToActivity()
        }

    }

    private fun goToActivity(){
        val intent = Intent(this, ListActivity::class.java)
        startActivity(intent)
    }
}
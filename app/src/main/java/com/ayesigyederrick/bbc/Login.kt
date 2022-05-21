package com.ayesigyederrick.bbc

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class Login : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        title = "LogIn"

        //Set onclick to move to register page
        val go_to_register = findViewById<TextView>(R.id.text_gotoregister)
        go_to_register.setOnClickListener {
            val i = Intent(this, Register::class.java)
            startActivity(i)
            finish()
        }
    }
}
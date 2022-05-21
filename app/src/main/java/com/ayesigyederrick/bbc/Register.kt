package com.ayesigyederrick.bbc

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class Register : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)
        title = "Register"

        // set on click to move to login page
        val go_to_login = findViewById<TextView>(R.id.text_gotologin)
        go_to_login.setOnClickListener {
            val intent_2 = Intent(this, Login::class.java)
            startActivity(intent_2)
        }
    }
}
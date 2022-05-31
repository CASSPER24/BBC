package com.ayesigyederrick.bbc

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.google.android.material.textfield.TextInputEditText
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

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

        val btn = findViewById<Button>(R.id.button_skip)
            btn.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
    fun GotoMain(view: View) {
        val email = findViewById<TextInputEditText>(R.id.email_login).text.toString()
        val password = findViewById<TextInputEditText>(R.id.password_login).text.toString()
        if(email =="" || password == ""){
            Toast.makeText(applicationContext, "Fields cant be left Empty, Press Skip or go to Register to open an Account", Toast.LENGTH_LONG).show()
        }else {
            Firebase.auth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener { task ->
                    if (task.isSuccessful) {
                        val i = Intent(this, MainActivity::class.java)
                        startActivity(i)
                        finish()
                    }
                }.addOnFailureListener { exception ->
                    Toast.makeText(applicationContext,
                        exception.localizedMessage,
                        Toast.LENGTH_LONG).show()
                }
        }
    }
}
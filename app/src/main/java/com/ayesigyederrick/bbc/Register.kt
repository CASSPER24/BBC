package com.ayesigyederrick.bbc

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class Register : AppCompatActivity() {
    private lateinit var auth: FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)
        title = "Register"

        //Firebase auth
        auth = Firebase.auth

        // set on click to move to login page
        val go_to_login = findViewById<TextView>(R.id.text_gotologin)
        go_to_login.setOnClickListener {
            val intent_2 = Intent(this, Login::class.java)
            startActivity(intent_2)
        }

    }
    fun btnRegister(view: View) {
        val email = findViewById<TextInputEditText>(R.id.email_register).text.toString()
        val password = findViewById<TextInputEditText>(R.id.password_register).text.toString()
        val confirm_password =
            findViewById<TextInputEditText>(R.id.password_register_confirm).text.toString()
        if (password == confirm_password) {
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
                        Toast.LENGTH_LONG)
                        .show()
                }
        } else {
            Toast.makeText(applicationContext, "Passwords don't match", Toast.LENGTH_LONG)

        }
    }

    }


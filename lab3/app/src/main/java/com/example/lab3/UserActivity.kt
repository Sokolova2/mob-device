package com.example.lab3

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity


class UserActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user)

        val userLogin = intent.getStringExtra("USER_LOGIN")

        val loginTextView: TextView = findViewById(R.id.loginTextView)
        loginTextView.text = "Logged in as: $userLogin"
    }
}

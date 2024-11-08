package com.example.lab3

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.activity.ComponentActivity
//import com.example.lab3.R.*


class UserActivity : ComponentActivity() {
    private lateinit var loginTextView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user)

        val userLogin = intent.getStringExtra("USER_LOGIN")
        val settingButton: Button = findViewById(R.id.button3)
        val gameButton: Button = findViewById(R.id.gameButton)

        loginTextView = findViewById(R.id.textView6)
        loginTextView.text = "Logged in as: $userLogin"

        settingButton.setOnClickListener {
            val intent = Intent(this, SettingActivity::class.java)
            startActivity(intent)
        }
        gameButton.setOnClickListener {
            val intent = Intent(this, GameActivity::class.java)
            startActivity(intent)
        }
    }
}

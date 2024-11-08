package com.example.lab3

import android.content.Context
import android.content.Intent
import android.net.ConnectivityManager
import android.net.LinkAddress
import android.net.NetworkCapabilities
import android.net.NetworkInfo
import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.RadioButton
import android.widget.TextView
import androidx.activity.ComponentActivity



class SettingActivity : ComponentActivity() {
    private lateinit var ipTextView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_setting)

        val currentLogin = intent.getStringExtra("USER_LOGIN") ?: ""
        val newLoginInput: EditText = findViewById(R.id.editTextText)
        val updateButton: Button = findViewById(R.id.button)
        val checkBox: CheckBox = findViewById(R.id.checkBox)
        ipTextView = findViewById(R.id.textView5)

        newLoginInput.setText(currentLogin)

        checkBox.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) {
                ipTextView.text = "192.168.0.1"
            } else {
                ipTextView.text = ""
            }
        }

        updateButton.setOnClickListener {
            val radioButton: RadioButton = findViewById(R.id.radioButton)

            val isShowName = radioButton.isChecked
            val newLogin = newLoginInput.text.toString()
            val intent = Intent(this, UserActivity::class.java)
            val loginToUse = if (isShowName) newLogin else ""
            intent.putExtra("USER_LOGIN", loginToUse)
            startActivity(intent)
        }
    }
}

package com.example.lab3

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.lab3.ui.theme.Lab3Theme

class MainActivity : ComponentActivity() {
    private val users = mutableMapOf<String, String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val loginInput: EditText = findViewById(R.id.loginInput)
        val passwordInput: EditText = findViewById(R.id.passwordInput)
        val submitButton: Button = findViewById(R.id.submitButton)

        users["admin"] = "admin"
        users["user"] = "user"

        submitButton.setOnClickListener {
            val login = loginInput.text.toString()
            val password = passwordInput.text.toString();
            if (users.containsKey(login) && users[login] == password) {
                val intent = Intent(this, UserActivity::class.java)
                intent.putExtra("USER_LOGIN", login)
                startActivity(intent)
            } else {
                loginInput.error = "Invalid login or password"
            }
        }
    }
}
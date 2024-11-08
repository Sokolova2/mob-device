package com.example.lab3

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.ComponentActivity
import androidx.appcompat.app.AppCompatActivity

class GameActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game)

        val yesButton: Button = findViewById(R.id.button2)
        val noButton: Button = findViewById(R.id.button5)

        yesButton.setOnClickListener {
            val intent = Intent(this, ResultActivity::class.java)
            intent.putExtra("RESULT_MESSAGE", "You lose")
            startActivity(intent)
        }

        noButton.setOnClickListener {
            val intent = Intent(this, ResultActivity::class.java)
            intent.putExtra("RESULT_MESSAGE", "You win")
            startActivity(intent)
        }
    }
}

package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val secondActivity = findViewById<Button>(R.id.open_activity_2)
        val secondActivityWithData = findViewById<Button>(R.id.open_activity_2_with_data)

        secondActivity.setOnClickListener {
            intent = Intent(this,SecondActivity::class.java)
            startActivity(intent)
            Toast.makeText(this, "Second Activity", Toast.LENGTH_SHORT).show()
        }

        secondActivityWithData.setOnClickListener {
            intent = Intent(this,SecondActivity::class.java)
            intent.putExtra("key","Data Received")
            startActivity(intent)
        }
    }
}
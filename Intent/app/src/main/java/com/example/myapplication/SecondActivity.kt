package com.example.myapplication

import android.opengl.Visibility
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import android.widget.Toast
import com.google.android.material.floatingactionbutton.FloatingActionButton

class SecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        val textview = findViewById<TextView>(R.id.textView)
        val close = findViewById<FloatingActionButton>(R.id.close)

        val bundle: Bundle? = intent.extras
        val text = bundle?.get("key")

        if (text == null){
            textview.visibility = View.GONE
        }
        textview.setText(text.toString())


        close.setOnClickListener {
            finish()
        }
    }
}
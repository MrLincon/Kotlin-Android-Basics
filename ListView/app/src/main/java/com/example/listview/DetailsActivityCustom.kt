package com.example.listview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import android.widget.Switch
import android.widget.TextView
import com.google.android.material.floatingactionbutton.FloatingActionButton

class DetailsActivityCustom : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details)

        val fab = findViewById<FloatingActionButton>(R.id.back)
        val title = findViewById<TextView>(R.id.title)
        val image = findViewById<ImageView>(R.id.image)

        val intent = getIntent()

        val item = intent.getStringExtra("item")
        val position = intent.getLongExtra("position",0)

        val pos = position?.toInt()

        title.text = item

        when (pos) {
            0 -> image.setImageResource(R.drawable.ic_1)
            1 -> image.setImageResource(R.drawable.ic_2)
            2 -> image.setImageResource(R.drawable.ic_3)
            3 -> image.setImageResource(R.drawable.ic_4)
            4 -> image.setImageResource(R.drawable.ic_5)
            5 -> image.setImageResource(R.drawable.ic_6)
            6 -> image.setImageResource(R.drawable.ic_7)
            7 -> image.setImageResource(R.drawable.ic_8)
            8 -> image.setImageResource(R.drawable.ic_9)
            else -> {
                image.setImageResource(R.drawable.ic_9plus)
            }
        }

        fab.setOnClickListener {
            finish()
        }

    }
}
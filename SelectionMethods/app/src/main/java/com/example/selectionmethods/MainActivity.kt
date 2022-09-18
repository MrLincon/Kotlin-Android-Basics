package com.example.selectionmethods

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.*
import androidx.cardview.widget.CardView
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val radioButton = findViewById<CardView>(R.id.radio_button)
        val spinner = findViewById<CardView>(R.id.spinner)
        val switch = findViewById<CardView>(R.id.switch1)


        radioButton.setOnClickListener {
            val fragmentRadioButton = FragmentRadioButton()

            supportFragmentManager.beginTransaction().apply {
                replace(R.id.container,fragmentRadioButton)
                addToBackStack(null)
                commit()
            }
        }

        spinner.setOnClickListener {
            val fragmentSpinner = FragmentSpinner()

            supportFragmentManager.beginTransaction().apply {
                replace(R.id.container,fragmentSpinner)
                addToBackStack(null)
                commit()
            }
        }

        switch.setOnClickListener {
            val fragmentSwitch = FragmentSwitch()

            supportFragmentManager.beginTransaction().apply {
                replace(R.id.container,fragmentSwitch)
                addToBackStack(null)
                commit()
            }
        }

    }

}
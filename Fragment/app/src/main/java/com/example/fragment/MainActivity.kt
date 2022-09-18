package com.example.fragment

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    private lateinit var openFragmentOne: Button
    private lateinit var openFragmentTwo: Button
    private lateinit var openFragmentThree: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        openFragmentOne = findViewById(R.id.open_fragment_1)
        openFragmentTwo = findViewById(R.id.open_fragment_2)
        openFragmentThree = findViewById(R.id.open_fragment_3)

        clicks()
    }

    private fun clicks(){
        val firstFragment = FragmentOne()
        val secondFragment = FragmentTwo()
        val thirdFragment = FragmentThree()


        openFragmentOne.setOnClickListener {

            supportFragmentManager.beginTransaction().apply {
                replace(R.id.container,firstFragment)
                addToBackStack(null)
                commit()
            }
        }

        openFragmentTwo.setOnClickListener {

            supportFragmentManager.beginTransaction().apply {
                replace(R.id.container,secondFragment)
                addToBackStack(null)
                commit()
            }

        }

        openFragmentThree.setOnClickListener {

            supportFragmentManager.beginTransaction().apply {
                replace(R.id.container,thirdFragment)
                addToBackStack(null)
                commit()
            }

        }
    }
}
package com.example.darkmode

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Switch
import android.widget.Toast
import androidx.appcompat.app.AppCompatDelegate
import androidx.cardview.widget.CardView
import com.google.android.material.floatingactionbutton.FloatingActionButton

class SettingsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        val themeSettings = ThemeSettings(this)
        if (themeSettings.loadNightModeState() === false) {
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
        } else {
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
        }
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_settings)

        var darkMode = findViewById<CardView>(R.id.dark_mode)
        var darkModeSwitch = findViewById<Switch>(R.id.dark_mode_switch)
        var rate = findViewById<CardView>(R.id.rate)
        var share = findViewById<CardView>(R.id.share)
        var feedback = findViewById<CardView>(R.id.feedback)
        var fab = findViewById<FloatingActionButton>(R.id.fab)


        if (themeSettings.loadNightModeState() == false) {
            darkModeSwitch.isChecked = false
        } else {
            darkModeSwitch.isChecked = true
        }

        darkMode.setOnClickListener(View.OnClickListener {
            if (themeSettings.loadNightModeState() == false) {
                themeSettings.setNightModeState(true)
                restartApp() //Recreate activity
            } else {
                themeSettings.setNightModeState(false)
                restartApp() //Recreate activity
            }
        })

        rate.setOnClickListener {
            Toast.makeText(this, "Rate", Toast.LENGTH_SHORT).show()
        }

        share.setOnClickListener {
            Toast.makeText(this, "Share", Toast.LENGTH_SHORT).show()
        }

        feedback.setOnClickListener {
            Toast.makeText(this, "Feedback", Toast.LENGTH_SHORT).show()
        }

        fab.setOnClickListener {
            intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }
    }

    override fun onBackPressed() {
        super.onBackPressed()
        intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
        finish()
    }

    //Recreate activity
    private fun restartApp() {
        intent = Intent(this, SettingsActivity::class.java)
        startActivity(intent)
        finish()
        overridePendingTransition(R.anim.fade_in, R.anim.fade_out)
    }

}
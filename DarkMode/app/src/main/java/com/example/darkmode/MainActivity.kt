package com.example.darkmode

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.Switch
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import androidx.cardview.widget.CardView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {

        val themeSettings = ThemeSettings(this)
        if (themeSettings.loadNightModeState() === false) {
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
        } else {
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
        }

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var settings = findViewById<ImageView>(R.id.settings)
        var mode = findViewById<TextView>(R.id.mode)
        var change = findViewById<CardView>(R.id.change)

        if (themeSettings.loadNightModeState() === false) {
            mode.text = "Light Mode"
        } else {
            mode.text = "Dark Mode"
        }

        change.setOnClickListener {
            if (themeSettings.loadNightModeState() == false) {
                themeSettings.setNightModeState(true)
                restartApp() //Recreate activity
            } else {
                themeSettings.setNightModeState(false)
                restartApp() //Recreate activity
            }
        }

        settings.setOnClickListener {
            intent = Intent(this,SettingsActivity::class.java)
            startActivity(intent)
            finish()
        }

    }

    //Recreate activity
    private fun restartApp() {
        intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
        finish()
        overridePendingTransition(R.anim.fade_in, R.anim.fade_out)
    }

}
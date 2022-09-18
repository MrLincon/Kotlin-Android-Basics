package com.example.navigationdrawer

import android.content.Intent
import android.opengl.Visibility
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.provider.Contacts.PresenceColumns.INVISIBLE
import android.view.Gravity
import android.view.View.GONE
import android.view.View.INVISIBLE
import android.widget.ImageView
import android.widget.Toast
import androidx.constraintlayout.widget.ConstraintSet.GONE
import androidx.drawerlayout.widget.DrawerLayout
import com.google.android.material.bottomappbar.BottomAppBar
import com.google.android.material.navigation.NavigationView

class ActivityStyleThree : AppCompatActivity() {

    private lateinit var drawerLayout: DrawerLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_style_three)

        drawerLayout = findViewById(R.id.drawer_layout)
        var navDrawer = findViewById<NavigationView>(R.id.nav_drawer)
        val bottomAppBar = findViewById<BottomAppBar>(R.id.bottom_appbar)

        drawerLayout.openDrawer(Gravity.LEFT)

        navDrawer.setCheckedItem(R.id.style_three)

        navDrawer.setNavigationItemSelectedListener {
            when(it.itemId){
                R.id.one-> {

//                    Toast.makeText(this, "One", Toast.LENGTH_SHORT).show()
//                    drawerLayout.closeDrawer(Gravity.LEFT)
                }
                R.id.two->{
//                    Toast.makeText(this, "Two", Toast.LENGTH_SHORT).show()
//                    drawerLayout.closeDrawer(Gravity.LEFT)
                }
                R.id.three->{
//                    Toast.makeText(this, "Three", Toast.LENGTH_SHORT).show()
//                    drawerLayout.closeDrawer(Gravity.LEFT)
                }
                R.id.four->{
//                    Toast.makeText(this, "Four", Toast.LENGTH_SHORT).show()
//                    drawerLayout.closeDrawer(Gravity.LEFT)
                }
                R.id.style_one -> {
                    drawerLayout.closeDrawer(Gravity.LEFT)
                    Handler(Looper.getMainLooper()).postDelayed({
                        intent = Intent(this, ActivityStyleOne::class.java)
                        startActivity(intent)
                        finish()
                        overridePendingTransition(R.anim.slide_in_right,R.anim.slide_out_left)
                    }, 300)
                }

                R.id.style_two -> {
                    drawerLayout.closeDrawer(Gravity.LEFT)
                    Handler(Looper.getMainLooper()).postDelayed({
                        intent = Intent(this, ActivityStyleTwo::class.java)
                        startActivity(intent)
                        finish()
                        overridePendingTransition(R.anim.slide_in_right,R.anim.slide_out_left)
                    }, 300)
                }
                R.id.style_three -> {

//                    drawerLayout.closeDrawer(Gravity.LEFT)
                }
            }
            true
        }

        bottomAppBar.setOnMenuItemClickListener {
            when(it.itemId){
                R.id.one -> Toast.makeText(this, "One", Toast.LENGTH_SHORT).show()
                R.id.two -> Toast.makeText(this, "Two", Toast.LENGTH_SHORT).show()
                R.id.three -> Toast.makeText(this, "Three", Toast.LENGTH_SHORT).show()
            }
            true
        }

        bottomAppBar.setNavigationOnClickListener {
            drawerLayout.openDrawer(Gravity.LEFT)
        }
    }

    override fun onBackPressed() {
        if(drawerLayout.isDrawerOpen(Gravity.LEFT)){
            drawerLayout.closeDrawer(Gravity.LEFT)
        }else{
            super.onBackPressed()
        }

    }
}
package com.example.tablayout

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayout.*
import com.google.android.material.tabs.TabLayoutMediator

class MainActivity : AppCompatActivity() {

    private lateinit var extendedFab: ExtendedFloatingActionButton
    private lateinit var fab1: FloatingActionButton
    private lateinit var fab2: FloatingActionButton
    private lateinit var fab3: FloatingActionButton
    private lateinit var fab4: FloatingActionButton
    private lateinit var fab5: FloatingActionButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        extendedFab = findViewById(R.id.extended_fab)
        fab1 = findViewById(R.id.fab1)
        fab2 = findViewById(R.id.fab2)
        fab3 = findViewById(R.id.fab3)
        fab4 = findViewById(R.id.fab4)
        fab5 = findViewById(R.id.fab5)

        val tabLayout = findViewById<TabLayout>(R.id.tab_layout)
        val viewPager = findViewById<ViewPager2>(R.id.viewpager)

        val adapter = ViewpagerAdapter(supportFragmentManager, lifecycle)

        viewPager.adapter = adapter

        TabLayoutMediator(tabLayout, viewPager) { tab, position ->
            when (position) {
                0 -> {
                    tab.text = "One"
                }
                1 -> {
                    tab.text = "Two"
                }
                2 -> {
                    tab.text = "Three"
                }
            }
        }.attach()

        tabLayout.setSelectedTabIndicator(R.drawable.tab_indicator1)
        tabLayout.setTabTextColors(getColor(R.color.colorSecondary), getColor(R.color.colorAccent))
        tabLayout.setSelectedTabIndicatorGravity(INDICATOR_GRAVITY_BOTTOM)
        tabLayout.setTabRippleColorResource(R.color.tabRippleColor)
        val param = tabLayout.layoutParams as ViewGroup.MarginLayoutParams
        param.setMargins(0, 0, 0, 0)
        tabLayout.layoutParams = param

        extendedFab.shrink()
        fab1.visibility = View.GONE
        fab2.visibility = View.GONE
        fab3.visibility = View.GONE
        fab4.visibility = View.GONE
        fab5.visibility = View.GONE

        var isVisible = false

        extendedFab.setOnClickListener {
            if (!isVisible) {
                fabOpen()
                isVisible = true

            } else {
                fabClose()

                isVisible = false
            }
        }

        fab5.setOnClickListener {

            tabLayout.setSelectedTabIndicator(R.drawable.tab_indicator1)
            tabLayout.setTabTextColors(getColor(R.color.colorSecondary), getColor(R.color.colorAccent))
            tabLayout.setSelectedTabIndicatorGravity(INDICATOR_GRAVITY_BOTTOM)
            tabLayout.setTabRippleColorResource(R.color.tabRippleColor)
            val param = tabLayout.layoutParams as ViewGroup.MarginLayoutParams
            param.setMargins(0, 0, 0, 0)
            tabLayout.layoutParams = param

            fabClose()
            isVisible = false
        }

        fab4.setOnClickListener {
            tabLayout.setSelectedTabIndicator(R.drawable.tab_indicator2)
            tabLayout.setTabTextColors(getColor(R.color.colorSecondary), getColor(R.color.colorAccent))
            tabLayout.setSelectedTabIndicatorGravity(INDICATOR_GRAVITY_BOTTOM)
            val param = tabLayout.layoutParams as ViewGroup.MarginLayoutParams
            param.setMargins(0, 0, 0, 0)
            tabLayout.layoutParams = param
            tabLayout.setTabRippleColorResource(R.color.tabRippleColor)

            fabClose()
            isVisible = false
        }

        fab3.setOnClickListener {

            tabLayout.setSelectedTabIndicator(R.drawable.tab_indicator3)
            tabLayout.setTabTextColors(getColor(R.color.colorSecondary), getColor(R.color.colorAccent))
            tabLayout.setSelectedTabIndicatorGravity(INDICATOR_GRAVITY_TOP)
            val param = tabLayout.layoutParams as ViewGroup.MarginLayoutParams
            param.setMargins(0, 0, 0, 0)
            tabLayout.layoutParams = param
            tabLayout.setTabRippleColorResource(R.color.tabRippleColor)

            fabClose()
            isVisible = false
        }

        fab2.setOnClickListener {

            tabLayout.setSelectedTabIndicator(R.drawable.tab_indicator5)
            tabLayout.setTabTextColors(getColor(R.color.colorSecondary), getColor(R.color.colorAccent))
            tabLayout.setSelectedTabIndicatorGravity(INDICATOR_GRAVITY_BOTTOM)
            tabLayout.setTabRippleColorResource(R.color.tabRippleColor)
            val param = tabLayout.layoutParams as ViewGroup.MarginLayoutParams
            param.setMargins(0, 0, 0, 0)
            tabLayout.layoutParams = param

            fabClose()
            isVisible = false
        }


        fab1.setOnClickListener {
            tabLayout.setSelectedTabIndicator(R.drawable.tab_indicator4)
            tabLayout.setTabTextColors(getColor(R.color.colorSecondary), getColor(R.color.colorWhite))
            tabLayout.setSelectedTabIndicatorGravity(INDICATOR_GRAVITY_CENTER)
            val param = tabLayout.layoutParams as ViewGroup.MarginLayoutParams
            param.setMargins(16, 4, 16, 0)
            tabLayout.layoutParams = param
            tabLayout.tabRippleColor = null

            fabClose()
            isVisible = false
        }


    }

    private fun fabClose() {
        extendedFab.shrink()
        fab1.hide()
        fab2.hide()
        fab3.hide()
        fab4.hide()
        fab5.hide()


    }

    private fun fabOpen() {
        fab1.show()
        fab2.show()
        fab3.show()
        fab4.show()
        fab5.show()

        extendedFab.extend()


    }
}
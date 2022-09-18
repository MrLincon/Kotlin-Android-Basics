package com.example.bottomnavigation.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.fragment.app.Fragment
import com.example.bottomnavigation.R
import com.example.bottomnavigation.typeFragment.*
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var fab = findViewById<ExtendedFloatingActionButton>(R.id.fab)
        replaceFragment(FragmentSimple())


        fab.setOnClickListener {
            val dialog = BottomSheetDialog(this)

            val view = layoutInflater.inflate(R.layout.bottom_sheet, null)
            dialog.setCancelable(true)
            dialog.setContentView(view)

            val simple = view.findViewById<Button>(R.id.simple)
            val labelSelected = view.findViewById<Button>(R.id.label_selected)
            val labeled = view.findViewById<Button>(R.id.labeled)
            val topIndicator = view.findViewById<Button>(R.id.top_indicator)
            val centerIndicator = view.findViewById<Button>(R.id.center_indicator)
            val customBG1 = view.findViewById<Button>(R.id.custom1)
            val customBG2 = view.findViewById<Button>(R.id.custom2)
            val chipNavigation = view.findViewById<Button>(R.id.chip_navigation)
            val fabRight = view.findViewById<Button>(R.id.fab_right)
            val fabCentered = view.findViewById<Button>(R.id.fab_centered)
            val fabCenteredOverlap = view.findViewById<Button>(R.id.fab_centered_overlap)

            simple.setOnClickListener {
               replaceFragment(FragmentSimple())
                dialog.cancel()
            }

            labelSelected.setOnClickListener {
                replaceFragment(FragmentLabelSelected())
                dialog.cancel()
            }

            labeled.setOnClickListener {
                replaceFragment(FragmentLabeled())
                dialog.cancel()
            }

            topIndicator.setOnClickListener {
                replaceFragment(FragmentTopIndicator())
                dialog.cancel()
            }

            centerIndicator.setOnClickListener {
                replaceFragment(FragmentCenterIndicator())
                dialog.cancel()
            }

            customBG1.setOnClickListener {
                replaceFragment(FragmentCustomBG1())
                dialog.cancel()
            }

            customBG2.setOnClickListener {
                replaceFragment(FragmentCustomBG2())
                dialog.cancel()
            }

            chipNavigation.setOnClickListener {
                replaceFragment(FragmentChipNavigation())
                dialog.cancel()
            }

            fabRight.setOnClickListener {
                replaceFragment(FragmentFabRight())
                dialog.cancel()
            }

            fabCentered.setOnClickListener {
                replaceFragment(FragmentFabCentered())
                dialog.cancel()
            }

            fabCenteredOverlap.setOnClickListener {
                replaceFragment(FragmentFabCenterOverlap())
                dialog.cancel()
            }
            dialog.show()
        }



    }

    private fun replaceFragment(fragment: Fragment) {
        if (fragment != null) {
            val transaction = supportFragmentManager.beginTransaction()
            transaction.replace(R.id.container_main, fragment)
            transaction.commit()
        }
    }
}
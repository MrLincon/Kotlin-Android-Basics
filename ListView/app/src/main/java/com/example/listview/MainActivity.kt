package com.example.listview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.*
import androidx.fragment.app.Fragment
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
            val custom = view.findViewById<Button>(R.id.custom)
            val firebase = view.findViewById<Button>(R.id.custom_firebase)

            simple.setOnClickListener {
                replaceFragment(FragmentSimple())
                dialog.cancel()
            }

            custom.setOnClickListener {
                replaceFragment(FragmentCustom())
                dialog.cancel()
            }

            firebase.setOnClickListener {
//                replaceFragment(FragmentFirebase())
                dialog.cancel()
            }
            dialog.show()
        }

    }

    private fun replaceFragment(fragment: Fragment) {
        if (fragment != null) {
            val transaction = supportFragmentManager.beginTransaction()
            transaction.replace(R.id.container, fragment)
            transaction.commit()
        }
    }

}
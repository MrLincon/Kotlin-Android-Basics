package com.example.bottomnavigation.typeFragment

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.example.bottomnavigation.bottomNavFragment.FragmentFour
import com.example.bottomnavigation.bottomNavFragment.FragmentOne
import com.example.bottomnavigation.bottomNavFragment.FragmentThree
import com.example.bottomnavigation.bottomNavFragment.FragmentTwo
import com.example.bottomnavigation.R
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.floatingactionbutton.FloatingActionButton

class FragmentFabCentered:Fragment(R.layout.fragment_fab_centered) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        replaceFragment(FragmentOne())

        val bottomNavigation = view.findViewById<BottomNavigationView>(R.id.bottom_navigation)
        val fab = view.findViewById<FloatingActionButton>(R.id.fab)


        bottomNavigation.background = null

        bottomNavigation.setOnItemSelectedListener {
            when(it.itemId){
                R.id.one -> replaceFragment(FragmentOne())
                R.id.two -> replaceFragment(FragmentTwo())
                R.id.three -> replaceFragment(FragmentThree())
                R.id.four -> replaceFragment(FragmentFour())
            }
            true
        }



    }

    private fun replaceFragment(fragment: Fragment) {
        if (fragment != null) {
            val transaction = parentFragmentManager.beginTransaction()
            transaction.replace(R.id.container, fragment)
            transaction.commit()
        }
    }

}
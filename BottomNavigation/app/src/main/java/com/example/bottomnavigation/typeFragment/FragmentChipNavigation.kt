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
import com.ismaeldivita.chipnavigation.ChipNavigationBar

class FragmentChipNavigation:Fragment(R.layout.fragment_chip_navigation) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        replaceFragment(FragmentOne())

        val chipNavigation = view.findViewById<ChipNavigationBar>(R.id.chip_navigation)

        chipNavigation.setItemSelected(R.id.one,
            true)

        chipNavigation.setOnItemSelectedListener {
            when(it){
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
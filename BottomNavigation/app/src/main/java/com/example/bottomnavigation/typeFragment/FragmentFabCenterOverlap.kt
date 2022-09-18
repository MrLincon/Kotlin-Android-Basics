package com.example.bottomnavigation.typeFragment

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.example.bottomnavigation.bottomNavFragment.FragmentOne
import com.example.bottomnavigation.bottomNavFragment.FragmentThree
import com.example.bottomnavigation.bottomNavFragment.FragmentTwo
import com.example.bottomnavigation.R
import com.google.android.material.bottomappbar.BottomAppBar
import com.google.android.material.floatingactionbutton.FloatingActionButton

class FragmentFabCenterOverlap:Fragment(R.layout.fragment_fab_centered_overlap) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        replaceFragment(FragmentOne())

        val bottomAppBar = view.findViewById<BottomAppBar>(R.id.bottom_appbar)
        val fab = view.findViewById<FloatingActionButton>(R.id.fab)


        bottomAppBar.setOnMenuItemClickListener {
            when(it.itemId){
                R.id.one -> replaceFragment(FragmentOne())
                R.id.two -> replaceFragment(FragmentTwo())
                R.id.three -> replaceFragment(FragmentThree())
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
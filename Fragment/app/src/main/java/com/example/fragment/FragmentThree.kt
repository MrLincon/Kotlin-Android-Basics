package com.example.fragment

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.google.android.material.floatingactionbutton.FloatingActionButton

class FragmentThree: Fragment(R.layout.fragment_three) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val close = view.findViewById<FloatingActionButton>(R.id.close)

        close.setOnClickListener {
            activity?.onBackPressed()
        }
    }

}
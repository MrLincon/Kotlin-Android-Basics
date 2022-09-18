package com.example.selectionmethods

import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.fragment.app.Fragment
import com.google.android.material.floatingactionbutton.FloatingActionButton

class FragmentSwitch:Fragment(R.layout.fragment_switch) {

    private lateinit var switch: Switch
    private lateinit var switchStatus: TextView

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val close = view.findViewById<FloatingActionButton>(R.id.close)
        switch = view.findViewById(R.id.switch1)
        switchStatus = view.findViewById(R.id.switch_text)


        switch.setOnClickListener {
            if (switch.isChecked){
                switchStatus.text = "Turn Off"
            }else{
                switchStatus.text = "Turn On"
            }
        }


        close.setOnClickListener {
            activity?.onBackPressed()
        }

    }
}
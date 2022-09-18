package com.example.selectionmethods

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.google.android.material.floatingactionbutton.FloatingActionButton

class FragmentRadioButton:Fragment(R.layout.fragment_radio_button) {

    private lateinit var radioGroup: RadioGroup
    private lateinit var radioButton: RadioButton
    private lateinit var check: Button

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val close = view.findViewById<FloatingActionButton>(R.id.close)
        radioGroup = view.findViewById(R.id.radio_group)
        check = view.findViewById(R.id.rb_check)

        check.setOnClickListener {
            val intSelected: Int = radioGroup!!.checkedRadioButtonId
            radioButton = view.findViewById(intSelected)

            if (radioButton.text != "One"){
                Toast.makeText(context, "Wrong answer!", Toast.LENGTH_SHORT).show()
            }else{
                Toast.makeText(context, "Right answer!", Toast.LENGTH_SHORT).show()
            }
        }

        close.setOnClickListener {
            activity?.onBackPressed()
        }

    }
}
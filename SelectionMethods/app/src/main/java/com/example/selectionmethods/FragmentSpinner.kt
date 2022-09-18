package com.example.selectionmethods

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.*
import androidx.fragment.app.Fragment
import com.google.android.material.floatingactionbutton.FloatingActionButton

class FragmentSpinner:Fragment(R.layout.fragment_spinner) {

    private lateinit var numbers: Array<String>
    private lateinit var spinner: Spinner
    private lateinit var select: Button
    lateinit var spinnerText: String

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val close = view.findViewById<FloatingActionButton>(R.id.close)

        numbers = resources.getStringArray(R.array.numbers)


        spinner = view.findViewById(R.id.spinner)
        select = view.findViewById(R.id.spinner_btn)


        val adapter = context?.let { ArrayAdapter(it,R.layout.spinner_layout,numbers) }
        spinner.adapter = adapter

        spinner.onItemSelectedListener = object: AdapterView.OnItemSelectedListener,
            AdapterView.OnItemClickListener {
            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                spinnerText = numbers[p2]
                Log.d("selected number", "onItemSelected: "+spinnerText)
            }

            override fun onNothingSelected(p0: AdapterView<*>?) {
                TODO("Not yet implemented")
            }

            override fun onItemClick(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                TODO("Not yet implemented")
            }


        }

        select.setOnClickListener {
            Toast.makeText(context, spinnerText, Toast.LENGTH_SHORT).show()
        }


        close.setOnClickListener {
            activity?.onBackPressed()
        }

    }
}
package com.example.listview

import android.app.Activity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.Toast
import androidx.fragment.app.Fragment

class FragmentSimple: Fragment(R.layout.fragment_simple)  {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val listView = view.findViewById<ListView>(R.id.list_view)
        val arrayAdapter: ArrayAdapter<*>
        val languages = arrayOf("C", "C++", "C#", "Java", "Kotlin", "Python", "JavaScript", "PHP", "Ruby", "Swift", "Scala", "Go", "TypeScript", "Dart"
        ,"Rust", "Groovy", "SQL")

        arrayAdapter = ArrayAdapter(requireContext(), android.R.layout.simple_list_item_1, languages)
        listView.adapter = arrayAdapter

        listView.onItemClickListener = AdapterView.OnItemClickListener { adapterView, view, position, id ->

            val selectedItem = adapterView.getItemAtPosition(position) as String
            val itemPosition = adapterView.getItemIdAtPosition(position)

            Log.d("position", "onCreate: $itemPosition")
            Toast.makeText(requireContext(), "Selected:  $selectedItem", Toast.LENGTH_SHORT).show()
        }
    }
}
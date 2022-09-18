package com.example.listview

import android.app.Activity
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView

class ListAdapter(private val context: Activity, private val imageId: Array<Int>, private val title: Array<String>)
    : ArrayAdapter<String>(context, R.layout.list_view_layout, title) {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val view = context.layoutInflater.inflate(R.layout.list_view_layout, null, true)

        val image = view.findViewById<ImageView>(R.id.image)
        val tvTitle = view.findViewById<TextView>(R.id.title)

        image.setImageResource(imageId[position])
        tvTitle.text = title[position]

        return view
    }

}

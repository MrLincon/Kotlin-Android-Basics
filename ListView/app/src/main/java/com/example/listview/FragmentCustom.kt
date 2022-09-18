package com.example.listview

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.*
import androidx.fragment.app.Fragment
import com.google.android.material.bottomsheet.BottomSheetDialog

class FragmentCustom : Fragment(R.layout.fragment_simple) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val listView = view.findViewById<ListView>(R.id.list_view)

        val languages = arrayOf(
            "C", "C++", "C#", "Java", "Kotlin", "Python", "Java Script", "PHP", "Ruby",
            "Swift", "Scala", "Go", "TypeScript", "Dart", "Rust", "Groovy", "SQL"
        )
        val imageId = arrayOf(
            R.drawable.ic_1,
            R.drawable.ic_2,
            R.drawable.ic_3,
            R.drawable.ic_4,
            R.drawable.ic_5,
            R.drawable.ic_6,
            R.drawable.ic_7,
            R.drawable.ic_8,
            R.drawable.ic_9,
            R.drawable.ic_9plus,
            R.drawable.ic_9plus,
            R.drawable.ic_9plus,
            R.drawable.ic_9plus,
            R.drawable.ic_9plus,
            R.drawable.ic_9plus,
            R.drawable.ic_9plus,
            R.drawable.ic_9plus
        )

        val listAdapter = ListAdapter(requireActivity(), imageId, languages)
        listView.adapter = listAdapter
        listView.divider = null

        listView.onItemClickListener =
            AdapterView.OnItemClickListener { adapterView, view, position, id ->

                val selectedItem = adapterView.getItemAtPosition(position) as String
                val itemPosition = adapterView.getItemIdAtPosition(position)

                val intent = Intent(requireActivity(), DetailsActivityCustom::class.java)
                intent.putExtra("item", selectedItem)
                intent.putExtra("position", itemPosition)
                startActivity(intent)

                Log.d("position", "onCreate: Item - $selectedItem   Position - $itemPosition")
            }

        listView.onItemLongClickListener =
            AdapterView.OnItemLongClickListener { adapterView, view, position, id ->

                val selectedItem = adapterView.getItemAtPosition(position) as String
                val itemPosition = adapterView.getItemIdAtPosition(position)
                val pos = itemPosition?.toInt()

                val dialog = BottomSheetDialog(requireContext())

                val view = layoutInflater.inflate(R.layout.bottom_sheet_custom_details, null)
                dialog.setCancelable(true)
                dialog.setContentView(view)

                val image = view.findViewById<ImageView>(R.id.image)
                val item = view.findViewById<TextView>(R.id.item)

                item.text = selectedItem

                when (pos) {
                    0 -> image.setImageResource(R.drawable.ic_1)
                    1 -> image.setImageResource(R.drawable.ic_2)
                    2 -> image.setImageResource(R.drawable.ic_3)
                    3 -> image.setImageResource(R.drawable.ic_4)
                    4 -> image.setImageResource(R.drawable.ic_5)
                    5 -> image.setImageResource(R.drawable.ic_6)
                    6 -> image.setImageResource(R.drawable.ic_7)
                    7 -> image.setImageResource(R.drawable.ic_8)
                    8 -> image.setImageResource(R.drawable.ic_9)
                    else -> {
                        image.setImageResource(R.drawable.ic_9plus)
                    }
                }


                dialog.show()

                true
            }
    }
}
package com.example.bottomsheet

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.cardview.widget.CardView
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

class MainActivity : AppCompatActivity() {

    lateinit var cardOne: CardView
    lateinit var cardTwo: CardView
    lateinit var cardThree: CardView
    lateinit var cardFour: CardView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        cardOne = findViewById(R.id.card_one)
        cardTwo = findViewById(R.id.card_two)
        cardThree = findViewById(R.id.card_three)
        cardFour = findViewById(R.id.card_four)

        cardOne.setOnClickListener {
            val dialog = BottomSheetDialog(this)

            val view = layoutInflater.inflate(R.layout.bottom_sheet_dialog, null)
            dialog.setCancelable(true)
            dialog.setContentView(view)

            val button = view.findViewById<Button>(R.id.button)

            button.setOnClickListener {
                Toast.makeText(this, "Working!", Toast.LENGTH_SHORT).show()
            }
            dialog.show()

        }

        cardTwo.setOnClickListener {
            val bottomSheet: BottomSheetDialogFragment = BottomSheet()
            bottomSheet.show(supportFragmentManager,"Bottom Sheet")
        }

        cardThree.setOnClickListener {
            val bottomSheet: BottomSheetDialogFragment = BottomSheet()
            bottomSheet.show(supportFragmentManager,"Bottom Sheet")

        }

        cardFour.setOnClickListener {
            val bottomSheet: BottomSheetDialogFragment = BottomSheet()
            bottomSheet.show(supportFragmentManager,"Bottom Sheet")
        }

    }
}
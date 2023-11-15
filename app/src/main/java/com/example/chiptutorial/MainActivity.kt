package com.example.chiptutorial

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import com.google.android.material.chip.Chip
import com.google.android.material.chip.ChipGroup

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val chipGp = findViewById<ChipGroup>(R.id.chipGp)
        val btnShowChip = findViewById<Button>(R.id.btnShowChip)

        for (i in 1..10) {
            val chip = Chip(this)
            chip.text = "Chip $i"
            chip.isCheckable = true
            chipGp.addView(chip)

            chip.setOnClickListener {
                print("ddd")
                if (chipGp.checkedChipIds.size > 5) chip.isChecked = false
            }
        }

        btnShowChip.setOnClickListener {
            val selectedChipString = StringBuilder()

            for (i in chipGp.checkedChipIds) {
                val chip = chipGp.getChildAt(i - 1) as Chip
                selectedChipString.append(chip.text)
            }
            Toast.makeText(this, selectedChipString, Toast.LENGTH_SHORT).show()
        }
    }
}
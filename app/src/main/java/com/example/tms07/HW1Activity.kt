package com.example.tms07

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import com.squareup.picasso.Picasso

class HW1Activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_hw1)

        val buttonDownloadPicture = findViewById<Button>(R.id.buttonDownloadPicture)
        val inputUserText = findViewById<EditText>(R.id.inputFieldURL)
        val pictureOutput = findViewById<ImageView>(R.id.pictureOutput)

        buttonDownloadPicture.setOnClickListener {
            Picasso.get()
                .load(inputUserText.text.toString())
                .into(pictureOutput)
        }
    }
}
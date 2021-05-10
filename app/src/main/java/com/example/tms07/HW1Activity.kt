package com.example.tms07

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import com.squareup.picasso.Picasso

class HW1Activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_hw1)

        val buttonDownloadPicture = findViewById<Button>(R.id.buttonDownloadPicture)
        val inputUserText = findViewById<EditText>(R.id.inputFieldURL)
        val pictureOutput = findViewById<ImageView>(R.id.picture_output)

        buttonDownloadPicture.setOnClickListener {

            if (inputUserText.text.toString().isEmpty()) {
                inputUserText.error = getString(R.string.error_empty_url)
            } else {
                Picasso.get()
                    .load(inputUserText.text.toString())
                    .placeholder(R.drawable.load_picture)
                    .error(R.drawable.ic_not_found)
                    .into(pictureOutput)
            }
        }
    }
}
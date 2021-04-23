package com.example.tms07

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.lifecycle.ViewModelProvider

class HW4Activity : AppCompatActivity() {

    lateinit var viewModel: MainViewModelSnowdrop

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_hw4)

        viewModel = ViewModelProvider(this).get(MainViewModelSnowdrop::class.java)

        val fragmentStepFirst = StepFirstFragment()
        val fragmentInfo = InfoFragment()

        val buttonAddSnowdrop = findViewById<Button>(R.id.button_add_snowdrop)
        val buttonShowInfo = findViewById<Button>(R.id.button_show_info)

        buttonAddSnowdrop.setOnClickListener {
            supportFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, fragmentStepFirst).commit()
        }

        buttonShowInfo.setOnClickListener {
            supportFragmentManager.beginTransaction().replace(R.id.fragment_container, fragmentInfo)
                .commit()
        }
    }
}
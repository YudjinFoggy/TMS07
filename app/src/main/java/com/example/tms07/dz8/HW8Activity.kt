package com.example.tms07.dz8

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import com.example.tms07.R
import com.example.tms07.dz8.recycler8.CoinAdapter
import com.example.tms07.recycler7.CarAdapter
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import retrofit2.Response.error

class HW8Activity : AppCompatActivity() {

    private val viewModel by lazy { ViewModelProvider(this).get(MainViewModel8::class.java) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_hw8)

        val recycler = findViewById<RecyclerView>(R.id.recycler8)

        viewModel.loadRates("18e290dd-2c6f-46b6-8f70-084986b595a2")

        viewModel.rates.observe(this) {
            val coinAdapter = CoinAdapter(it)
            recycler.adapter = coinAdapter
        }

        viewModel.errorBus.observe(this) {
            MaterialAlertDialogBuilder(this)
                .setTitle(getString(R.string.error))
                .setMessage(it)
                .show()
        }

        viewModel.rates.observe(this) {
            val coinAdapter = CoinAdapter(it)
            recycler.adapter = coinAdapter
        }
    }
}
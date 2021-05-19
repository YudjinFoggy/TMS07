package com.example.tms07

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import com.example.tms07.database.entity.Car
import com.example.tms07.recycler7.CarAdapter
import android.widget.ArrayAdapter

class HW7Activity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_hw7)

        val textBrand = findViewById<EditText>(R.id.text_brand)
        val textYear = findViewById<EditText>(R.id.text_year)
        val textPrice = findViewById<EditText>(R.id.text_price)
        val progressBar = findViewById<ProgressBar>(R.id.progress_bar)

        val buttonSearch = findViewById<ImageButton>(R.id.search_button)
        val hints = resources.getStringArray(R.array.brand)
        val search = findViewById<AutoCompleteTextView>(R.id.auto_search)
        val arrAdapter = ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, hints)
        search.setAdapter(arrAdapter)


        val addButton = findViewById<Button>(R.id.button_add)
        val deleteButton = findViewById<Button>(R.id.button_delete)

        val recycler = findViewById<RecyclerView>(R.id.recycler)
        val loadButton = findViewById<Button>(R.id.load_button)


        val viewModel =
            ViewModelProvider.AndroidViewModelFactory(application)
                .create(MainViewModel7::class.java)

        addButton.setOnClickListener {
            viewModel.insert(
                Car(
                    textBrand.text.toString(),
                    textYear.text.toString().toInt(),
                    textPrice.text.toString().toDouble()
                )
            )

            textBrand.text = null
            textYear.text = null
            textPrice.text = null
        }

        deleteButton.setOnClickListener {
            if (textBrand.text.toString().isNotEmpty() && textYear.text.toString()
                    .isNotEmpty() && textPrice.text.toString()
                    .isNotEmpty()
            ) {
                viewModel.deleteItem(
                    textBrand.text.toString(),
                    textYear.text.toString().toInt(),
                    textPrice.text.toString().toDouble()
                )
            }

            textBrand.text = null
            textYear.text = null
            textPrice.text = null
        }

        viewModel.carList.observe(this) {
            val carAdapter = CarAdapter(it)
            recycler.adapter = carAdapter
        }

        viewModel.isLoading.observe(this) {
            if (it) progressBar.visibility = View.VISIBLE
            else progressBar.visibility = View.GONE
        }

        loadButton.setOnClickListener {
            viewModel.loadAllCars()
        }

        buttonSearch.setOnClickListener {
            if (search.text.isEmpty()) {
                viewModel.carList.observe(this) {
                    val adapter = CarAdapter(it)
                    recycler.adapter = adapter
                }
            } else {
                viewModel.searchBrand(search.text.toString())
                viewModel.brandList.observe(this) {
                    val adapter = CarAdapter(it)
                    recycler.adapter = adapter
                }
            }
        }
    }
}
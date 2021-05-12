package com.example.tms07.recycler7

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.graphics.drawable.toDrawable
import androidx.recyclerview.widget.RecyclerView
import com.example.tms07.MainViewModel7
import com.example.tms07.R
import com.example.tms07.database.entity.Car
import com.google.android.material.snackbar.Snackbar

class CarAdapter(val cars: List<Car>, val viewModel7: MainViewModel7) :
    RecyclerView.Adapter<CarAdapter.CarViewHolder>() {

    inner class CarViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {

        fun setData(itemView: View, position: Int) {

            val car = cars[position]

            itemView.findViewById<ImageView>(R.id.item_photo)
            itemView.findViewById<TextView>(R.id.item_brand).text = car.brand
            itemView.findViewById<TextView>(R.id.item_year).text = car.year.toString()
            itemView.findViewById<TextView>(R.id.item_price).text = car.price.toString()

            itemView.findViewById<ConstraintLayout>(R.id.item_container).setOnClickListener {
                Snackbar.make(view, car.brand, Snackbar.LENGTH_SHORT).show()
            }
        }
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): CarViewHolder {

        val view = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.item_car7, viewGroup, false)
        return CarViewHolder(view)
    }

    override fun onBindViewHolder(viewHolder: CarViewHolder, position: Int) {
        viewHolder.setData(viewHolder.itemView, position)
    }

    override fun getItemCount() = cars.size
}

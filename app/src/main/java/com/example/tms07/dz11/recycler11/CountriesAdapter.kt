package com.example.tms07.dz11.recycler11

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.tms07.R
import com.example.tms07.dz11.data.entity.CountriesWithHolidays

class CountriesAdapter() :
    RecyclerView.Adapter<CountriesAdapter.CountriesViewHolder>() {

    private var list = ArrayList<CountriesWithHolidays>()

    fun init(newList: ArrayList<CountriesWithHolidays>) {
        list = newList
        notifyDataSetChanged()
    }

    fun updateItem(item: CountriesWithHolidays?) {
        val oldItem = list.find {
            it.codeCountry == item?.codeCountry
        }
        val oldItemIndex = list.indexOf(oldItem)

        if (item != null) {
            list[oldItemIndex] = item
        }

        notifyItemChanged(oldItemIndex)
    }

    fun getCurrentList() = list

    inner class CountriesViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {

        fun bind(item: CountriesWithHolidays) {

            Glide.with(view.context)
                .load("https://www.countryflags.io/${item.codeCountry}/flat/64.png")
                .into(itemView.findViewById(R.id.country_photo))
            view.findViewById<TextView>(R.id.country_name).text = item.nameCountry

            if (item.nameHoliday != null) {
                view.findViewById<ProgressBar>(R.id.progress_bar_holiday).visibility = View.GONE
                view.findViewById<TextView>(R.id.name_holiday).text = item.nameHoliday
                view.findViewById<TextView>(R.id.date_holiday).text = item.date
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CountriesViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_country11, parent, false)
        return CountriesViewHolder(view)
    }

    override fun onBindViewHolder(holder: CountriesViewHolder, position: Int) {
        holder.bind(list[position])
    }

    override fun getItemCount() = list.size
}
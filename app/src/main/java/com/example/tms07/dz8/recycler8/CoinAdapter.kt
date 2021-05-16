package com.example.tms07.dz8.recycler8

import android.graphics.Color.red
import android.graphics.drawable.Drawable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.tms07.R
import com.example.tms07.dz8.data.entities.currency.Rate
import java.util.*
import kotlin.math.roundToInt

class CoinAdapter(val coins: List<Rate>) : RecyclerView.Adapter<CoinAdapter.CoinViewHolder>() {

    inner class CoinViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {

        fun setData(itemView: View, position: Int) {

            val coin = coins[position]

            val randomColor = arrayListOf<Int>()
            randomColor.add(R.drawable.shape_oval_blue)
            randomColor.add(R.drawable.shape_oval_red)
            randomColor.add(R.drawable.shape_oval_green)
            randomColor.add(R.drawable.shape_oval_yellow)

            itemView.findViewById<TextView>(R.id.coin_photo).apply {
                this.text = (coin.name?.first().toString())
                this.setBackgroundResource((randomColor[Random().nextInt(randomColor.size)]))
            }

            itemView.findViewById<TextView>(R.id.coin_name).text = coin.name
            itemView.findViewById<TextView>(R.id.coin_price).text =
                coin.price?.roundToInt()?.times(100.00)?.div(100.00).toString()

            itemView.findViewById<TextView>(R.id.data_coin).text = coin.symbol.toString()
            itemView.findViewById<TextView>(R.id.coin_percent).text =
                coin.percentChange1h?.roundToInt()?.times(100.00)?.div(100.00).toString()
        }
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): CoinViewHolder {

        val view = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.item_coin8, viewGroup, false)
        return CoinViewHolder(view)
    }

    override fun onBindViewHolder(viewHolder: CoinViewHolder, position: Int) {
        viewHolder.setData(viewHolder.itemView, position)
    }

    override fun getItemCount() = coins.size
}
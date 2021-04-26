package com.example.tms07

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider

class InfoFragment : Fragment() {

    val viewModel by lazy {
        ViewModelProvider(requireActivity()).get(MainViewModelSnowdrop::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_info, container, false)
    }

    @SuppressLint("SetTextI18n")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val infoName = view.findViewById<TextView>(R.id.info_name)

        with(viewModel.getArrSnowdrops().value) {
            if(this?.size != 0) {
                infoName.text = this.toString()
            } else {
                infoName.text = "Base is empty.\nEnter the data, please"
            }
        }
    }
}
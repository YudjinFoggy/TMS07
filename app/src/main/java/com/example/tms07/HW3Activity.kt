package com.example.tms07

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider

class HW3Activity : AppCompatActivity() {

    lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_hw3)

        //Brest
        val cornInBrest = findViewById<TextView>(R.id.amountOfCornInBrest)
        val potatoesInBrest = findViewById<TextView>(R.id.amountOfPotatoesInBrest)
        val cabbageInBrest = findViewById<TextView>(R.id.amountOfCabbageInBrest)
        val beetInBrest = findViewById<TextView>(R.id.amountOfBeetInBrest)

        var harvestOfCornBrest = 0
        var harvestOfPotatoesBrest = 0
        var harvestOfCabbageBrest = 0
        var harvestOfBeetBrest = 0

        //Vitebsk
        val cornInVitebsk = findViewById<TextView>(R.id.amountOfCornInVitebsk)
        val potatoesInVitebsk = findViewById<TextView>(R.id.amountOfPotatoesInVitebsk)
        val cabbageInVitebsk = findViewById<TextView>(R.id.amountOfCabbageInVitebsk)
        val beetInVitebsk = findViewById<TextView>(R.id.amountOfBeetInVitebsk)

        var harvestOfCornVitebsk = 0
        var harvestOfPotatoesVitebsk = 0
        var harvestOfCabbageVitebsk = 0
        var harvestOfBeetVitebsk = 0

        //Gomel
        val cornInGomel = findViewById<TextView>(R.id.amountOfCornInGomel)
        val potatoesInGomel = findViewById<TextView>(R.id.amountOfPotatoesInGomel)
        val cabbageInGomel = findViewById<TextView>(R.id.amountOfCabbageInGomel)
        val beetInGomel = findViewById<TextView>(R.id.amountOfBeetInGomel)

        var harvestOfCornGomel = 0
        var harvestOfPotatoesGomel = 0
        var harvestOfCabbageGomel = 0
        var harvestOfBeetGomel = 0

        //Grodno
        val cornInGrodno = findViewById<TextView>(R.id.amountOfCornInGrodno)
        val potatoesInGrodno = findViewById<TextView>(R.id.amountOfPotatoesInGrodno)
        val cabbageInGrodno = findViewById<TextView>(R.id.amountOfCabbageInGrodno)
        val beetInGrodno = findViewById<TextView>(R.id.amountOfBeetInGrodno)

        var harvestOfCornGrodno = 0
        var harvestOfPotatoesGrodno = 0
        var harvestOfCabbageGrodno = 0
        var harvestOfBeetGrodno = 0

        //Minsk
        val cornInMinsk = findViewById<TextView>(R.id.amountOfCornInMinsk)
        val potatoesInMinsk = findViewById<TextView>(R.id.amountOfPotatoesInMinsk)
        val cabbageInMinsk = findViewById<TextView>(R.id.amountOfCabbageInMinsk)
        val beetInMinsk = findViewById<TextView>(R.id.amountOfBeetInMinsk)

        var harvestOfCornMinsk = 0
        var harvestOfPotatoesMinsk = 0
        var harvestOfCabbageMinsk = 0
        var harvestOfBeetMinsk = 0

        //Mogilev
        val cornInMogilev = findViewById<TextView>(R.id.amountOfCornInMogilev)
        val potatoesInMogilev = findViewById<TextView>(R.id.amountOfPotatoesInMogilev)
        val cabbageInMogilev = findViewById<TextView>(R.id.amountOfCabbageInMogilev)
        val beetInMogilev = findViewById<TextView>(R.id.amountOfBeetInMogilev)

        var harvestOfCornMogilev = 0
        var harvestOfPotatoesMogilev = 0
        var harvestOfCabbageMogilev = 0
        var harvestOfBeetMogilev = 0

        val timer = findViewById<TextView>(R.id.timer)
        val buttonStart = findViewById<Button>(R.id.button_start)

        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)

        viewModel.productQuantity.observe(this) {

            //Brest
            harvestOfCornBrest = getTotalHarvest(harvestOfCornBrest, cornInBrest, it)
            harvestOfPotatoesBrest = getTotalHarvest(harvestOfPotatoesBrest, potatoesInBrest, it)
            harvestOfCabbageBrest = getTotalHarvest(harvestOfCabbageBrest, cabbageInBrest, it)
            harvestOfBeetBrest = getTotalHarvest(harvestOfBeetBrest, beetInBrest, it)

            //Vitebsk
            harvestOfCornVitebsk = getTotalHarvest(harvestOfCornVitebsk, cornInVitebsk, it)
            harvestOfPotatoesVitebsk = getTotalHarvest(harvestOfPotatoesVitebsk, potatoesInVitebsk, it)
            harvestOfCabbageVitebsk = getTotalHarvest(harvestOfCabbageVitebsk, cabbageInVitebsk, it)
            harvestOfBeetVitebsk = getTotalHarvest(harvestOfBeetVitebsk, beetInVitebsk, it)

            //Gomel
            harvestOfCornGomel = getTotalHarvest(harvestOfCornGomel, cornInGomel, it)
            harvestOfPotatoesGomel = getTotalHarvest(harvestOfPotatoesGomel, potatoesInGomel, it)
            harvestOfCabbageGomel = getTotalHarvest(harvestOfCabbageGomel, cabbageInGomel, it)
            harvestOfBeetGomel = getTotalHarvest(harvestOfBeetGomel, beetInGomel, it)

            //Grodno
            harvestOfCornGrodno = getTotalHarvest(harvestOfCornGrodno, cornInGrodno, it)
            harvestOfPotatoesGrodno = getTotalHarvest(harvestOfPotatoesGrodno, potatoesInGrodno, it)
            harvestOfCabbageGrodno = getTotalHarvest(harvestOfCabbageGrodno, cabbageInGrodno, it)
            harvestOfBeetGrodno = getTotalHarvest(harvestOfBeetGrodno, beetInGrodno, it)

            //Minsk
            harvestOfCornMinsk = getTotalHarvest(harvestOfCornMinsk, cornInMinsk, it)
            harvestOfPotatoesMinsk = getTotalHarvest(harvestOfPotatoesMinsk, potatoesInMinsk, it)
            harvestOfCabbageMinsk = getTotalHarvest(harvestOfCabbageMinsk, cabbageInMinsk, it)
            harvestOfBeetMinsk = getTotalHarvest(harvestOfBeetMinsk, beetInMinsk, it)

            //Mogilev
            harvestOfCornMogilev = getTotalHarvest(harvestOfCornMogilev, cornInMogilev, it)
            harvestOfPotatoesMogilev = getTotalHarvest(harvestOfPotatoesMogilev, potatoesInMogilev, it)
            harvestOfCabbageMogilev = getTotalHarvest(harvestOfCabbageMogilev, cabbageInMogilev, it)
            harvestOfBeetMogilev = getTotalHarvest(harvestOfBeetMogilev, beetInMogilev, it)
        }

        viewModel.timeLeft.observe(this) {
            timer.text = it.toString()
        }

        buttonStart.setOnClickListener {
            viewModel.startTimerToGetArrayOfRandomNumbers()
            viewModel.startTimer()
        }
    }
}

fun getTotalHarvest(harvest: Int, textView: TextView, list: List<Int>): Int {

    var amountTotalHarvest = harvest

    if (amountTotalHarvest <= 1200) {
        amountTotalHarvest += list[(list.indices).random()]
        textView.text = amountTotalHarvest.toString()
    }
    return amountTotalHarvest
}

package com.example.tms07.dz11

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.View
import android.widget.ProgressBar
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.tms07.R
import com.example.tms07.dz11.data.entity.CountriesWithHolidays
import com.example.tms07.dz11.mappers.RateResponseCountryMapper
import com.example.tms07.dz11.networking.api.Api
import com.example.tms07.dz11.recycler11.CountriesAdapter
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.schedulers.Schedulers
import java.util.*
import kotlin.collections.ArrayList

class HW11Activity : AppCompatActivity() {

    companion object {
        const val API_KEY = "b0e6b985-b702-4a23-bf23-4cd296e56a87"
    }

    lateinit var disposables: CompositeDisposable

    @SuppressLint("SimpleDateFormat")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_hw11)

        val adapter = CountriesAdapter()

        val recycler = findViewById<RecyclerView>(R.id.recycler11)

        recycler.layoutManager = LinearLayoutManager(this)
        recycler.adapter = adapter

        disposables = CompositeDisposable()

        Api.providerRetrofit().getCountries(API_KEY)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .flatMap {
                val list = it.countries?.map {
                    RateResponseCountryMapper().map(it)
                }

                findViewById<ProgressBar>(R.id.progress_bar).visibility = View.GONE

                val listCountryWithHoliday = list?.map { rateCountries ->
                    CountriesWithHolidays(
                        codeCountry = rateCountries.code,
                        nameCountry = rateCountries.name
                    )
                }

                adapter.init(listCountryWithHoliday as ArrayList<CountriesWithHolidays>)

                Observable.fromIterable(listCountryWithHoliday).subscribeOn(Schedulers.io())
            }
            .subscribe({ countryWithHoliday ->
                Api.providerRetrofit()
                    .getHolidays(
                        API_KEY,
                        countryCode = countryWithHoliday.codeCountry.orEmpty(),
                        "2020",
                        (Calendar.getInstance().get(Calendar.MONTH) + 1).toString(),
                        Calendar.getInstance().get(Calendar.DAY_OF_MONTH).toString()
                    )
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe({
                        val oldList = adapter.getCurrentList()
                        val oldCountryWithHoliday = oldList.find {
                            it.codeCountry == countryWithHoliday.codeCountry
                        }

                        oldCountryWithHoliday?.nameHoliday = it.holidays?.get(0)?.name.orEmpty()
                        oldCountryWithHoliday?.date = it.holidays?.get(0)?.date.orEmpty()
                        adapter.updateItem(oldCountryWithHoliday)
                    }, {})
            }, {})
    }

    override fun onDestroy() {
        super.onDestroy()
        disposables.clear()
    }
}
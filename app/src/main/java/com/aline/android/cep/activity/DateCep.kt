package com.aline.android.cep.activity

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.app.NavUtils
import android.util.Log
import android.view.MenuItem
import android.view.View
import com.aline.android.cep.R
import com.aline.android.cep.model.CEP
import com.aline.android.cep.rest.getCepService
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_date_cep.*

class DateCep : AppCompatActivity() {

    private val LOG: String = DateCep::class.java.simpleName

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_date_cep)

        supportActionBar!!.setHomeButtonEnabled(true)
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)

        val cep: String = intent.getStringExtra("CEP")
        if (!cep.isEmpty()) getData(cep)
    }

    private fun getData(cep: String) {

       val stringBuilder  = cep.replace("-", "")

        progress.visibility = View.VISIBLE

        getCepService().getDataCep(stringBuilder)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                        { result -> handleResult(result) },
                        { error -> handleError(error) }
                )
    }

    fun handleError(error: Throwable?) {
        progress.visibility = View.GONE
        Log.e(LOG, "Error: " + error?.message)
        label_cep_not_found.visibility = View.VISIBLE
    }

    fun handleResult(result: CEP?) {
        progress.visibility = View.GONE
        linear_cep.visibility = View.VISIBLE

        val stringBuilder = StringBuilder(result?.cep)
        stringBuilder.insert(stringBuilder.length - 3, "-")
        cep_value.text = stringBuilder
        adress_type.text = result?.addressType
        adress_name.text = result?.addressName
        district_value.text = result?.district
        city_value.text = result?.city
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        when(item?.itemId){
            android.R.id.home -> {
                NavUtils.navigateUpFromSameTask(this)
                return true
            }
        }
        return super.onOptionsItemSelected(item)
    }

}




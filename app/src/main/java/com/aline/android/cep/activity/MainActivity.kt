package com.aline.android.cep.activity

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.aline.android.cep.R
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btn_send.setOnClickListener {
            isValidCep()
        }
    }

    private fun isValidCep() {
        val cepUser = edit_cep.text.trim().toString()
        if (!cepUser.isEmpty() && cepUser.length >= 8){
            val intent = Intent(this@MainActivity, DateCep::class.java)
           intent.putExtra("CEP", cepUser)
            startActivity(intent)
        } else edit_cep.setError("Favor preencher corretamente")
    }
}

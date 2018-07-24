package com.aline.android.cep.rest

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

class RetrofitConfig<T> {

    fun getClient(c: Class<T>): T {

        val builder = OkHttpClient.Builder()
                .connectTimeout(240, TimeUnit.SECONDS)
                .readTimeout(240, TimeUnit.SECONDS)
                .writeTimeout(240, TimeUnit.SECONDS)


        val retrofit: Retrofit = Retrofit.Builder()
                .client(builder.build())
                .baseUrl("https://cep.awesomeapi.com.br")
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build()

        return retrofit.create(c)
    }
}

fun getCepService(): CepService {
    return RetrofitConfig<CepService>().getClient(CepService::class.java)

}
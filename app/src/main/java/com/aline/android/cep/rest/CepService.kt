package com.aline.android.cep.rest


import com.aline.android.cep.model.CEP
import io.reactivex.Observable
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Path

interface CepService {

    @GET("/json/{cep}")
    fun getDataCep(@Path("cep") cep : String ) : Observable<CEP>
}
package br.com.caelum.casadocodigo.client

import br.com.caelum.casadocodigo.converter.LivroServiceConverterFactory
import retrofit2.Retrofit

object InicializadorDoRetrofit {

    const val SERVER_URL = "https://cdcmob.herokuapp.com/"

    val retrofit : Retrofit = Retrofit.Builder()
            .baseUrl(SERVER_URL)
            .addConverterFactory(LivroServiceConverterFactory())
            .build()

}
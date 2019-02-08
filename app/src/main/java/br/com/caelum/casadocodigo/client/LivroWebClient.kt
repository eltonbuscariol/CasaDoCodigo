package br.com.caelum.casadocodigo.client

import br.com.caelum.casadocodigo.delegate.LivrosDelegate
import br.com.caelum.casadocodigo.modelo.Livro
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

import retrofit2.http.GET
import retrofit2.http.Query

class LivroWebClient(private val delegate: LivrosDelegate) {

    private val service = InicializadorDoRetrofit.retrofit.create(LivroService::class.java)

    fun getLivros(indicePrimeiroLivro : Int, qtdLivros : Int){
        service.getLivros(indicePrimeiroLivro, qtdLivros).enqueue(object : Callback<List<Livro>>{
            override fun onFailure(call: Call<List<Livro>>, t: Throwable) {
                delegate.lidaComFalha(t)
            }

            override fun onResponse(call: Call<List<Livro>>, response: Response<List<Livro>>) {
                response.body()?.let { delegate.lidaComSucesso(it) }
            }
        })
    }

    private interface LivroService{

        @GET("listarLivros")
        fun getLivros(@Query("indicePrimeiroLivro") indicePrimeiroLivro: Int, @Query("qtdLivros") qtdLivros: Int) : Call<List<Livro>>
    }
}
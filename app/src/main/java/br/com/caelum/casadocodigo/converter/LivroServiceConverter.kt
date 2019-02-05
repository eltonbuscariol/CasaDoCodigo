package br.com.caelum.casadocodigo.converter


import java.io.IOException

import br.com.caelum.casadocodigo.modelo.Livro
import okhttp3.ResponseBody
import retrofit2.Converter

class LivroServiceConverter : Converter<ResponseBody, List<Livro>> {

    @Throws(IOException::class)
    override fun convert(value: ResponseBody): List<Livro>? {

        val json = value.string()
        val livroConverter = LivroConverter()

        return livroConverter.fromJson(json)
    }
}

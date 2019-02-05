package br.com.caelum.casadocodigo.converter

import java.io.IOException

import okhttp3.MediaType
import okhttp3.RequestBody
import retrofit2.Converter

class ItemServiceRequestConverter : Converter<String, RequestBody> {

    @Throws(IOException::class)
    override fun convert(json: String): RequestBody? {
        return RequestBody.create(MediaType.parse("application/json; charset=utf-8"), json)
    }
}

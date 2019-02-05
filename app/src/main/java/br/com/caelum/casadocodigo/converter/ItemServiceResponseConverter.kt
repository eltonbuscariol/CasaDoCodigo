package br.com.caelum.casadocodigo.converter

import java.io.IOException

import okhttp3.ResponseBody
import retrofit2.Converter

class ItemServiceResponseConverter : Converter<ResponseBody, String> {
    @Throws(IOException::class)
    override fun convert(value: ResponseBody): String? {

        return value.string()
    }
}

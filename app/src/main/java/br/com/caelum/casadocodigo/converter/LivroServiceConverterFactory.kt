package br.com.caelum.casadocodigo.converter

import java.lang.reflect.Type

import okhttp3.RequestBody
import okhttp3.ResponseBody
import retrofit2.Converter
import retrofit2.Retrofit

class LivroServiceConverterFactory : Converter.Factory() {


    override fun responseBodyConverter(type: Type?, annotations: Array<Annotation>?, retrofit: Retrofit?): Converter<ResponseBody, *>? {

        return LivroServiceConverter()
    }

    override fun requestBodyConverter(type: Type?, parameterAnnotations: Array<Annotation>?, methodAnnotations: Array<Annotation>?, retrofit: Retrofit?): Converter<*, RequestBody>? {
        return super.requestBodyConverter(type, parameterAnnotations, methodAnnotations, retrofit)
    }

    override fun stringConverter(type: Type?, annotations: Array<Annotation>?, retrofit: Retrofit?): Converter<*, String>? {
        return super.stringConverter(type, annotations, retrofit)
    }
}

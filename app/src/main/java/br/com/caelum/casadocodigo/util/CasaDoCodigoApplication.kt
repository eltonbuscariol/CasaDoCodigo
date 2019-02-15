package br.com.caelum.casadocodigo.util

import android.app.Application
import android.content.Context
import br.com.caelum.casadocodigo.component.CasaDoCodigoComponent
import br.com.caelum.casadocodigo.component.DaggerCasaDoCodigoComponent

class CasaDoCodigoApplication : Application() {

    init {
        instance = this
    }
    private lateinit var component: CasaDoCodigoComponent

    override fun onCreate() {
        super.onCreate()

        component = DaggerCasaDoCodigoComponent.builder().build()
    }

    fun getComponent() : CasaDoCodigoComponent {
        return component
    }

    companion object {

        private var instance : CasaDoCodigoApplication? = null

        fun getApplicationContext() : Context = instance!!.applicationContext
    }
}
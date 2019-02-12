package br.com.caelum.casadocodigo.util

import android.app.Application
import br.com.caelum.casadocodigo.component.CasaDoCodigoComponent
import br.com.caelum.casadocodigo.component.DaggerCasaDoCodigoComponent

class CasaDoCodigoApplication : Application() {

    private lateinit var component: CasaDoCodigoComponent

    override fun onCreate() {
        super.onCreate()

        component = DaggerCasaDoCodigoComponent.builder().build()
    }

    fun getComponent() : CasaDoCodigoComponent {
        return component
    }
}
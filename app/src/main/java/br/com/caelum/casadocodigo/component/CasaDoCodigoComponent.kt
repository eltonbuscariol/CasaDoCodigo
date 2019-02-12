package br.com.caelum.casadocodigo.component

import br.com.caelum.casadocodigo.activity.CarrinhoActivity
import br.com.caelum.casadocodigo.fragment.DetalhesLivroFragment
import br.com.caelum.casadocodigo.module.CasaDoCodigoModule
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [CasaDoCodigoModule::class])
interface CasaDoCodigoComponent {

    fun inject(fragment: DetalhesLivroFragment)
    fun inject(activity: CarrinhoActivity)
}
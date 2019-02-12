package br.com.caelum.casadocodigo.module

import br.com.caelum.casadocodigo.modelo.Carrinho
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class CasaDoCodigoModule {

    @Singleton
    @Provides
    fun provideCarrinho() : Carrinho {
        return Carrinho()
    }
}
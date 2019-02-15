package br.com.caelum.casadocodigo.module

import android.content.Context
import br.com.caelum.casadocodigo.modelo.Carrinho
import br.com.caelum.casadocodigo.modelo.CartaoDao
import br.com.caelum.casadocodigo.modelo.DaoMaster
import br.com.caelum.casadocodigo.util.CasaDoCodigoApplication
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

    @Provides
    fun provideContext() : Context = CasaDoCodigoApplication.getApplicationContext()


    @Provides
    fun provideCartaoDao(context: Context) : CartaoDao {
        val helper = DaoMaster.DevOpenHelper(context, "cdc-bd")
        val db = helper.writableDb
        val session = DaoMaster(db).newSession()
        return session.cartaoDao
    }
}
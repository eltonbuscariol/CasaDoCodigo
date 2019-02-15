package br.com.caelum.casadocodigo.activity

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import br.com.caelum.casadocodigo.R
import br.com.caelum.casadocodigo.fragment.ListaCartoesFragment

class CartaoActivity : AppCompatActivity() {

    private val listaCartoesFragment by lazy {
        ListaCartoesFragment()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cartao)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.frame_cartao, listaCartoesFragment)
        transaction.commit()
    }
}
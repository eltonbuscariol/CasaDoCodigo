package br.com.caelum.casadocodigo.activity

import android.os.Bundle
import android.support.v4.app.FragmentTransaction
import android.support.v7.app.AppCompatActivity

import br.com.caelum.casadocodigo.R
import br.com.caelum.casadocodigo.fragment.ListaLivrosFragment

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.frame_principal, ListaLivrosFragment())
        transaction.commit()
    }

}

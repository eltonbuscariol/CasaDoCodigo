package br.com.caelum.casadocodigo.activity

import android.os.Bundle
import android.support.v4.app.FragmentTransaction
import android.support.v7.app.AppCompatActivity
import android.widget.Toast

import br.com.caelum.casadocodigo.R
import br.com.caelum.casadocodigo.client.LivroWebClient
import br.com.caelum.casadocodigo.delegate.LivrosDelegate
import br.com.caelum.casadocodigo.fragment.ListaLivrosFragment
import br.com.caelum.casadocodigo.modelo.Livro

class MainActivity : AppCompatActivity(), LivrosDelegate {

    private lateinit var listaLivrosFragment : ListaLivrosFragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        listaLivrosFragment = ListaLivrosFragment()
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.frame_principal, listaLivrosFragment)
        transaction.commit()

        LivroWebClient(this).getLivros(0, 10)
    }

    override fun lidaComSucesso(livros: List<Livro>) {
        listaLivrosFragment.populaListaCom(livros)
    }

    override fun lidaComFalha(throwable: Throwable) {
        Toast.makeText(this, "Não foi possível carregar os livros -> ${throwable.localizedMessage}", Toast.LENGTH_SHORT).show()
    }

}

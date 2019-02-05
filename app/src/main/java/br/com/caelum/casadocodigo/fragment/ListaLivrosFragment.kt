package br.com.caelum.casadocodigo.fragment

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import br.com.caelum.casadocodigo.R
import br.com.caelum.casadocodigo.adapter.LivrosAdapter
import br.com.caelum.casadocodigo.modelo.Autor
import br.com.caelum.casadocodigo.modelo.Livro
import butterknife.BindView
import butterknife.ButterKnife

class ListaLivrosFragment : Fragment() {

    @BindView(R.id.lista_livros)
    lateinit var recyclerView: RecyclerView

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_lista_livros, container, false)

        val livros = mutableListOf<Livro>()

        for (i in 1..6) {
            val autor = Autor()
            autor.nome = "Autor $i"
            val livro = Livro("Livro $i", "Descricao $i", listOf(autor))
            livros.add(livro)
        }

        ButterKnife.bind(this, view)

        recyclerView.adapter = LivrosAdapter(livros) { livro: Livro -> handlerBook(livro) }
        recyclerView.layoutManager = LinearLayoutManager(context)

        return view
    }

    private fun handlerBook(livro: Livro) {
        val arguments = Bundle()
        arguments.putParcelable("livro", livro)
        val detalhesLivroFragment = DetalhesLivroFragment()
        detalhesLivroFragment.arguments = arguments
        val transaction = fragmentManager!!.beginTransaction()
        transaction.replace(R.id.frame_principal, detalhesLivroFragment)
        transaction.addToBackStack(null)
        transaction.commit()

    }


}
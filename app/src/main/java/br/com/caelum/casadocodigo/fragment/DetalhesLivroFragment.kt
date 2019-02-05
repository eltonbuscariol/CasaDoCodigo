package br.com.caelum.casadocodigo.fragment

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import br.com.caelum.casadocodigo.R
import br.com.caelum.casadocodigo.modelo.Livro
import kotlinx.android.synthetic.main.fragment_detalhes_livro.view.*

class DetalhesLivroFragment : Fragment() {

    lateinit var livro: Livro

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_detalhes_livro, container, false)

        livro = arguments?.getParcelable("livro") as Livro

        populaCamposCom(view, livro)

        return view
    }

    private fun populaCamposCom(view: View?, livro: Livro) {
        view?.let {
            view.detalhes_livro_nome.text = livro.nome
        }
    }
}
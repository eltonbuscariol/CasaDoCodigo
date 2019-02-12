package br.com.caelum.casadocodigo.fragment

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import br.com.caelum.casadocodigo.R
import br.com.caelum.casadocodigo.modelo.Carrinho
import br.com.caelum.casadocodigo.modelo.Item
import br.com.caelum.casadocodigo.modelo.Livro
import br.com.caelum.casadocodigo.modelo.TipoDeCompra
import br.com.caelum.casadocodigo.util.CasaDoCodigoApplication
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.fragment_detalhes_livro.*
import kotlinx.android.synthetic.main.fragment_detalhes_livro.view.*
import javax.inject.Inject

class DetalhesLivroFragment : Fragment() {

    @Inject
    lateinit var carrinho: Carrinho

    lateinit var livro: Livro

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_detalhes_livro, container, false)

        livro = arguments?.getSerializable("livro") as Livro

        populaCamposCom(view, livro)

        val app = activity?.application as? CasaDoCodigoApplication
        app?.let { app.getComponent().inject(this) }

        view.detalhes_livro_comprar_fisico.setOnClickListener {
            comprar(TipoDeCompra.FISICO)
        }
        view.detalhes_livro_comprar_ebook.setOnClickListener {
            comprar(TipoDeCompra.VIRTUAL)
        }
        view.detalhes_livro_comprar_ambos.setOnClickListener {
            comprar(TipoDeCompra.JUNTOS)
        }

        return view
    }

    private fun populaCamposCom(view: View?, livro: Livro) {
        view?.let {
            view.detalhes_livro_nome.text = livro.nome
            Picasso.with(context).load(livro.urlFoto).placeholder(R.drawable.livro).into(view.detalhes_livro_foto)
        }
    }

    private fun comprar(tipoDeCompra: TipoDeCompra) {
        Toast.makeText(context, "Livro adicionando ao carrinho!", Toast.LENGTH_SHORT).show()
        carrinho.adiciona(Item(livro, tipoDeCompra))
    }

}
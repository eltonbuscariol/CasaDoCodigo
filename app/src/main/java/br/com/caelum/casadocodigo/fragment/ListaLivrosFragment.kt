package br.com.caelum.casadocodigo.fragment

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import br.com.caelum.casadocodigo.R
import br.com.caelum.casadocodigo.activity.MainActivity
import br.com.caelum.casadocodigo.adapter.LivroAdapter
import br.com.caelum.casadocodigo.client.LivroWebClient
import br.com.caelum.casadocodigo.listener.EndlessListListener
import br.com.caelum.casadocodigo.modelo.Livro
import butterknife.BindView
import butterknife.ButterKnife
import com.google.firebase.remoteconfig.FirebaseRemoteConfig

class ListaLivrosFragment : Fragment() {

    private val livros = arrayListOf<Livro>()

    @BindView(R.id.lista_livros)
    lateinit var recyclerView: RecyclerView

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_lista_livros, container, false)

        ButterKnife.bind(this, view)

        val remoteConfig = FirebaseRemoteConfig.getInstance()
        val listType = remoteConfig.getBoolean("list_type_single_item")

        recyclerView.adapter = LivroAdapter(livros, listType) { livro: Livro -> handlerBook(livro) }
        recyclerView.layoutManager = LinearLayoutManager(context)

        return view
    }

    private fun handlerBook(livro: Livro) {
        val arguments = Bundle()
        arguments.putSerializable("livro", livro)
        val detalhesLivroFragment = DetalhesLivroFragment()
        detalhesLivroFragment.arguments = arguments
        val transaction = fragmentManager!!.beginTransaction()
        transaction.replace(R.id.frame_principal, detalhesLivroFragment)
        transaction.addToBackStack(null)
        transaction.commit()

    }

    fun populaListaCom(livrosLista: List<Livro>) {
        this.livros.addAll(livrosLista)
        recyclerView.adapter?.notifyDataSetChanged()
        recyclerView.addOnScrollListener(object : EndlessListListener() {
            override fun carregaMaisItens() {
                val mainActivity = context as MainActivity

                LivroWebClient(mainActivity).getLivros(livros.size, 10)
            }
        })
    }

}
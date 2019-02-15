package br.com.caelum.casadocodigo.fragment

import android.app.AlertDialog
import android.content.DialogInterface
import android.content.Intent
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import br.com.caelum.casadocodigo.R
import br.com.caelum.casadocodigo.adapter.CartaoAdapter
import br.com.caelum.casadocodigo.modelo.Cartao
import br.com.caelum.casadocodigo.modelo.CartaoDao
import br.com.caelum.casadocodigo.util.CasaDoCodigoApplication
import kotlinx.android.synthetic.main.fragment_lista_cartoes.*
import kotlinx.android.synthetic.main.fragment_lista_cartoes.view.*
import javax.inject.Inject

class ListaCartoesFragment : Fragment() {

    @Inject
    lateinit var cartaoDao: CartaoDao

    private var cartoes = arrayListOf<Cartao>()

    lateinit var listaCartoes: RecyclerView

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_lista_cartoes, container, false)

        val app = activity?.application as? CasaDoCodigoApplication
        app?.let { app.getComponent().inject(this) }

        view.lista_cartoes.adapter = CartaoAdapter(cartoes){ cartao: Cartao -> handleCard(cartao) }
        view.lista_cartoes.layoutManager = LinearLayoutManager(this.context)

        listaCartoes = view.lista_cartoes

        populaLista()

        view.fab_add_cartao.setOnClickListener {
            val transaction = fragmentManager!!.beginTransaction()
            transaction.replace(R.id.frame_cartao, FormularioCartaoFragment())
            transaction.addToBackStack(null)
            transaction.commit()
        }


        return view
    }

    fun handleCard(cartao: Cartao) : Boolean {

        AlertDialog.Builder(context)
                .setMessage("Continuar com a exclusão do cartão?")
                .setPositiveButton("SIM") { dialog, which ->
                    cartaoDao.delete(cartao)
                    populaLista() }
                .setNegativeButton("NÃO", null)
                .show()

        return true
    }

    override fun onResume() {
        super.onResume()
        populaLista()
    }

    fun populaLista() {
        cartoes.clear()
        cartoes.addAll(cartaoDao.loadAll())
        listaCartoes.adapter?.notifyDataSetChanged()
    }


}
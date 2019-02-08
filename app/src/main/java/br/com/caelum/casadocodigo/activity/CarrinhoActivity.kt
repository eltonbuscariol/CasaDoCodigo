package br.com.caelum.casadocodigo.activity

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import br.com.caelum.casadocodigo.R
import br.com.caelum.casadocodigo.adapter.ItensAdapter
import br.com.caelum.casadocodigo.modelo.Carrinho
import br.com.caelum.casadocodigo.modelo.Item
import kotlinx.android.synthetic.main.activity_carrinho.*

class CarrinhoActivity : AppCompatActivity() {

    private val carrinho = Carrinho()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_carrinho)
    }

    override fun onResume() {
        super.onResume()
        carregaLista()
    }

    fun carregaLista(){

        lista_itens_carrinho.adapter = ItensAdapter(carrinho.getItens(), this)
        lista_itens_carrinho.layoutManager = LinearLayoutManager(this)

        var total : Double = carrinho.getItens().sumByDouble { item -> item.valor }
        valor_carrinho.text = "R$ ${total}"
    }
}
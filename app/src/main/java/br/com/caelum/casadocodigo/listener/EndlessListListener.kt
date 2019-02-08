package br.com.caelum.casadocodigo.listener

import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView

abstract class EndlessListListener : RecyclerView.OnScrollListener() {

    private var qtdTotalItens = 0
    private var primeiroItemVisivel = 0
    private var qtdItensVisiveis = 0
    private var carregando = true
    private var totalAnterior = 0

    override fun onScrolled(recyclerView: RecyclerView, qtdScrollHorizontal: Int, qtdScrollVertical: Int) {
        super.onScrolled(recyclerView, qtdScrollHorizontal, qtdScrollVertical)
        val layoutManager = recyclerView.layoutManager as LinearLayoutManager

        qtdTotalItens = layoutManager.itemCount
        primeiroItemVisivel = layoutManager.findLastVisibleItemPosition()
        qtdItensVisiveis = recyclerView.childCount

        val limite = qtdTotalItens - qtdItensVisiveis - 5 //para disparar o evento antes de chegar no final da lista

        if (carregando){
            if (qtdTotalItens > totalAnterior){
                totalAnterior = qtdTotalItens
                carregando = false
            }
        }

        if (!carregando && primeiroItemVisivel >= limite){
            carregaMaisItens()
            carregando = true
        }

    }

    abstract fun carregaMaisItens()
}

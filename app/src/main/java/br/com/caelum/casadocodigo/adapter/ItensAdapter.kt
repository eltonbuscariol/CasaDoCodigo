package br.com.caelum.casadocodigo.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView

import br.com.caelum.casadocodigo.R
import br.com.caelum.casadocodigo.modelo.Item
import br.com.caelum.casadocodigo.modelo.TipoDeCompra
import com.squareup.picasso.Picasso

class ItensAdapter(private val items: List<Item>, private val context: Context) : RecyclerView.Adapter<ItensAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.item_carrinho, parent, false)

        return ViewHolder(view)
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {

        val holder = viewHolder as ViewHolder

        val item = items[position]

        val valorComprado = retornaValorCompradoDo(item)

        holder.nomeItem.text = item.livro.nome
        holder.valorComprado.text = valorComprado
        Picasso.with(holder.fotoLivro.context)
                .load(item.livro.urlFoto)
                .placeholder(R.drawable.livro)
                .into(holder.fotoLivro)
    }

    private fun retornaValorCompradoDo(item: Item): String {

        val tipoDeCompra = item.tipoDeCompra

        when (tipoDeCompra) {
            TipoDeCompra.FISICO -> return String.format("R$ %.2f", item.livro.valorFisico)

            TipoDeCompra.VIRTUAL -> return String.format("R$ %.2f", item.livro.valorVirtual)

            else -> return String.format("R$ %.2f", item.livro.valorDoisJuntos)
        }

    }

    override fun getItemCount(): Int {
        return items.size
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        var fotoLivro: ImageView
        var nomeItem: TextView
        var valorComprado: TextView

        init {

            fotoLivro = itemView.findViewById<View>(R.id.imagem_item_comprado) as ImageView
            nomeItem = itemView.findViewById<View>(R.id.nome_item_comprado) as TextView
            valorComprado = itemView.findViewById<View>(R.id.valor_pago_item_comprado) as TextView
        }
    }
}

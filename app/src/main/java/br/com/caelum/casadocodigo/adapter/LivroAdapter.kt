package br.com.caelum.casadocodigo.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import br.com.caelum.casadocodigo.R
import br.com.caelum.casadocodigo.modelo.Livro
import butterknife.BindView
import butterknife.ButterKnife
import com.squareup.picasso.Picasso

class LivroAdapter(private val livros: List<Livro>, private val listType : Boolean, private val clickListener: (Livro) -> Unit) : RecyclerView.Adapter<LivroAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        var tipoLayout = R.layout.item_livro_par

        if (listType) {
            if (viewType % 2 != 0) {
                tipoLayout = R.layout.item_livro_impar
            }
        }

        val view = LayoutInflater.from(parent.context).inflate(tipoLayout, parent, false)
        return ViewHolder(view)

    }

    override fun getItemCount(): Int = livros.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        livros[position]?.let { livro ->
            holder.bind(livro, clickListener)
        }

    }

    override fun getItemViewType(position: Int): Int = position % 2

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        @BindView(R.id.item_livro_nome)
        lateinit var nomeLivro: TextView

        @BindView(R.id.item_livro_foto)
        lateinit var fotoLivro: ImageView

        init {
            ButterKnife.bind(this, itemView)
        }

        fun bind(livro: Livro, clickListener: (Livro) -> Unit) {
            nomeLivro.text = livro.nome
            itemView.setOnClickListener { clickListener(livro) }
            Picasso.with(this.fotoLivro.context)
                    .load(livro.urlFoto)
                    .placeholder(R.drawable.livro)

                    .into(this.fotoLivro)
        }
    }
}
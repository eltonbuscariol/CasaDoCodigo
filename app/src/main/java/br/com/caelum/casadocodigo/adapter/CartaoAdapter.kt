package br.com.caelum.casadocodigo.adapter

import android.support.v4.content.ContextCompat
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import br.com.caelum.casadocodigo.R
import br.com.caelum.casadocodigo.modelo.Cartao
import butterknife.BindView
import butterknife.ButterKnife
import kotlinx.android.synthetic.main.abc_activity_chooser_view.view.*

class CartaoAdapter(private val listaCartoes: List<Cartao>, private val longClickListener: (Cartao) -> Boolean) : RecyclerView.Adapter<CartaoAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_cartao, parent, false)

        return ViewHolder(view)
    }

    override fun getItemCount(): Int = listaCartoes.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        listaCartoes[position]?.let { holder.Bind(it, longClickListener) }
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        @BindView(R.id.lbl_numero_cartao)
        lateinit var numeroCartao: TextView

        @BindView(R.id.lbl_validade_cartao)
        lateinit var validade: TextView

        @BindView(R.id.lbl_nome_completo)
        lateinit var nomeCompleto: TextView

        @BindView(R.id.img_bandeira)
        lateinit var banderia: ImageView

        @BindView(R.id.btn_edit_cartao)
        lateinit var btnEdit : ImageButton

        init {
            ButterKnife.bind(this, itemView)
        }

        fun Bind(cartao: Cartao, longClickListener: (Cartao) -> Boolean) {

            numeroCartao.text = "${cartao.numero.toString().substring(0, 4)} ${cartao.numero.toString().substring(4, 8)} ${cartao.numero.toString().substring(8, 12)} ${cartao.numero.toString().substring(12, 16)}"
            validade.text = cartao.validade
            nomeCompleto.text = cartao.nomeCompleto

            if (cartao.numero.toString().startsWith("4", true)) {
                banderia.setImageDrawable(ContextCompat.getDrawable(itemView.context, R.drawable.visa))
            } else if (cartao.numero.toString().startsWith("5", true)) {
                banderia.setImageDrawable(ContextCompat.getDrawable(itemView.context, R.drawable.mastercard))
            }
            itemView.setOnLongClickListener { longClickListener(cartao) }
            btnEdit.setOnClickListener {

            }
        }
    }
}
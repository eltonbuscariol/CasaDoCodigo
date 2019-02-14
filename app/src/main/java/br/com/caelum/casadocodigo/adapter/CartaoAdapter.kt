package br.com.caelum.casadocodigo.adapter

import android.support.v4.content.ContextCompat
import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import br.com.caelum.casadocodigo.R
import br.com.caelum.casadocodigo.modelo.Cartao
import butterknife.BindView
import butterknife.ButterKnife
import kotlinx.android.synthetic.main.abc_activity_chooser_view.view.*

class CartaoAdapter {

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        @BindView(R.id.lbl_numero_cartao)
        lateinit var numeroCartao : TextView

        @BindView(R.id.lbl_validade_cartao)
        lateinit var validade : TextView

        @BindView(R.id.lbl_nome_completo)
        lateinit var nomeCompleto : TextView

        @BindView(R.id.img_bandeira)
        lateinit var banderia : ImageView

        init {
            ButterKnife.bind(this, itemView)
        }

        fun Bind(cartao: Cartao){
            numeroCartao.text = cartao.numero.toString()
            validade.text = cartao.validade
            nomeCompleto.text = cartao.nomeCompleto

            if (cartao.numero.toString().startsWith("4", true)){
                banderia.setImageDrawable(ContextCompat.getDrawable(itemView.context, R.drawable.visa))
            } else if (cartao.numero.toString().startsWith("5", true)){
                banderia.setImageDrawable(ContextCompat.getDrawable(itemView.context, R.drawable.mastercard))
            }
        }
    }
}
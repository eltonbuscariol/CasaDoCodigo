package br.com.caelum.casadocodigo.fragment

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.*
import br.com.caelum.casadocodigo.R
import br.com.caelum.casadocodigo.modelo.Cartao
import br.com.caelum.casadocodigo.modelo.CartaoDao
import br.com.caelum.casadocodigo.util.CasaDoCodigoApplication
import kotlinx.android.synthetic.main.fragment_formulario_cartao.*
import javax.inject.Inject

class FormularioCartaoFragment : Fragment() {

    @Inject
    lateinit var cartaoDao: CartaoDao

    private var cartao = Cartao()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_formulario_cartao, container, false)

        val app = activity?.application as? CasaDoCodigoApplication
        app?.let { app.getComponent().inject(this) }

        return view
    }

    override fun onCreateOptionsMenu(menu: Menu?, inflater: MenuInflater?) {
        inflater?.inflate(R.menu.menu_formulario_cartao, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        if (item?.itemId == R.id.menu_item_salvar_cartao) {
            cartaoDao.save(BindEntity())
            activity?.onBackPressed()
        }

        return super.onOptionsItemSelected(item)
    }

    fun editaCartao(cartao: Cartao) {
        this.cartao = cartao
    }

    fun preencheFormulario(){
        numero_cartao_g1.setText(cartao.numero.toString().substring(0,4))
        numero_cartao_g2.setText(cartao.numero.toString().substring(4,8))
        numero_cartao_g3.setText(cartao.numero.toString().substring(8,12))
        numero_cartao_g4.setText(cartao.numero.toString().substring(12,16))
        txt_validade_cartao.setText(cartao.validade)
        txt_nome_cartao.setText(cartao.nomeCompleto)
    }

    private fun BindEntity(): Cartao {
        cartao.apply {
            numero = "${numero_cartao_g1.text}${numero_cartao_g2.text}${numero_cartao_g3.text}${numero_cartao_g4.text}".toLong()
            nomeCompleto = txt_nome_cartao.text.toString()
            validade = txt_validade_cartao.text.toString()
        }
        return cartao
    }
}
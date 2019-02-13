package br.com.caelum.casadocodigo.activity

import android.content.Intent
import android.os.Bundle
import android.support.v4.app.FragmentTransaction
import android.support.v7.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast

import br.com.caelum.casadocodigo.R
import br.com.caelum.casadocodigo.client.LivroWebClient
import br.com.caelum.casadocodigo.delegate.LivrosDelegate
import br.com.caelum.casadocodigo.fragment.ListaLivrosFragment
import br.com.caelum.casadocodigo.modelo.Livro
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.remoteconfig.FirebaseRemoteConfig

class MainActivity : AppCompatActivity(), LivrosDelegate {

    private lateinit var listaLivrosFragment : ListaLivrosFragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val remoteConfig = FirebaseRemoteConfig.getInstance()
        remoteConfig.setDefaults(R.xml.remote_config_defaults)

        remoteConfig.fetch(15).addOnCompleteListener { task ->
            if (task.isSuccessful){
                remoteConfig.activateFetched()
            }
        }

        listaLivrosFragment = ListaLivrosFragment()
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.frame_principal, listaLivrosFragment)
        transaction.commit()

        LivroWebClient(this).getLivros(0, 10)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        when(item?.itemId){
            R.id.vai_para_carrinho -> {
                val intent = Intent(this, CarrinhoActivity::class.java)
                startActivity(intent)
            }
            R.id.menu_item_logout -> {
                val firebaseAuth = FirebaseAuth.getInstance()
                firebaseAuth.signOut()
                val intent = Intent(this, LoginActivity::class.java)
                startActivity(intent)
                finish()
            }
        }
        return true
    }

    override fun lidaComSucesso(livros: List<Livro>) {
        listaLivrosFragment.populaListaCom(livros)
    }

    override fun lidaComFalha(throwable: Throwable) {
        Toast.makeText(this, "Não foi possível carregar os livros -> ${throwable.localizedMessage}", Toast.LENGTH_SHORT).show()
    }

}

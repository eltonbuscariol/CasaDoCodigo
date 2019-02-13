package br.com.caelum.casadocodigo.activity

import android.content.Intent
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity
import br.com.caelum.casadocodigo.R
import com.google.android.gms.tasks.Task
import com.google.firebase.auth.AuthResult
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity() {

    private val firebaseAuth: FirebaseAuth by lazy { FirebaseAuth.getInstance() }
    private var flagUsuarioLogado  = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        flagUsuarioLogado = false

        login_logar.setOnClickListener { getLoginData(false) }
        login_novo.setOnClickListener { getLoginData(true) }

        val listener = FirebaseAuth.AuthStateListener {
            val user = it.currentUser

            user?.let {
                if(!flagUsuarioLogado){
                    flagUsuarioLogado = true
                    goToMain()
                }
            }
        }

        firebaseAuth.addAuthStateListener(listener)

    }

    fun getLoginData(newUser : Boolean) {
        val email = login_email.text.toString()
        val senha = login_senha.text.toString()

        if (!email.isNullOrEmpty() && !senha.isNullOrEmpty()) {
            when(newUser){
                true -> createUser(email, senha)
                false -> login(email, senha)
            }


        } else {
            Snackbar.make(login_senha, "Por favor complete todos os campos", Snackbar.LENGTH_SHORT).show()
        }
    }

    private fun goToMain(){
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
        finish()
    }

    private fun login(email:String, senha:String){

        firebaseAuth.signInWithEmailAndPassword(email, senha)
                .addOnCompleteListener { task: Task<AuthResult> ->
                    task.exception?.let {
                        Snackbar.make(login_email, it.message.toString(), Snackbar.LENGTH_SHORT).show()
                    } ?:kotlin.run {
                        Snackbar.make(login_email, "Acesso não autorizado", Snackbar.LENGTH_SHORT).show()
                    }
                }
    }

    private fun createUser(email:String, senha:String){

        firebaseAuth.createUserWithEmailAndPassword(email, senha)
                .addOnCompleteListener { task: Task<AuthResult> ->
                    if (!task.isSuccessful) {
                        task.exception?.let {
                            Snackbar.make(login_email, it.message.toString(), Snackbar.LENGTH_SHORT).show()
                        }?:kotlin.run {
                            Snackbar.make(login_email, "Acesso não autorizado", Snackbar.LENGTH_SHORT).show()
                        }
                    }
                }
    }
}
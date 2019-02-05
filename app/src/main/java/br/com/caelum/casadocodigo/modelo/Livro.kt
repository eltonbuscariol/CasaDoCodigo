package br.com.caelum.casadocodigo.modelo

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize
import java.io.Serializable

@Parcelize
class Livro() : Parcelable {

    var id: Long = 0
    var nome: String? = null
    var descricao: String? = null
    var numPaginas: Int = 0
    var dataPublicacao: String? = null
    var isbn: String? = null
    var valorFisico: Double = 0.toDouble()
    var valorVirtual: Double = 0.toDouble()
    var valorDoisJuntos: Double = 0.toDouble()
    var urlFoto: String? = null
    var autores: List<Autor>? = null

    constructor(nome: String, descricao: String, autores: List<Autor>) : this() {
        this.nome = nome
        this.descricao = descricao
        this.autores = autores
    }
}

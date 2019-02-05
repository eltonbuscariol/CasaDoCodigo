package br.com.caelum.casadocodigo.modelo

import java.io.Serializable

class Autor : Serializable {

    var id: Long = 0
    var nome: String? = null
    var biografia: String? = null
    var urlFoto: String? = null
}

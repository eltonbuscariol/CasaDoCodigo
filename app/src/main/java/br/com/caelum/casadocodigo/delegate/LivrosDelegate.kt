package br.com.caelum.casadocodigo.delegate

import br.com.caelum.casadocodigo.modelo.Livro

interface LivrosDelegate {

    fun lidaComSucesso(livros : List<Livro>)
    fun lidaComFalha(throwable: Throwable)
}
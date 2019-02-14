package br.com.caelum.casadocodigo.event

import br.com.caelum.casadocodigo.modelo.Livro

class LivroEvent(private val livros : List<Livro>) {

    fun getLivros() : List<Livro> = livros
}
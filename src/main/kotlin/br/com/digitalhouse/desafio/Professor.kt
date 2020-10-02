package br.com.digitalhouse.desafio

abstract class Professor (val nome: String, val sobrenome: String, var tempoCasa: Int, var codigoProfessor: Int) {

    override fun equals(other: Any?): Boolean {
        other as Professor
        return this.codigoProfessor == other.codigoProfessor && this == other
    }

}
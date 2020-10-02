package br.com.digitalhouse.desafio

class ProfessorTitular (nome: String, sobrenome: String, tempoCasa: Int, codigoProfessor: Int, var especialidade: String): Professor(nome, sobrenome, tempoCasa, codigoProfessor) {

    override fun equals(other: Any?): Boolean {
        return super.equals(other)
    }
}
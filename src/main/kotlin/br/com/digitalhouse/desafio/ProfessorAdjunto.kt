package br.com.digitalhouse.desafio

class ProfessorAdjunto (nome: String, sobrenome: String, tempoCasa: Int, codigoProfessor: Int, var quantHoras: Int): Professor(nome, sobrenome, tempoCasa, codigoProfessor) {

    override fun equals(other: Any?): Boolean {
        return super.equals(other)
    }
}
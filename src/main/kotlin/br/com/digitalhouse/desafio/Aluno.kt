package br.com.digitalhouse.desafio;

public class Aluno (val nome: String, val sobrenome: String, var codigoAluno: Int) {

    override fun equals(other: Any?): Boolean {
        other as Aluno
        return this.codigoAluno == other.codigoAluno && this == other
    }
}

package br.com.digitalhouse.desafio

import java.util.*

class DigitalHouseManager {
    var listaDeAlunos = mutableListOf<Aluno>()
    var listaDeProfessores = mutableListOf<Professor>()
    var listaDeCursos = mutableListOf<Curso>()
    var listaDeMatricula = mutableListOf<Matricula>()

    fun registrarCurso(nome: String, codigoCurso: Int, quantidadeMaximaDeAlunos: Int)  {
        val curso = Curso(nome, codigoCurso, quantidadeMaximaDeAlunos)
        listaDeCursos.add(curso)
    }

    fun excluirCurso(codigoCurso: Int) {
        var verificar = false
        var cont = 0

        for (curso in listaDeCursos) {
            verificar = codigoCurso.equals(curso.codigoCurso)
            if (verificar) {
                listaDeCursos.removeAt(cont)
                println("Exclusão do Curso: ${curso.nome}.")
                break
            }
            cont++
        }

        if (!verificar){
            println("O Curso com o código $codigoCurso não está listado.")
        }
    }

    fun registrarProfessorAdjunto(nome: String, sobrenome: String, codigoProfessor: Int, quantidadeDeHoras: Int) {
        val professorAdjunto = ProfessorAdjunto(nome, sobrenome, 0, codigoProfessor, quantidadeDeHoras)
        listaDeProfessores.add(professorAdjunto)
    }

    fun registrarProfessorTitular(nome: String, sobrenome: String, codigoProfessor: Int, especialidade: String) {
        val professorTitular = ProfessorTitular(nome, sobrenome, 0, codigoProfessor, especialidade)
        listaDeProfessores.add(professorTitular)
    }

    fun excluirProfessor(codigoProfessor: Int){
        var verificarProfessor = false
        var cont = 0

        for (professor in listaDeProfessores) {
            verificarProfessor = codigoProfessor.equals(professor.codigoProfessor)
            if ( verificarProfessor) {
                listaDeProfessores.removeAt(cont)
                println("O Professor de código $codigoProfessor foi excluido.")
                break
            }
            cont++
        }

        if (!verificarProfessor){
            println("O professor Adjunto com código $codigoProfessor não está listado.")
        }
    }

    fun matricularAluno(nome: String, sobrenome: String, codigoAluno: Int) {
        val aluno = Aluno(nome, sobrenome, codigoAluno)
        listaDeAlunos.add(aluno)
        println("Aluno $nome com código $codigoAluno foi matriculado.")
    }

    fun excluirAlunoCurso(codigoAluno: Int){
        var verificar= false
        var usoAluno: Aluno? = null

        for (matricula in listaDeMatricula) {
            verificar = codigoAluno.equals(matricula.aluno.codigoAluno)
            if (verificar) {
                usoAluno = matricula.aluno
                matricula.curso.excluirUmAluno(usoAluno)
                println("O aluno foi excluido do curso de ${matricula.curso.nome}.")
                break
            }
        }

        if (!verificar){
            println("O aluno com código $codigoAluno não está listado.")
        }
    }

    fun matricularAlunoCurso(codigoAluno: Int, codigoCurso: Int) {
        var usoAluno: Aluno? = null
        var usoCurso: Curso? = null
        var verificar = false
        var verificarCurso = false

        for (aluno in listaDeAlunos) {
            verificar = codigoAluno.equals(aluno.codigoAluno)

            if (verificar) {
                usoAluno = aluno
                break
            }
        }

        if (!verificar){
            println("O aluno com código $codigoAluno não está listado.")
        }

        for (curso in listaDeCursos) {
            verificarCurso = codigoCurso.equals(curso.codigoCurso)

            if (verificarCurso) {
                usoCurso = curso
                break
            }
        }

        if (!verificarCurso){
            println("O curso com código $codigoCurso não está listado.")
        }

        if (usoAluno != null && usoCurso != null) {
            val matricula = Matricula(usoAluno, usoCurso, Date())
            listaDeMatricula.add(matricula)

            if (usoCurso.adicionarUmAluno(usoAluno)){
                println("O aluno $codigoAluno foi matriculado no curso $codigoCurso.")
            } else {
                println("O curso $codigoCurso já esta na capacidade máxima de alunos.")
            }
        }
    }

    fun alocarProfessores(codigoCurso: Int, codigoProfessor: Int, codigoProfessorAdjunto: Int) {
        var profT: ProfessorTitular? = null
        var profA: ProfessorAdjunto? = null
        var usoCurso: Curso? = null
        var verificarProfT = false
        var verificarProfA = false
        var verificarCurso = false

        for (professorTitular in listaDeProfessores) {
            verificarProfT = codigoProfessor.equals(professorTitular.codigoProfessor)

            if (verificarProfT) {
                profT = professorTitular as ProfessorTitular
                break
            }
        }

        if (!verificarProfT){
            println("O professor Titular com código $codigoProfessor não está listado.")
        }

        for (professorAdjunto in listaDeProfessores) {
            verificarProfA = codigoProfessorAdjunto.equals(professorAdjunto.codigoProfessor)

            if (verificarProfA) {
                profA = professorAdjunto as ProfessorAdjunto
                break
            }
        }

        if (!verificarProfA){
            println("O professor Adjunto com código $codigoProfessorAdjunto não está listado.")
        }

        for (curso in listaDeCursos) {
            verificarCurso = codigoCurso.equals(curso.codigoCurso)

            if (verificarCurso) {
                usoCurso = curso
                break
            }
        }

        if (!verificarCurso){
            println("O curso com código $codigoCurso não está listado.")
        }

        if (profT != null) {
            usoCurso?.professorTitular = profT
        }

        if (profA != null) {
            usoCurso?.professorAdjunto = profA
        }
    }

    fun consultarAluno(codigoAluno: Int) {
        var verificar = false

        for (matricula in listaDeMatricula) {
            verificar = codigoAluno.equals(matricula.aluno.codigoAluno)

            if (verificar) {
                println("O curso que o aluno de código $codigoAluno é de ${matricula.curso.nome}")
                break
            }
        }

        if (!verificar){
            println("O aluno com código $codigoAluno não está listado.")
        }
    }
}
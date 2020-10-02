package br.com.digitalhouse.desafio

class Curso (var nome: String, var codigoCurso: Int, var quantidadeMaximaAluno: Int) {
    lateinit var professorTitular: ProfessorTitular
    lateinit var professorAdjunto: ProfessorAdjunto
    var alunosMatriculados = mutableListOf<Aluno>()


    override fun equals(other: Any?): Boolean {
        other as Curso
        return this.codigoCurso == other.codigoCurso && this == other
    }

    fun adicionarUmAluno(umAluno: Aluno) : Boolean{
        if (alunosMatriculados.size == quantidadeMaximaAluno){
            return false
        } else{
            alunosMatriculados.add(umAluno)
            return true
        }

    }

    fun excluirUmAluno(umAluno: Aluno){
        var verificar = false
        var cont = 0
        for (aluno in alunosMatriculados){
            verificar = aluno.codigoAluno.equals(aluno.codigoAluno)
            if (verificar == true){
                alunosMatriculados.removeAt(cont)
                break
            }
            cont++
        }
        if(verificar == false){
            println("Esse aluno não está listado.")
        }
    }

}

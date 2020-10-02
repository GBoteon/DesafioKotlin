package br.com.digitalhouse.desafio

fun main() {

    val digitalHouseManager = DigitalHouseManager()

    digitalHouseManager.registrarProfessorTitular("Carlos", "Souza", 333, "Front End")
    digitalHouseManager.registrarProfessorTitular("José", "Silva", 222, "Kotlin")

    digitalHouseManager.registrarProfessorAdjunto("Sandra", "Naville", 1122, 21)
    digitalHouseManager.registrarProfessorAdjunto("Caroline", "Pero", 3322, 12)

    digitalHouseManager.registrarCurso("Full Stack", 20001, 3)
    digitalHouseManager.registrarCurso("Android", 20002, 2)

    digitalHouseManager.matricularAluno("Gustavo", "Rosas", 11)
    digitalHouseManager.matricularAluno("Sara", "Oliveira", 12)
    digitalHouseManager.matricularAluno("João", "Nogueira", 13)
    digitalHouseManager.matricularAluno("Charles", "Gomes", 14)
    digitalHouseManager.matricularAluno("Bruno", "Subtil", 15)

    digitalHouseManager.alocarProfessores(20001, 333, 21)
    digitalHouseManager.alocarProfessores(20002, 222, 12)

    digitalHouseManager.matricularAlunoCurso(11, 20001)
    digitalHouseManager.matricularAlunoCurso(12, 20001)
    digitalHouseManager.matricularAlunoCurso(13, 20002)
    digitalHouseManager.matricularAlunoCurso(14, 20002)
    digitalHouseManager.matricularAlunoCurso(15, 20002)
}
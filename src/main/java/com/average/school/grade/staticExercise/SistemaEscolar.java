package com.average.school.grade.staticExercise;

import java.util.ArrayList;
import java.util.List;

public class SistemaEscolar {

    /**
     Uma escola recebe alunos para as séries do 1°,2° e 3° ano
     Cada série é composta das turmas A, B, e C.
     As notas dos alunos são expressas em números de 1 a 5
     A regra é que a nota 1 é o pior resultado
     Para ter aprovação o aluno deve ter uma nota de 3 ou mais

     com base nessas informações, crie um código que fornece:
     porcentagem de alunos aprovados por turma, classificado por série,
     Média das notas desses alunos por turma, classificado por série
     Os melhores alunos e suas respectivas notas de cada serie em ordem crescente (por nota)
     */

    public static void main(String[] args) {

        Escola escola = new Escola();

        //////////////////// PRIMEIRO ANO ESCOLAR
        AnoEscolar primeiroANo = new AnoEscolar();
        // TURMA A
        Turmas turmaA = new Turmas();
        List<Alunos> alunosTurmaA = new ArrayList<>();

        alunosTurmaA.add(new Alunos("Aluno-1-1A",4));
        alunosTurmaA.add(new Alunos("Aluno-2-1A",3));
        alunosTurmaA.add(new Alunos("Aluno-3-1A",5));
        alunosTurmaA.add(new Alunos("Aluno-4-1A",5));
        alunosTurmaA.add(new Alunos("Aluno-5-1A",1));

        turmaA.setAlunos(alunosTurmaA);
        primeiroANo.setTurmaA(turmaA);

        // TURMA B
        Turmas turmaB = new Turmas();
        List<Alunos> alunosTurmaB = new ArrayList<>();

        alunosTurmaB.add(new Alunos("Aluno-1-1B",2));
        alunosTurmaB.add(new Alunos("Aluno-2-1B",2));
        alunosTurmaB.add(new Alunos("Aluno-3-1B",3));
        alunosTurmaB.add(new Alunos("Aluno-4-1B",5));
        alunosTurmaB.add(new Alunos("Aluno-5-1B",5));

        turmaB.setAlunos(alunosTurmaB);
        primeiroANo.setTurmaB(turmaB);

        // TURMA C
        Turmas turmaC = new Turmas();
        List<Alunos> alunosTurmaC = new ArrayList<>();

        alunosTurmaC.add(new Alunos("Aluno-1-1C",1));
        alunosTurmaC.add(new Alunos("Aluno-2-1C",1));
        alunosTurmaC.add(new Alunos("Aluno-3-1C",1));
        alunosTurmaC.add(new Alunos("Aluno-4-1C",2));
        alunosTurmaC.add(new Alunos("Aluno-5-1C",4));

        turmaB.setAlunos(alunosTurmaC);
        primeiroANo.setTurmaC(turmaC);

        escola.setPrimeiroAno(primeiroANo);
        ////////////////////////////////////////////////////////


        System.out.println("PRIMEIRO ANO");
        System.out.println("TURMA A");

        alunosTurmaA.stream().forEach(S -> {
                    System.out.println("Nome: " + S.getNome() + " Nota: " + S.getNota());
                });

        System.out.println("Alunos Aprovados" + filtraAlunosAprovados(alunosTurmaA));

        System.out.println("==================");
        System.out.println("TURMA B");

        alunosTurmaB.stream().forEach(S -> {
            System.out.println("Nome: " + S.getNome() + " Nota: " + S.getNota());
        });

        System.out.println("Alunos Aprovados" + filtraAlunosAprovados(alunosTurmaB));


        System.out.println("==================");
        System.out.println("TURMA C");
        alunosTurmaC.stream().forEach(S -> {
            System.out.println("Nome: " + S.getNome() + " Nota: " + S.getNota());
        });

        System.out.println("Alunos Aprovados" + filtraAlunosAprovados(alunosTurmaC));

        ////////////////////////////////////////////////////////

    }

    private static List<String> filtraAlunosAprovados(List<Alunos> alunosTurma) {

        List<String> alunosAprovados = new ArrayList<>();
        alunosTurma.stream().forEach(S -> { if (S.getNota() >=3){
            alunosAprovados.add("Nome: " + S.nome + " = " + "Nota: " +  S.getNota());
        }
        });
        return alunosAprovados;
    }
}

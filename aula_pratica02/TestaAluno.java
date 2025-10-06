package aula_pratica2;

import javax.swing.JOptionPane;

public class TestaAluno {
    public static void main(String[] args) {
        String aux = JOptionPane.showInputDialog("Olá! Seja bem-vindo(a) ao programa que calcula as médias das notas dos alunos registrados.\nQuantos alunos deseja registrar? Insira abaixo:");
        int n = Integer.parseInt(aux);

        Aluno[] alunos = new Aluno[n];

        for(int i=0; i<n; i++){
            String nome = JOptionPane.showInputDialog("Digite o nome do aluno " + (i+1) + ": ");
            String matriculaStr = JOptionPane.showInputDialog("Digite a matricula do aluno " + (i+1) + ": ");
                int matricula = Integer.parseInt(matriculaStr);
            String prova1Str = JOptionPane.showInputDialog("Digite a nota da primeira prova do aluno " + (i+1) + ": ");
                float prova1 = Float.parseFloat(prova1Str);
            String prova2Str = JOptionPane.showInputDialog("Digite a nota da segunda prova do aluno " + (i+1) + ": ");
                float prova2 = Float.parseFloat(prova2Str);
            String trabalhoStr = JOptionPane.showInputDialog("Digite a nota do trabalho do aluno " + (i+1) + ": ");
                float trabalho = Float.parseFloat(trabalhoStr);

            alunos[i] = new Aluno(prova1, prova2, trabalho, nome, matricula); //cria um novo objeto aluno para o indice i com as instancias acima;          
        }

        for(Aluno aluno : alunos){
            JOptionPane.showMessageDialog(null, aluno.toString());
        }
    }
}


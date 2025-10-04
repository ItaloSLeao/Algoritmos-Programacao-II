package aula_pratica5.controle;
import java.util.ArrayList;
import aula_pratica5.modelo.Aluno;

public class ControleAluno {
        private ArrayList <Aluno> alunos = new ArrayList<>();

        public void cadastrarAluno (String nome){
            Aluno a = new Aluno(nome);
            alunos.add(a);
        }

        public Aluno pesquisarAlunoMat(int mat){
        //Pesquisa aluno por número de matricula
            Aluno a = null;
            for (int i = 0; i < alunos.size(); i++){
                if (mat == alunos.get(i).getMatricula()){
                    a=alunos.get(i);
                    break;
                }
            }
            return a;
        }

        public Aluno pesquisarAlunoNome(String nome){
        //Pesquisa aluno por nome
            Aluno aluno = null;
            for (Aluno a: alunos){
                if (a.getNome().equalsIgnoreCase(nome)){
                    aluno=a;
                    break;
                }
            }
            return aluno;
        }

        public String listarAlunos(){
            String dadosAlunos="";
                for (Aluno a: alunos){
                    dadosAlunos += a.imprimir()+ "\n";
                }
            return dadosAlunos;
        }
}


package aula_pratica5.controle;

import aula_pratica5.modelo.Aluno;
import aula_pratica5.modelo.Turma;
import java.util.ArrayList;

public class ControleTurma {
    private ArrayList<Turma> turmas = new ArrayList<>();

    public void cadastrarTurma(int codigo, String disciplina){
        Turma t = new Turma(codigo, disciplina);
        turmas.add(t);
    }

    public Turma pesquisarTurma(int codigo){
        Turma t = null;
            for(Turma turma : turmas){
                if(codigo == turma.getCodigo()){
                    t = turma;
                    break;
                }
            }
        return t;
    }

    public void matricularAluno(int codigo, Aluno a){
        for(Turma turma : turmas){
            if(codigo == turma.getCodigo()){
                turma.matricular(a);
            }
        }
    }

    public void desmatricularAluno(int codigo, Aluno a){
        for(Turma turma : turmas){
            if(codigo == turma.getCodigo()){
                turma.desmatricular(a);
            }
        }
    }

    public String listarAlunos(int codigo){
        String t = "";
        String matriculados = "";
            for(Turma turma :  turmas){
                if(codigo == turma.getCodigo()){
                    t = turma.imprimir();
                    for(int i=0; i<turma.getAlunos().size(); i++){
                        matriculados += turma.getAlunos().get(i).getNome() + " - " + turma.getAlunos().get(i).getMatricula() + "\n";
                    }
                }
            }
        return t + "\n" + matriculados;
    }

    public String listarTurmas(){
        String listaT = "";
            for(int i=0; i < turmas.size(); i++){
                listaT += turmas.get(i).imprimir() + "\n";
            }
        return listaT;
    }
}

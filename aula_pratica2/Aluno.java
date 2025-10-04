package aula_pratica2;
public class Aluno {
    String nome;
    int matricula;
    float prova1, prova2, trabalho;

    //metodo construtor para atribuir as instancias de cada objeto no array, sem usar ex: "aluno1.matricula = 0001" etc...
    public Aluno(float prova1, float prova2, float trabalho, String nome, int matricula){
        this.prova1 = prova1;
        this.prova2 = prova2;
        this.trabalho = trabalho;
        this.nome = nome;
        this.matricula = matricula;
    }

    public float calcularMedia(){
        return (4*prova1 + 4*prova2 + 2*trabalho)/10;
    }

    public float calcularFinal(){
        if(calcularMedia() > 7){return 0;}else{
                return (5 - (calcularMedia()*0.7f))*3;
        }
    }

    @Override //metodo toString para exibir as informacoes dos alunos no main
    public String toString()
    {
        float media = calcularMedia();
        float notaFinal = calcularFinal();
        return String.format("Nome: %s\nMatrícula: %d\nNota Prova 1: %.2f\nNota Prova 2: %.2f\nNota Trabalho: %.2f\n" + 
            "Média Final: %.2f\nNota Necessária para a Final: %.2f", nome, matricula, prova1, prova2, trabalho, media, notaFinal);
    }
}

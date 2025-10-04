package aula_pratica4;
import javax.swing.JOptionPane;

public class Questao01b {

    public static void main(String[] args) {
    String [] alunos; //declara o array alunos.
    final int QTD_ALUNOS; //declara uma constante para quantidade de alunos (tamanho do array).
    QTD_ALUNOS = Integer.parseInt(JOptionPane.showInputDialog ("Digite a" + 
    "quantidade de alunos")); //atribui valor à constante por uma caixa de inserção e converte de string para inteiro.
    alunos = new String [QTD_ALUNOS]; //inicializa o array alunos de tamanho QTD_ALUNOS.
    String listaAlunos ="";
        for (int i=0; i < alunos.length; i++){
            alunos[i] = JOptionPane.showInputDialog ("Digite o nome do alunos");
        }
        for (String a: alunos){ //cria uma string qualquer que "percorre" o array como representante de um elemento do array por vez.
            listaAlunos +=a + "\n"; //adiciona a listaAlunos cada elemento de alunos[] e salta uma linha para o próximo.
        }
    JOptionPane.showMessageDialog(null, "Nome dos alunos: \n" + listaAlunos);
}
}
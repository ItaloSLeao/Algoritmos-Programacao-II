package aula_pratica5;

public class Pessoa {
    private String nome;
    private int idade;

    public Pessoa(String n, int i) {
        nome = n; idade = i;
    }

    public String imprimir() {
    return nome + "\n" + idade + " ano(s)";
    }
}

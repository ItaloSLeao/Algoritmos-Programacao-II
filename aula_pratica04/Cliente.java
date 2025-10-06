package aula_pratica4;

public class Cliente {
    private long cpf;
    private String nome;
    private String endereco;

    //Construtores-------------------------------------------
    public Cliente(long cpf, String nome) {
        this.cpf = cpf;
        this.nome = nome;
    }

    public Cliente(long cpf, String nome, String endereco) {
        this.cpf = cpf;
        this.nome = nome;
        this.endereco = endereco;
    }

    // Getters e Setters ------------------------------------
    public long getCpf() {
        return cpf;
    }

    public String getNome() {
        return nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    //Método-------------------------------------------------
    public String imprimir() {
        return "Nome: " + nome + ", CPF: " + cpf + ", Endereço: " + endereco;
    }
}


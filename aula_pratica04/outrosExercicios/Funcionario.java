package aula_pratica4.outrosExercicios;

public class Funcionario {
    private String nome;
    private String cargo;
    private String data;
    private long cpf;
    private int horas;
    private double valorHora;

    public Funcionario(String nome, String cargo, String data, long cpf, int horas, double valorHora){
        this.nome = nome;
        this.cargo = cargo;
        this.data = data;
        this.cpf = cpf;
        this.horas = horas;
        this.valorHora = valorHora;
    }

    public double calcularSalario(){
        return this.valorHora * this.horas;
    }

    public String getNome(){
        return this.nome;
    }
    public String getCargo(){
        return this.cargo;
    }
    public String getData(){
        return this.data;
    }
    public long getCpf(){
        return this.cpf;
    }
    public int getHoras(){
        return this.horas;
    }
    public double getValorHora(){
        return this.valorHora;
    }

    public void setNome(String nome){
        this.nome = nome;
    }
    public void setCargo(String cargo){
        this.cargo = cargo;
    }
    public void setData(String data){
        this.data = data;
    }
    public void setCpf(long cpf){
        this.cpf = cpf;
    }
    public void setHoras(int horas){
        this.horas = horas;
    }
    public void setValorHora(double valorHora){
        this.valorHora = valorHora;
    }

    //Qual é o problemas? -> cadastro de funcionários de uma empresa e calculo dos seus salarios
    //Quais objetos estão envolvidos? -> cada funcionario da classe Funcionario, que possui nome, cargo, data, cpf, horas trabalhadas e valor da hora trabalhada

}


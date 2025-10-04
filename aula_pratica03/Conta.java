package aula_pratica3;
//Essa classe tem o nome "Contaa" pq ja tinha outra com o nome "Conta" na pasta

public class Conta {
    private int numero;
    private String cliente;
    private double saldo;
    private String operacoes = "";

    //Construtores -----------------------------------------------------------------------------------------------------------------------------------------------------
    //Não usei construtor sem parâmetro, pois não havia necessidade. Mesma coisa pra variável "qtd", já q o array vem definido

    public Conta(int numero, String cliente, double saldo){
        this.numero = numero;
        this.cliente = cliente;
        this.saldo = saldo;
    }

    //Métodos ----------------------------------------------------------------------------------------------------------------------------------------------------------

    public boolean sacar(double valor){
        boolean sacou=false;
        if (saldo >= valor){
            saldo = saldo - valor;
            sacou=true;
            operacoes += "Saque de R$ " + valor + "\n";
        }
        return sacou;
    }

    public void depositar(double valor){
        if (valor>0){
        saldo += valor;
        operacoes += "Depósito de R$ " + valor + "\n";
        }
    }

    public boolean ehIgual(Conta outraConta){
        return this.numero == outraConta.numero && this.cliente.equals(outraConta.cliente) && this.saldo == outraConta.saldo;
    }

    public boolean transferir(Conta outraConta, double transf){
        boolean transferencia=false;
        if(outraConta.saldo >= transf){
            outraConta.saldo -= transf;
            this.saldo += transf;
            transferencia = true;
            operacoes += "Transferência de R$ " + transf + " da conta " + outraConta.numero + " para a conta " + this.numero + "\n";
        }
        return transferencia;
    }

    public String imprimirConta(){
        return "Número: " + this.numero + "\nCliente: " + this.cliente + "\nSaldo:  R$ " + saldo;
    }

    public String extrato(){
        return "Extrato bancário da conta " + this.numero + ":\n" + this.operacoes;
    }

    //Getters e Setters ------------------------------------------------------------------------------------------------------------------------------------------------
    //Não foi necessario criar setSaldo pq os metodos sacar, depositar e transferir ja fazem isso de uma forma melhor e coerente com o programa.

    public int getNumero(){
        return numero;
    }
    public double getSaldo(){
        return saldo;
    }
}

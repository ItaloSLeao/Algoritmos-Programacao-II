package aula_pratica2;
public class Conta{
    String titular, agencia, abertura;
    int numeroConta;
    double saldo;
    //metodos sacar, depositar e rendimento
    public double sacar(double saque){
        if(saque>saldo){return 1;} else{return saldo - saque;}
    }
    public double depositar(double deposito, double saldo){ //usei saldo como argumento para poder atualizar o valor apos haver um saque
        return saldo + deposito;
    }
    public double rendimento(double deposito, double saque){
        return ((deposito - saque)/saldo)*100;
    }

}
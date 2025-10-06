package aula_pratica2;

import javax.swing.JOptionPane;

public class Banco {
    public static void main(String[] args){
        Conta c1 = new Conta();
        String saqueStr, depositoStr;
        double saque=0, deposito=0;

        JOptionPane.showMessageDialog(null, "Bem-vindo(a) às suas aplicações do mês no Banco FAVORITO! Vamos começar digitando seus dados");
        c1.titular = JOptionPane.showInputDialog("Digite o nome do titular da conta");
        c1.agencia = JOptionPane.showInputDialog("Digite o código da agência");
        c1.abertura = JOptionPane.showInputDialog("Digite a data de abertura da conta");

        String numeroConta_teste = JOptionPane.showInputDialog("Digite o número da conta");
        String saldo_teste = JOptionPane.showInputDialog("Digite o saldo da conta");

        c1.numeroConta = Integer.parseInt(numeroConta_teste); //converte string do joption em int
        c1.saldo = Double.parseDouble(saldo_teste); //o mesmo so q double

        String escolha = JOptionPane.showInputDialog("Você deseja realizar algum saque? (sim/nao)");
        String escolha2 = JOptionPane.showInputDialog("Você deseja realizar algum depósito? (sim/nao)");

        if(escolha.equals("sim")){
            saqueStr = JOptionPane.showInputDialog("Digite o valor do seu saque");
            saque = Double.parseDouble(saqueStr);
        } else if(escolha.equals("nao")){
            saque = 0;
        }

        if(escolha2.equals("sim")){
            depositoStr = JOptionPane.showInputDialog("Digite o valor do seu depósito");
            deposito = Double.parseDouble(depositoStr);
        } else if(escolha2.equals("nao")){
            deposito = 0;
        }

        c1.sacar(saque);

        JOptionPane.showMessageDialog(null, "Dados confidenciais:\n" + "Titular da conta: " + c1.titular + "\nNúmero da conta: " + c1.numeroConta + "\nData de abertura: " + c1.abertura + "\nAgência: " + c1.agencia + "\n");
        if(c1.sacar(saque) == 1){
            JOptionPane.showMessageDialog(null, "Saque impossibilitado de ser realizado, o valor excede o saldo em R$ " + (saque-c1.saldo) + "\n");
            saque = 0.0;
            JOptionPane.showMessageDialog(null, "Você realizou um depósito de R$ " + deposito + ". Consolidando seu saldo em R$ " + c1.depositar(deposito, c1.saldo) + "\nSeu rendimento este mês foi de " + c1.rendimento(deposito, saque) + "%");
        }else{
            JOptionPane.showMessageDialog(null, "Você realizou:\nUm saque de R$ " + saque + "\nUm depósito de R$ " + deposito + ". Consolidando seu saldo em R$ " + c1.depositar(deposito, c1.sacar(saque)) + "\nSeu rendimento este mês foi de " + c1.rendimento(deposito,saque) + "%");
        }



    }
}

//Conta c1 = new Conta();
//c1.titular = "Josefa";
//c1.saldo = 100;
//Conta c2 = new Conta();
//c2.titular = "Josefa";
//c2.saldo = 100;
//if (c1 == c2) {
//System.out.println("iguais");
//} else {
//System.out.println("diferentes");
//}

//Questao 3) O if nesse codigo nao cumpre o papel que era esperado dele, pois o simbolo "==" faz uma comparação entre objetos na memória. Logo, o if
//só vai retornar true, se c1 e c2 corresponderem ao exato mesmo objeto na memoria, desse modo, retorna false, ainda que os atributos de c1
//e c2 sejam os mesmos. Teria de ser usada outra forma de comparação, ou até implementar algum metodo na classe dos objetos.

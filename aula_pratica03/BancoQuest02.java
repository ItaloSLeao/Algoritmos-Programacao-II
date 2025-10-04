package aula_pratica3;
import javax.swing.JOptionPane;
public class BancoQuest02 {

    public static int solicitarOperacao(){ //método da main para solicitar a continuação da operação
        String opS = JOptionPane.showInputDialog("Quer continuar operando? Digite:\n" +
            "1 - Comparar contas\n" +
            "2 - Depositar\n" +
            "3 - Sacar\n" +
            "4 - Consultar saldo\n" +
            "5 - Imprimir dados da conta\n" +
            "6 - Transferir\n" +
            "7 - Acessar extrato\n" +
            "0 - Encerrar atividades");

        return Integer.parseInt(opS);
    }
    public static void main(String[] args){

        String nStr = JOptionPane.showInputDialog("Bem-vindo(a) ao ItaBank. Vamos começar fazendo o(s) cadastro(s).\nQuantas contas quer cadastrar?");
            int n = Integer.parseInt(nStr);
        Conta[] contas = new Conta[n];
                    
        for(int i=0; i<n; i++){
            String cliente = JOptionPane.showInputDialog("Digite o nome do cliente "+(i+1));
            String numeroStr = JOptionPane.showInputDialog("Digite o número da conta " + (i+1));
                int numero = Integer.parseInt(numeroStr);
            String saldoStr = JOptionPane.showInputDialog("Digite o saldo da conta " + (i+1));   
                double saldo = Double.parseDouble(saldoStr);
                        
            contas[i] = new Conta(numero, cliente, saldo);
        }

        int op = solicitarOperacao();

        while(op!=0){ //Nao coloquei o cadastro de contas no laço pela questao de manipular o array (deu alguns erros de perda de valores quando pus)
            
            switch (op){

                case 1:{ //Comparar contas
                    String numeroStr1 = JOptionPane.showInputDialog("Digite o número da primeira conta que você quer comparar");
                        int numero1 = Integer.parseInt(numeroStr1);
                    String numeroStr2 = JOptionPane.showInputDialog("Digite o número da segunda conta que você quer comparar");
                        int numero2 = Integer.parseInt(numeroStr2);

                    for(Conta conta1 : contas){
                        if(numero1 == conta1.getNumero()){
                            for(Conta conta2 : contas){
                                if(numero2 == conta2.getNumero()){
                                    if(conta1.ehIgual(conta2)){
                                        JOptionPane.showMessageDialog(null, "As contas são iguais");} 
                                        else{JOptionPane.showMessageDialog(null,"As contas não são iguais");}
                                }
                            }
                        }
                    }
                    break;
                }

                case 2:{ //Depositar
                    String numeroStr = JOptionPane.showInputDialog("Digite o número da conta que quer depositar");
                        int numero = Integer.parseInt(numeroStr);
                    String valorStr = JOptionPane.showInputDialog("Digite quanto quer depositar");
                        double valor = Double.parseDouble(valorStr);
                    
                    for(Conta conta : contas){
                        if(numero == conta.getNumero()){
                            conta.depositar(valor);
                        }
                    }
                    break;
                }

                case 3:{ //Sacar
                    String numeroStr = JOptionPane.showInputDialog("Digite o número da conta que quer sacar");
                        int numero = Integer.parseInt(numeroStr);
                    String valorStr = JOptionPane.showInputDialog("Digite quanto quer sacar");
                        double valor = Double.parseDouble(valorStr);
                    
                    for(Conta conta : contas){
                        if(numero == conta.getNumero()){
                            JOptionPane.showMessageDialog(null,"Saldo antes do saque da conta " + conta.getNumero() + ": " + conta.getSaldo());
                            if(conta.sacar(valor)){
                                JOptionPane.showMessageDialog(null,"Saque realizado com sucesso!! Saldo após o saque: " + conta.getSaldo());
                            }
                                else{JOptionPane.showMessageDialog(null, "Saque impossibilitado! Saldo insuficiente");}
                        }
                    }
                    break;
                }

                case 4:{ //Consultar saldo
                    String numeroStr = JOptionPane.showInputDialog("Digite o número da conta que quer consultar");
                        int numero = Integer.parseInt(numeroStr);
                    
                    for(Conta conta : contas){
                        if(numero == conta.getNumero()){
                            JOptionPane.showMessageDialog(null,"Seu saldo atual é R$ " + conta.getSaldo());
                        }
                    }
                    break;
                }

                case 5:{ //Imprimir dados da conta
                    String numeroStr = JOptionPane.showInputDialog("Digite o número da conta que quer imprimir");
                    int numero = Integer.parseInt(numeroStr);
                
                for(Conta conta : contas){
                    if(numero == conta.getNumero()){
                        JOptionPane.showMessageDialog(null,conta.imprimirConta());
                    }
                }
                break;
                }

                case 6:{ //Transferir
                    String numeroStr1 = JOptionPane.showInputDialog("Digite o número da conta da qual você vai transferir");
                        int numero1 = Integer.parseInt(numeroStr1);
                    String numeroStr2 = JOptionPane.showInputDialog("Digite o número da conta para a qual você vai transferir");
                        int numero2 = Integer.parseInt(numeroStr2);
                    String saqueStr = JOptionPane.showInputDialog("Quanto você quer transferir?");
                        double saque = Double.parseDouble(saqueStr);
                
                for(Conta conta : contas){
                    if(numero2 == conta.getNumero()){
                        for(Conta conta2 : contas){
                            if(numero1 == conta2.getNumero()){
                                if(conta.transferir(conta2, saque)){
                                    JOptionPane.showMessageDialog(null, "Transferência de R$ " + saque + " realizada!" + 
                                    "\nSaldo da conta " + conta.getNumero() + ": R$ " + conta.getSaldo() + 
                                    "\nSaldo da conta " + conta2.getNumero() + ": R$ " + conta2.getSaldo());
                                };
                            }
                        }
                    }
                }
                break;
                }

                case 7:{ //Extratos
                    String numeroStr = JOptionPane.showInputDialog("Digite o número da conta que você quer acessar o extrato");
                        int numero = Integer.parseInt(numeroStr);
                    
                for(Conta conta : contas){
                    if(numero == conta.getNumero()){
                        JOptionPane.showMessageDialog(null, conta.extrato());
                    }
                    }
                break;
                }
            }
            op = solicitarOperacao();
        }
        switch (op){
            case 0:{
                JOptionPane.showMessageDialog(null,"Operações encerradas. Bom dia, boa tarde, boa noite!!");
            }
        }
    }
}

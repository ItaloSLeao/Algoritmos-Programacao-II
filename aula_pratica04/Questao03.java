package aula_pratica4;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class Questao03 {

    public static String menu() {
        return "Digite:\n" +
               "1 - Criar conta\n" +
               "2 - Sacar\n" +
               "3 - Depositar\n" +
               "4 - Transferir\n" +
               "5 - Imprimir dados da conta\n" +
               "6 - Cadastrar cliente\n" +
               "7 - Sair";
    }
    public static void main(String[] args) {
        ArrayList<Cliente> clientes = new ArrayList<>();
        ArrayList<Conta> contas = new ArrayList<>();

        String opp = "S";
        while (opp.equalsIgnoreCase("S")) {
            String menu = menu();
            int opcao = Integer.parseInt(JOptionPane.showInputDialog(menu));

            switch (opcao) {
                case 1:
                    criarConta(clientes, contas);
                    break;
                case 2:
                    sacar(contas);
                    break;
                case 3:
                    depositar(contas);
                    break;
                case 4:
                    transferir(contas);
                    break;
                case 5:
                    imprimirConta(contas);
                    break;
                case 6:
                    cadastrarCliente(clientes);
                    break;
                case 7:
                    opp = "N";
                    JOptionPane.showMessageDialog(null, "Operações encerradas! Bom dia, boa tarde, boa noite.");
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Opção inválida!");
            }
        }
    }
    //JOptionPane usa uma repetição muito grande de código, então usei esses métodos na main para deixar mais compacto.

    private static void cadastrarCliente(ArrayList<Cliente> clientes) {
        long cpf = Long.parseLong(JOptionPane.showInputDialog("Digite o CPF do cliente:"));
        String nome = JOptionPane.showInputDialog("Digite o nome do cliente:");
        String endereco = JOptionPane.showInputDialog("Digite o endereço do cliente:");
        Cliente cliente = new Cliente(cpf, nome, endereco);
        clientes.add(cliente);
        JOptionPane.showMessageDialog(null, "Cliente cadastrado com sucesso!");
    }

    private static void criarConta(ArrayList<Cliente> clientes, ArrayList<Conta> contas) {
        long cpf = Long.parseLong(JOptionPane.showInputDialog("Digite o CPF do cliente:"));
        Cliente cliente = buscarCliente(clientes, cpf);
        if (cliente == null) {
            JOptionPane.showMessageDialog(null, "Cliente não encontrado!");
            return;
        }
        double saldoInicial = Double.parseDouble(JOptionPane.showInputDialog("Digite o saldo inicial da conta:"));
        Conta conta = new Conta(cliente, saldoInicial);
        contas.add(conta);
        JOptionPane.showMessageDialog(null, "Conta criada com sucesso!");
    }

    private static Cliente buscarCliente(ArrayList<Cliente> clientes, long cpf) {
        for (Cliente cliente : clientes) {
            if (cliente.getCpf() == cpf) {
                return cliente;
            }
        }
        return null;
    }

    private static void sacar(ArrayList<Conta> contas) {
        int numeroConta = Integer.parseInt(JOptionPane.showInputDialog("Digite o número da conta:"));
        Conta conta = buscarConta(contas, numeroConta);
        if (conta == null) {
            JOptionPane.showMessageDialog(null, "Conta não encontrada!");
            return;
        }
        double valor = Double.parseDouble(JOptionPane.showInputDialog("Digite o valor do saque:"));
        if (conta.sacar(valor)) {
            JOptionPane.showMessageDialog(null, "Saque realizado com sucesso!");
        } else {
            JOptionPane.showMessageDialog(null, "Saldo insuficiente!");
        }
    }

    private static void depositar(ArrayList<Conta> contas) {
        int numeroConta = Integer.parseInt(JOptionPane.showInputDialog("Digite o número da conta:"));
        Conta conta = buscarConta(contas, numeroConta);
        if (conta == null) {
            JOptionPane.showMessageDialog(null, "Conta não encontrada!");
            return;
        }
        double valor = Double.parseDouble(JOptionPane.showInputDialog("Digite o valor do depósito:"));
        conta.depositar(valor);
        JOptionPane.showMessageDialog(null, "Depósito realizado com sucesso!");
    }

    private static void transferir(ArrayList<Conta> contas){
        int numeroContaOrigem = Integer.parseInt(JOptionPane.showInputDialog("Digite o número da conta de origem:"));
        Conta contaOrigem = buscarConta(contas, numeroContaOrigem);
        if (contaOrigem == null) {
            JOptionPane.showMessageDialog(null, "Conta de origem não encontrada!");
            return;
        }
        int numeroContaDestino = Integer.parseInt(JOptionPane.showInputDialog("Digite o número da conta de destino:"));
        Conta contaDestino = buscarConta(contas, numeroContaDestino);
        if (contaDestino == null) {
            JOptionPane.showMessageDialog(null, "Conta de destino não encontrada!");
            return;
        }
        double valor = Double.parseDouble(JOptionPane.showInputDialog("Digite o valor da transferência:"));
        if (contaOrigem.transferir(contaDestino, valor)) {
            JOptionPane.showMessageDialog(null, "Transferência realizada com sucesso!");
        } else {
            JOptionPane.showMessageDialog(null, "Saldo insuficiente!");
        }
    }

    private static void imprimirConta(ArrayList<Conta> contas) {
        int numeroConta = Integer.parseInt(JOptionPane.showInputDialog("Digite o número da conta:"));
        Conta conta = buscarConta(contas, numeroConta);
        if (conta == null) {
            JOptionPane.showMessageDialog(null, "Conta não encontrada!");
            return;
        }
        JOptionPane.showMessageDialog(null, conta.imprimir());
    }

    private static Conta buscarConta(ArrayList<Conta> contas, int numero) {
        for (Conta conta : contas) {
            if (conta.getNumero() == numero) {
                return conta;
            }
        }
        return null;
    }
}

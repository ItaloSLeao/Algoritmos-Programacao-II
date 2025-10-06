package aula_pratica4.outrosExercicios;

import javax.swing.JOptionPane;

public class Empresa {
    public static void main(String[] args){
        String op = "";
        int n = Integer.parseInt(JOptionPane.showInputDialog(
            "Bem vindo(a) ao Cadastrador de Funcionários!! Quantos funcionários deseja cadastrar?"));
        Funcionario[] funcionarios = new Funcionario[n];

        for(int i=0; i<n; i++){
            String nome = JOptionPane.showInputDialog("Digite o nome do funcionário " + (i+1));
            String cargo = JOptionPane.showInputDialog("Digite o cargo do funcionário " + (i+1));
            String data = JOptionPane.showInputDialog("Digite a data de admissão do funcionário " + (i+1));
            long cpf = Long.parseLong(JOptionPane.showInputDialog("Digite o CPF do funcionário " + (i+1)));
            int horas = Integer.parseInt(JOptionPane.showInputDialog("Digite as horas trabalhadas pelo funcionário " + (i+1)));
            double valorHora = Double.parseDouble(JOptionPane.showInputDialog("Digite o valor da hora trabalhada (R$) do funcionário " + (i+1)));

            funcionarios[i] = new Funcionario(nome, cargo, data, cpf, horas, valorHora);

            op = JOptionPane.showInputDialog("Você deseja alterar algum dos dados? (S/N)");

            //a questao pedia apenas para atualizar as horas trabalhas, para nao ficar tao simples permiti para todos os dados
                while(op.equalsIgnoreCase("S")){
                    int p = Integer.parseInt(JOptionPane.showInputDialog("Digite para alterar:\n" + "1 - Nome\n2 - Cargo\n3 - Data de admissão"
                    + "\n4 - CPF\n5 - Horas trabalhadas\n6 - Valor da hora trabalhada (R$)"));

                    switch(p){
                        case 1:{
                            String set = JOptionPane.showInputDialog("Atualize o nome do funcionário " + (i+1));
                            funcionarios[i].setNome(set);
                            break;
                        }
                        case 2:{
                            String set = JOptionPane.showInputDialog("Atualize o cargo do funcionário " + (i+1));
                            funcionarios[i].setCargo(set);
                            break;
                        }
                        case 3:{
                            String set = JOptionPane.showInputDialog("Atualize o cargo do funcionário " + (i+1));
                            funcionarios[i].setData(set);
                            break;
                        }
                        case 4:{
                            long set = Long.parseLong(JOptionPane.showInputDialog("Atualize o CPF do funcionário " + (i+1)));
                            funcionarios[i].setCpf(set);
                        }
                        case 5:{
                            int set = Integer.parseInt(JOptionPane.showInputDialog("Atualize as horas trabalhadas do funcionário " + (i+1)));
                            funcionarios[i].setHoras(set);

                        }
                        case 6:{
                            double set = Double.parseDouble(JOptionPane.showInputDialog("Atualize o valor da hora trabalhada (R$) do funcionário " + (i+1)));
                            funcionarios[i].setValorHora(set);
                        }
                    }

                    op = JOptionPane.showInputDialog("Deseja continuar alterando os dados deste funcionário?");
                }
        }

        op = JOptionPane.showInputDialog("Você deseja calcular o salário dos seus funcionários? (S/N)");
            if(op.equalsIgnoreCase("S")){
                for(int i=0; i<n; i++){
                    JOptionPane.showMessageDialog(null, "O salário do funcionário " + 
                    funcionarios[i].getNome() + " é: R$ " + funcionarios[i].calcularSalario());
                }
            } else{JOptionPane.showMessageDialog(null, "Obrigado por participar! Bom dia, boa tarde, boa noite.");}

        op = JOptionPane.showInputDialog("Você deseja solicitar os dados de algum funcionário? (S/N)");
            while(op.equalsIgnoreCase("S")){
                String nome = JOptionPane.showInputDialog("Insira o nome do funcionário que deseja visualizar os dados");
                for(Funcionario funcionario : funcionarios){
                    if(nome.equalsIgnoreCase(funcionario.getNome())){
                        JOptionPane.showMessageDialog(null, "Nome: " + funcionario.getNome() + "\nCargo: " +
                        funcionario.getCargo() + "\nData de admissão: " + funcionario.getData() + "\nCPF: " + funcionario.getCpf() +
                        "\nHoras trabalhadas: " + funcionario.getHoras() + "\nValor da hora trabalhada: R$ " +
                        funcionario.getValorHora() + "\nSalário: R$ " + funcionario.calcularSalario());
                    }
                }
                op = JOptionPane.showInputDialog("Deseja continuar solicitando os dados de algum funcionário? (S/N)");
            }
            if(op.equalsIgnoreCase("N")){JOptionPane.showMessageDialog(null, "Obrigado por participar! Bom dia, boa tarde, boa noite.");}
    }
}


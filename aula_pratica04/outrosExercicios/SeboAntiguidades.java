package aula_pratica4.outrosExercicios;

import javax.swing.*;

import java.util.ArrayList;

public class SeboAntiguidades {

    public static int solicitarOperacao(){ 
        String opS = JOptionPane.showInputDialog("Digite o número correspondente para cada operação que deseja fazer:" + 
        "\n1 - Cadastrar livros\n2 - Cadastrar clientes\n3 - Comprar livros do cliente\n4 - Vender livros ao cliente" + 
        "\n5 - Exibir livros registrados" + "\n6 - Exibir clientes registrados"+
        "\n7 - Imprimir dados de um livro" + "\n8 - Imprimir dados de um cliente" + "\n0 - Encerrar operações");

        return Integer.parseInt(opS);
    }

    private static Livro obterDadosLivro(){
        JTextField tituloField = new JTextField(10);
        JTextField autoresField = new JTextField(10);
        JTextField editoraField = new JTextField(10);
        JTextField anoField = new JTextField(10);
        JTextField paginasField = new JTextField(10);
        JTextField cadastroField = new JTextField(10);
        JTextField valorField = new JTextField(10);

        JPanel panel = new JPanel();
        panel.add(new JLabel("Título:")); panel.add(tituloField);
        panel.add(new JLabel("Autores:")); panel.add(autoresField);
        panel.add(new JLabel("Editora:")); panel.add(editoraField);
        panel.add(new JLabel("Ano de publicação:")); panel.add(anoField);
        panel.add(new JLabel("Quantidade de páginas:")); panel.add(paginasField);
        panel.add(new JLabel("Cadastro:")); panel.add(cadastroField);
        panel.add(new JLabel("Valor original:")); panel.add(valorField);


        int result = JOptionPane.showConfirmDialog(null, panel, "Insira os dados do livro", JOptionPane.OK_CANCEL_OPTION);
        if (result == JOptionPane.OK_OPTION) {
            String titulo = tituloField.getText();
            String autores = autoresField.getText();
            String editora = editoraField.getText();
            int ano = Integer.parseInt(anoField.getText());
            int paginas = Integer.parseInt(paginasField.getText());
            int cadastro = Integer.parseInt(cadastroField.getText());
            double valor = Double.parseDouble(valorField.getText());
            return new Livro(titulo, autores, editora, ano, paginas, cadastro, valor);
        }
        return null;
    }

    private static Cliente buscarCliente(ArrayList<Cliente> clientes, int cadastro) {
        for (Cliente cliente : clientes) {
            if (cliente.getCadastro() == cadastro) {
                return cliente;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        ArrayList<Livro> livrosSebo = new ArrayList<Livro>();
        ArrayList<Cliente> clientes = new ArrayList<Cliente>();

        JOptionPane.showMessageDialog(null, "Seja bem vindo(a) ao cadastro de livros e clientes do Sebo Antiguidades");
        int op = solicitarOperacao();

        while(op != 0){
            switch(op){

                case 1:{
                    String opp = "S";
                    int i = 0;
                        while(opp.equalsIgnoreCase("S")){
                            Livro novoLivro = obterDadosLivro();
                                if(novoLivro != null){livrosSebo.add(novoLivro);}
                            opp = JOptionPane.showInputDialog("Deseja continuar cadastrando livros? (S/N)");
                            i++;
                        }
                    JOptionPane.showMessageDialog(null, "Cadastro realizado! " + i + " livros registrados no sistema");
                    break;  
                }

                case 2:{
                    String opp = "S";
                    int i=0;
                        while(opp.equalsIgnoreCase("S")){
                            String nome = JOptionPane.showInputDialog("Insira o nome do cliente " + (i+1) + " :");
                            int cadastro = Integer.parseInt(JOptionPane.showInputDialog("Insira o cadastro do cliente " + (i+1) + " :"));
                            double money = Double.parseDouble(JOptionPane.showInputDialog("Insira o poder de compra do cliente " + (i+1) + " (R$):"));
                                clientes.add(new Cliente(nome, cadastro, money));
                            opp = JOptionPane.showInputDialog("Deseja continuar o cadastro? (S/N)");
                            i++;
                        }
                    JOptionPane.showMessageDialog(null, i + " clientes registrados no sistema");
                    break;
                }

                case 3:{
                    String opp = "S";
                    int i=0;
                        while(opp.equalsIgnoreCase("S")){
                            int cadastroC = Integer.parseInt(JOptionPane.showInputDialog("Digite o cadastro do cliente que venderá o livro"));
                            Cliente cliente = buscarCliente(clientes, cadastroC);
                                if(cliente == null){
                                    String nome = JOptionPane.showInputDialog("O cliente procurado ainda não está registrado. Vamos cadastrá-lo\nDigite seu nome:");
                                    double money = Double.parseDouble(JOptionPane.showInputDialog("Digite o poder de compra do cliente (R$)"));
                                    cliente = new Cliente(nome, cadastroC, money);
                                    clientes.add(cliente);
                                    JOptionPane.showMessageDialog(null, "Novo cliente cadastrado com sucesso!");
                                    Livro novoLivro = obterDadosLivro();
                                    if(novoLivro != null){
                                        livrosSebo.add(novoLivro);
                                        cliente.comprarLivrosDoCliente(novoLivro);
                                    }
                                } else{
                                    Livro novoLivro = obterDadosLivro();
                                    if(novoLivro != null){
                                        livrosSebo.add(novoLivro);
                                        cliente.comprarLivrosDoCliente(novoLivro);
                                    }
                                }
                            opp = JOptionPane.showInputDialog("Deseja continuar comprando livros do cliente? (S/N)");
                            i++;
                        }
                    JOptionPane.showMessageDialog(null, i + " livro(s) comprado(s) do(s) cliente(s)");
                    break;
                }

                case 4:{
                    String opp = "S";
                    int i=0;
                        while(opp.equalsIgnoreCase("S")){
                            int cadastroC = Integer.parseInt(JOptionPane.showInputDialog("Digite o cadastro do cliente que comprará o livro"));
                            Cliente cliente = buscarCliente(clientes, cadastroC);
                                if(cliente == null){
                                    String nome = JOptionPane.showInputDialog("O cliente procurado ainda não está registrado. Vamos cadastrá-lo\nDigite seu nome:");
                                    double money = Double.parseDouble(JOptionPane.showInputDialog("Digite o poder de compra do cliente" + Cliente.getQtd() + "(R$)"));
                                    cliente = new Cliente(nome, cadastroC, money);
                                    clientes.add(cliente);
                                    JOptionPane.showMessageDialog(null, "Novo cliente cadastrado com sucesso!");
                                    String titulo = JOptionPane.showInputDialog("Digite o título do livro a ser comprado:\n" + Livro.livrosRegistrados());
                                        for(Livro livro : livrosSebo){
                                            if(titulo.equalsIgnoreCase(livro.getTitulo())){
                                                if(cliente.venderLivrosAoCliente(livro)){livrosSebo.remove(livro);}
                                                else{JOptionPane.showMessageDialog(null, "Compra não efetuada! Poder de compra do cliente é insuficiente");}}}
                                }else{
                                    String titulo = JOptionPane.showInputDialog("Digite o título do livro a ser comprado:\n" + Livro.livrosRegistrados());
                                        for(Livro livro : livrosSebo){
                                            if(titulo.equalsIgnoreCase(livro.getTitulo())){
                                                if(cliente.venderLivrosAoCliente(livro)){
                                                    livrosSebo.remove(livro);
                                                }
                                                else{JOptionPane.showMessageDialog(null, "Compra não efetuada! Poder de compra do cliente é insuficiente");}
                                            }}}
                                opp = JOptionPane.showInputDialog("Deseja continuar vendendo livros ao cliente? (S/N)");
                                i++; 
                        }
                    JOptionPane.showMessageDialog(null, i + " livro(s) vendido(s) ao(s) cliente(s)");
                    break;
                }

                case 5:{
                    JOptionPane.showMessageDialog(null, "Todos os " + Livro.getQtd() + " livros registrados:\n" + Livro.livrosRegistrados());
                    break;
                }

                case 6:{
                    JOptionPane.showMessageDialog(null, "Todos os " + Cliente.getQtd() + " clientes registrados:\n" + Cliente.clientesRegistrados());
                    break;
                }

                case 7:{
                    String titulo = JOptionPane.showInputDialog("Digite o título do livro que deseja solicitar os dados:");
                        for(Livro livro : livrosSebo){
                            if(titulo.equalsIgnoreCase(livro.getTitulo())){
                                JOptionPane.showMessageDialog(null, livro.dadosLivro());
                            }
                        }
                    break;
                }

                case 8:{
                    String nome = JOptionPane.showInputDialog("Digite o nome do cliente que deseja solicitar os dados:");
                        for(Cliente cliente : clientes){
                            if(nome.equalsIgnoreCase(cliente.getNome())){
                                JOptionPane.showMessageDialog(null, cliente.dadosCliente());
                            }
                        }
                    break;
                }
            }
            op = solicitarOperacao();
        }

        switch (op){case 0: JOptionPane.showMessageDialog(null, "Operações encerradas. Bom dia, boa tarde, boa noite!!");}
    }

}

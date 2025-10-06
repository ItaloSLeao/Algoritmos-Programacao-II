package aula_pratica4;

import javax.swing.JOptionPane;

import java.util.ArrayList; //a atividade orienta com o uso de arrays normais, porem a implementacao do arraylist deixa mais dinamico o código.
public class Questao02 {
    public static String menu(){
        return "Escolha uma opção:\n" +
            "1 - Cadastrar produto\n" +
            "2 - Fazer pedido\n" +
            "3 - Inserir itens\n" +
            "4 - Calcular valor do pedido\n" +
            "5 - Comparar produtos\n" +
            "0 - Encerrar";
    }
    public static void main(String[] args) {
        ArrayList<Produto> produtos = new ArrayList<Produto>();
        ArrayList<Pedido> pedidos = new ArrayList<Pedido>();
        int op = Integer.parseInt(JOptionPane.showInputDialog(menu()));
            while(op != 0){
                switch (op){
                    case 1:{
                        String nome = JOptionPane.showInputDialog("Digite o nome do produto");
                        Produto p = new Produto(nome); //letra d) da questao 2: aqui acontece a criação de uma nova instância de produto a cada vez q o case 1 é acionado
                        produtos.add(p); //2.d): e aqui a nova instância é adicionada à lista (arraylist) de produtos que existem no projeto, na classe main.
                        JOptionPane.showMessageDialog(null, "Produto cadastrado:\n" +
                        p.imprimir());
                        break;
                    }

                    case 2:{
                        String data = JOptionPane.showInputDialog("Digite a data do pedido");
                        Pedido p = new Pedido(data); 
                        pedidos.add(p);
                        JOptionPane.showMessageDialog(null, "Pedido" + p.getCodigo() + "feito! Aperte 3 no Menu para inserir itens a esse pedido");
                        break;
                    }

                    case 3:{
                        String nome = JOptionPane.showInputDialog("Digite o nome do produto que você deseja adicionar");
                        int codigo = 0;
                        Produto p = new Produto();
                        Item i = new Item();
                        boolean realizado1 = false, realizado2 = false;
                            for(Produto pr : produtos){
                                if(nome.equalsIgnoreCase(pr.getNome())){
                                    i = new Item(pr);
                                    codigo = Integer.parseInt(JOptionPane.showInputDialog("Produto: " + pr.getCodigo() + " - " + pr.getNome() + " adicionado" + 
                                    "\nDigite o código do pedido que quer inserir o item " + i.getCodigo()));
                                    realizado1 = true;
                                        for(Pedido pd : pedidos){
                                            if(codigo == pd.getCodigo()){
                                                pd.inserirItem(i);
                                                JOptionPane.showMessageDialog(null, "Item " + i.getCodigo() + " adicionado com sucesso ao " +
                                                "pedido " + pr.getCodigo());
                                                realizado2 = true;
                                            }
                                        }
                                }
                            }
                        if(!realizado1 && !realizado2){
                            JOptionPane.showMessageDialog(null,"Produto inválido");
                            String opp = JOptionPane.showInputDialog("Deseja cadastrar o produto? (S/N)");
                                if(opp.equalsIgnoreCase("S")){
                                    p = new Produto(nome);
                                    i = new Item(p);
                                    codigo = Integer.parseInt(JOptionPane.showInputDialog("Produto: " + p.getCodigo() + " - " + p.getNome() + " adicionado" + 
                                    "\nDigite o código do pedido que quer inserir o item " + i.getCodigo()));
                                    realizado1 = true;
                                        for(Pedido pd : pedidos){
                                            if(codigo == pd.getCodigo()){
                                                pd.inserirItem(i);
                                                JOptionPane.showMessageDialog(null, "Item " + i.getCodigo() + " adicionado com sucesso ao " +
                                                "pedido " + p.getCodigo());
                                                realizado2 = true;
                                            }
                                        }
                                }else{break;}
                        }
                        else if(realizado1 && !realizado2){
                            JOptionPane.showMessageDialog(null,"Pedido inválido");
                            String opp = JOptionPane.showInputDialog("Deseja fazer o pedido para inserir o item? (S/N)");
                                if(opp.equalsIgnoreCase("S")){
                                    Pedido pd = new Pedido(codigo);
                                    pd.inserirItem(i);
                                    JOptionPane.showMessageDialog(null, "Item " + i.getCodigo() + " adicionado com sucesso ao " +
                                    "pedido " + p.getCodigo());
                                    realizado2 = true;
                                }
                        }
                        break;
                    }

                    case 4:{
                        int codigo = Integer.parseInt(JOptionPane.showInputDialog("Digite o código do pedido que deseja calcular o valor total"));
                        boolean realizado = false;
                            for(Pedido p : pedidos){
                                if(codigo == p.getCodigo()){
                                    JOptionPane.showMessageDialog(null, "Total do pedido " + p.getCodigo() + ": R$ " + p.calcularTotalPedido());
                                    realizado = true;
                                }
                            }
                        if(!realizado){JOptionPane.showMessageDialog(null, "Pedido não encontrado");}
                        break;
                    }

                    case 5:{
                        String nome1 = JOptionPane.showInputDialog("Digite o nome do primeiro produto que deseja comparar");
                        String nome2 = JOptionPane.showInputDialog("Digite o nome do segundo produto que deseja comparar");
                        boolean comparado = false;
                            for(Produto p1 : produtos){
                                if(nome1.equalsIgnoreCase(p1.getNome())){
                                    for(Produto p2 : produtos){
                                        if(nome2.equalsIgnoreCase(p2.getNome())){
                                            comparado = (nome1.equalsIgnoreCase(nome2)) && (p1.getDescricao().equalsIgnoreCase(p2.getDescricao())) && 
                                            (p1.getTipo().equals(p2.getTipo())) && (p1.getCodigo() == p2.getCodigo()) && (p1.getValor() == p2.getValor());
                                        }
                                    }
                                }
                            }
                        if(comparado){JOptionPane.showMessageDialog(null, "Os produtos comparados são iguais");}
                        else{JOptionPane.showMessageDialog(null, "Os produtos comparados não são iguais");}
                        break;
                    }
                }
                op = Integer.parseInt(JOptionPane.showInputDialog(menu()));
            }
            switch(op){ case 0: {JOptionPane.showMessageDialog(null, "Operações encerradas!");}
    }

    }}

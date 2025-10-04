package aula_pratica4.outrosExercicios;
import java.util.ArrayList;
public class Cliente {
    private String nome;
    private ArrayList<Livro> livrosComprados, livrosVendidos;
    private int cadastro;
    private double money;
    private static int qtd; 
    private static String registrados = "";
    //money eh o poderio financeiro do cliente, seja qual for: especie, pix, limite de cartao...

    //Conatrutor ------------------------------------------------------------------
    public Cliente(String nome, int cadastro, double money){
        this.nome = nome;
            registrados += nome + "\n";
        this.cadastro = cadastro;
        this.money = money;
        this.livrosComprados = new ArrayList<>();
        this.livrosVendidos = new ArrayList<>();
        qtd++;
        }

    //Metodos ----------------------------------------------------------------------
    public String dadosCliente(){
        return "Nome: " + this.nome + "\nNº de Cadastro: " + this.cadastro + "\nLivros comprados pelo cliente: " + this.livrosComprados + 
        "\nLivros vendidos pelo cliente: " + this.livrosVendidos + "\nPoder de compra: R$ " + this.money;
    }

    public static String clientesRegistrados(){return registrados;}

    public boolean venderLivrosAoCliente(Livro vendido){//esse metodo o cliente compra, o sebo vende
        boolean venda = false;
        if(vendido.precoDeVenda() > this.money){
            livrosComprados.add(vendido);
            this.money -= vendido.precoDeVenda();
            venda = true;
        }
        return venda;
    }

    public void comprarLivrosDoCliente(Livro comprado){//o cliente vende, o sebo compra
        livrosVendidos.add(comprado);
        this.money += comprado.getValor();
    }
    
    //Getters ------------------------------------------------------------------------
    public static int getQtd(){return qtd;}

    public String getNome(){return this.nome;}

    public int getCadastro(){return this.cadastro;}
}

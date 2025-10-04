package aula_pratica4;
public class Produto{ //letra b) da questao 2
    private String nome, descricao, tipo; //nome do produto em instancia, descricao: descreve o produto em instancia, tipo do produto em instancia.
    private int codigo, qtd; //codigo: identifica o produto em instancia. qtd: quantidade de um produto em instancia a ser usado.
    private double valor; //custo do produto em instancia
    private int estoque; //quantidade do produto em instancia que tem-se armazenado
    private static int numProdutos = 0; //quantidade de produtos totais na classe, nesse caso a instancia é a classe.

    public Produto(){
        numProdutos++;
        this.codigo = numProdutos;
    }
    public Produto(String nome){
        this.nome=nome;
        numProdutos++;
        this.codigo = numProdutos;
    }
    public Produto(String nome, double valor){
        this.nome=nome;
        this.valor=valor;
        numProdutos++;
        this.codigo = numProdutos;
    }
    public Produto(String nome, double valor, int qtd){
        this.nome=nome;
        this.valor=valor;
        this.estoque=qtd;
        numProdutos++;
        this.codigo = numProdutos;
    }

    public boolean venderProduto(int qtd){
        boolean temProduto=false;
            if (estoque >= qtd){
                estoque = estoque - qtd;
                temProduto=true;
            }
        return temProduto;
    }
    public void comprarProduto(int qtd){
        estoque = estoque + qtd;
    }
    public String imprimir(){
        return this.codigo + " - " + this.nome;
    }

    public String getNome(){
        return this.nome;
    }
    public int getQtd(){
        return qtd;
    }
    public double getValor(){
        return this.valor;
    }
    public double getPreco(){//preço de venda
        return this.valor*2;
    }
    public int getEstoque(){
        return this.estoque;
    }
    public int getCodigo(){
        return this.codigo;
    }
    public String getDescricao(){
        return this.descricao;
    }
    public String getTipo(){
        return this.tipo;
    }


}
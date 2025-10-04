package aula_pratica4;
public class Item {
    private int codigo;
    private int quantidade;
    private Produto produto;


    public Item(){
        quantidade++;
        this.codigo = quantidade;
    }
    public Item(Produto produto){
        this.produto = produto;
        quantidade++;
        this.codigo = this.quantidade;
    }
    public void setQuantidade(int quantidade){
        if(produto.getEstoque() >= quantidade){
            this.quantidade = quantidade;
        }
    }

    public int getCodigo(){
        return this.codigo;
    }
    public int getQuantidade(){
        return this.quantidade;
    }
    public Produto getProduto(){
        return this.produto;
    }
    public double calcularSubTotal(){
        return this.quantidade * produto.getValor();
    }
}

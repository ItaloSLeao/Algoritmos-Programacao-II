package aula_pratica11.controle;

import aula_pratica11.modelo.RepositorioProduto;
import aula_pratica11.modelo.Produto;
import java.util.List;

public class ControleProduto {
    RepositorioProduto rp = new RepositorioProduto();

    public void cadastraProduto (int codigo, String descricao, double valor){
        Produto p = new Produto(codigo, descricao, valor);
        rp.salvarProduto(p);
    }
    public List<Produto> listarProduto(){
        List<Produto> listaProdutos = rp.listarProduto();
        return listaProdutos;
    }
    public Produto pesquisarProduto (int codigo){
        return rp.lerProduto(codigo);
    }
}

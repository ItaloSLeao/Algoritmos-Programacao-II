package aula_pratica2;
public class Produto {
    String nomeProduto, descricao;
    float preco;
    int quantidade, codigo;

    public float calculaValor(){
        return preco*quantidade;
    }
}

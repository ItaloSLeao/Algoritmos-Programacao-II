package aula_pratica3;

public class Veiculo{
    private char codigo;
    private String tipo;
    private String cor;
    private int posicao;
    private static int qtd;

    public void frente(int deslocamento){
        posicao += deslocamento;
    }
    public void re(int deslocamento){
        posicao -= deslocamento;
    }

    public Veiculo(char codigo, String tipo, String cor, int posicao){
        this.codigo = codigo;
        this.tipo = tipo;
        this.cor = cor;
        this.posicao = posicao;
        qtd++;
    }

    public Veiculo(){
        qtd++;
    }

    public Veiculo clone(){
        Veiculo v1 = new Veiculo(this.codigo, this.tipo, this.cor, this.posicao);
        return v1;
    }

    //getters e setters
    public char getCodigo(){
        return codigo;
    }
    public String getTipo(){
        return tipo;
    }
    public String getCor(){
        return cor;
    }
    public int getPosicao(){
        return posicao;
    }
    public static int getVeiculoQtd(){
        return qtd;
    }
    public void setCodigo(char codigo){
        this.codigo = codigo;
    }
    public void setTipo(String tipo){
        this.tipo = tipo;
    }
    public void setCor(String cor){
        this.cor = cor;
    }
    public void setPosicao(int posicao){
        this.posicao = posicao;
    }


}

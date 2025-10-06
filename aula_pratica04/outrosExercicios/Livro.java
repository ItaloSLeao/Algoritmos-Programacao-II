package aula_pratica4.outrosExercicios;

public class Livro {
    private String titulo, autores, editora;
    private int ano, paginas, cadastro;
    private double valor;
    private static int qtd;
    private static String registrados = "";
    //valor é por quanto foi inicialmente comprado pelo sebo

    //Construtor -------------------------------------------------------------------------------------
    public Livro(String titulo, String autores, String editora, int ano, int paginas, int cadastro, double valor){
        this.titulo = titulo;
            registrados += titulo + "\n";
        this.autores = autores;
        this.editora = editora;
        this.ano = ano;
        this.paginas = paginas;
        this.cadastro = cadastro;
        this.valor = valor;
        qtd++;
    }

    //Metodos ---------------------------------------------------------------------------------------
    public String dadosLivro(){
        return "Título: " + this.titulo + "\nAutores: " + this.autores + "\nEditora: " +
        this.editora + "\nAno de publicação: " + this.ano + "\nQuantidade de Páginas: " 
        + this.paginas + "\nCadastro: " + this.cadastro + "\nValor original: R$ " + this.valor 
        + "\nValor de venda: R$ " + this.precoDeVenda();
    }

    public static String livrosRegistrados(){return registrados;}

    public double precoDeVenda(){return 1.50*this.valor;}

    //Getters ---------------------------------------------------------------------------------------
    public String getTitulo(){return this.titulo;}

    public double getValor(){return this.valor;}

    public static int getQtd(){return qtd;}
}


package aula_pratica4;
import java.util.ArrayList;

public class Pedido {
    private int codigo;
    private String data;
    private ArrayList<Item> itens;
    private static int geradorDeCodigo=0;

    public Pedido(String data){
        this.data = data;
        this.itens = new ArrayList<>();
        geradorDeCodigo++;
        this.codigo = geradorDeCodigo;
    }
    public Pedido(int codigo){
        this.itens = new ArrayList<>();
        this.codigo = codigo;
    }
    public void inserirItem(Item item){
        itens.add(item);
    }
    public double calcularTotalPedido(){
        double total = 0;
            for(Item item : itens){
                total += item.calcularSubTotal();
            }
        return total;
    }
    public int getCodigo(){
        return this.codigo;
    }
    public String getData(){
        return data;
    }
    public ArrayList<Item> getItens(){
        return this.itens;
    }
}

//2. f): não é necessaria a implementação do setData e setCodigo, a menos que a requisição do menu seja expandida
//para que essas opções existam no laço e no switch case. dentro das opçoes de operações dadas pelo menu, não se 
//vê necessidade para a criação desses métodos. 
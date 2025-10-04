package aula_pratica4;
public class Conta {
    private static int contConta = 0;
    private int numero;
    private Cliente cliente;
    private double saldo;

    //Construtores---------------------------------------------
    public Conta(Cliente cliente) {
        this.cliente = cliente;
        this.numero = ++contConta;
        this.saldo = 0.0;
    }

    public Conta(Cliente cliente, double saldo) {
        this.cliente = cliente;
        this.numero = ++contConta;
        this.saldo = saldo;
    }

    // Getters e Setters -------------------------------------
    public int getNumero() {
        return numero;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public double getSaldo() {
        return saldo;
    }

    //Métodos ------------------------------------------------
    public void depositar(double valor) {
        if (valor > 0) {
            saldo += valor;
        }
    }

    public boolean sacar(double valor) {
        if (valor > 0 && saldo >= valor) {
            saldo -= valor;
            return true;
        }
        return false;
    }

    public boolean transferir(Conta destino, double valor){ //saca da conta this do metodo e deposita na que é passada por referência.
        if(sacar(valor)) {
            destino.depositar(valor);
            return true;
        }
        return false;
    }

    public String imprimir() {
        return "Conta Nº: " + numero + "\nCliente: " + cliente.getNome() + "\nSaldo: R$ " + saldo;
    }
}

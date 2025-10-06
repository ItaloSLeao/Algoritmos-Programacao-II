package aula_pratica4;

class Questao01a {
    public static void main(String[] args) {
        int x = 37;
        System.out.println(x);
    }
    }

    //Cannot make a static reference to the non-static field x 
    //O código não foi executado corretamente, pois a variavel x esta em uma classe nao estatica, e comando de impressao
    //a referenciando estava na classe estatica, gerando uma incompatibilidade.


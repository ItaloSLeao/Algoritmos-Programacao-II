package aula_pratica5;

import java.util.ArrayList;

public class TesteArrayList{
    public static void main(String[] args) {
        ArrayList<Pessoa> pessoas = new ArrayList<>();
        pessoas.add(new Pessoa("Fulano", 20));
        pessoas.add(new Pessoa("Beltrano", 18));
        pessoas.add(new Pessoa("Ciclano", 23));

        for (int i = 0; i < pessoas.size(); i++)
            System.out.println(pessoas.get(i).imprimir());
        }
}

//1.a) a saída foi a impressão dos objetos como o compilador o representa:
//AulaPratica05.Pessoa@28a418fc
//AulaPratica05.Pessoa@5305068a
//AulaPratica05.Pessoa@1f32e575

//1.b) o programa não reconhece o método imprimir, pois ele está definido para a classe pessoa
//e o arraylist até o momento não foi atribuido uma classe.

//1.c) agora acontece a impressão dos objetos da lista como foi solicitado:
//Fulano
//20 ano(s)
//Beltrano
//18 ano(s)
//Ciclano
//23 ano(s)


//1.d) foi implementado a classe pessoa ao arraylist pessoas, definindo o método imprimir().

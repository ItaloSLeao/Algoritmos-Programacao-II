package aula_pratica4.outrosExercicios;

import javax.swing.JOptionPane;

public class AppArray{
    public static void main (String[] arg){

        int quantidade=Integer.parseInt(JOptionPane.showInputDialog("Digite a quantidade de produtos"));
        String[] produtos = new String[quantidade];
        double[] valores = new double[quantidade];

        for(int i=0; i<quantidade; i++){
            produtos[i] = JOptionPane.showInputDialog("Digite o nome do produto " + (i+1));
            valores[i] = Double.parseDouble(JOptionPane.showInputDialog("Digite o valor do produto " + (i+1)));
        }

        String op = JOptionPane.showInputDialog("Você quer buscar algum produto? (S/N)");

            while(op.equalsIgnoreCase("S")){
                String nomeBusca = JOptionPane.showInputDialog("Digite o nome do produto que quer buscar");
                boolean encontrado = false;

                    for(int i=0; i<quantidade; i++){
                        if(nomeBusca.equals(produtos[i])){
                            JOptionPane.showMessageDialog(null,"Produto encontrado!\n" + produtos[i] 
                            + "\nValor: R$ " + valores[i]);
                            encontrado = true;
                            break;
                        }
                    }

                    if(!encontrado){
                        JOptionPane.showMessageDialog(null, "Produto não encontrado");
                    }

                    op = JOptionPane.showInputDialog("Você quer buscar algum produto? (S/N)");
            }
    }

}

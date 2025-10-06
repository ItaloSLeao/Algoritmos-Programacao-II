package aula_pratica2;

import javax.swing.JOptionPane;

public class LanchoneteTeste {
    public static void main(String[] args) {
        float total=0f; 
        Produto lanche1 = new Produto();
            lanche1.nomeProduto = "Delicias-burguer";
            lanche1.descricao = "Pão, hambúrguer, mussarela, maionese, alface e tomate.";
            lanche1.codigo = 1;
            lanche1.preco = 13.95f;
        Produto lanche2 = new Produto();
            lanche2.nomeProduto = "Delicias-egg";
            lanche2.descricao = "Pão, hambúrguer, mussarela, salada e ovo.";
            lanche2.codigo = 2;
            lanche2.preco = 11.45f;            
        Produto bebida1 = new Produto();
            bebida1.nomeProduto = "Coca-Cola Zero";
            bebida1.descricao = "Lata 500mL";
            bebida1.codigo = 3;
            bebida1.preco = 2.95f;
        Produto bebida2 = new Produto();
            bebida2.nomeProduto = "Suco de Uva Integral";
            bebida2.descricao = "1,35L";
            bebida2.codigo = 4;
            bebida2.preco = 10.45f;                    


        JOptionPane.showMessageDialog(null, "Bem vindo(a) à Lanchonete Delicias. A seguir será apresentado nosso cardápio.\nConforme solicitado, digite a quantidade que deseja pedir.");
        String quantidade1 = JOptionPane.showInputDialog(lanche1.codigo + " - " + lanche1.nomeProduto + ": " + lanche1.descricao + "\nR$ " + lanche1.preco + "\nDigite quantos você deseja: ");
            lanche1.quantidade = Integer.parseInt(quantidade1);
            total += lanche1.calculaValor();
        String quantidade2 = JOptionPane.showInputDialog(lanche2.codigo + " - " + lanche2.nomeProduto + ": " + lanche2.descricao + "\nR$ " + lanche2.preco + "\nDigite quantos você deseja: ");
            lanche2.quantidade = Integer.parseInt(quantidade2);
            total += lanche2.calculaValor();
        String quantidade3 = JOptionPane.showInputDialog(bebida1.codigo + " - " + bebida1.nomeProduto + ": " + bebida1.descricao + "\nR$ " + bebida1.preco + "\nDigite quantos você deseja: ");
            bebida1.quantidade = Integer.parseInt(quantidade3);
            total += bebida1.calculaValor();
        String quantidade4 = JOptionPane.showInputDialog(bebida2.codigo + " - " + bebida2.nomeProduto + ": " + bebida2.descricao + "\nR$ " + bebida2.preco + "\nDigite quantos você deseja: ");
            bebida2.quantidade = Integer.parseInt(quantidade4);  
            total += bebida2.calculaValor();     

        String pagamentoStr = JOptionPane.showInputDialog("Pedido realizado com sucesso! Valor total da sua compra: R$ " + total + "\nInsira abaixo com quanto irá pagar");
            float pagamento = Float.parseFloat(pagamentoStr);
        while(pagamento < total){
            pagamentoStr = JOptionPane.showInputDialog("Estimado(a) cliente, seu pagamento é insuficiente, digite novamente seu pagamento ou insira (cancelar) para cancelar seu pedido");
                if(pagamentoStr.equals("cancelar")){
                    JOptionPane.showMessageDialog(null, "Seu pedido foi cancelado! Volte Sempre!");
                    return;
                } else{
                    pagamento = Float.parseFloat(pagamentoStr);
                }
        }        
        JOptionPane.showMessageDialog(null, "Seu pagamento foi realizado com sucesso!\nSeu troco:" + (pagamento-total) + "\nObrigado e volte sempre, atenciosamente Lanchonete Delicias");

    }
}


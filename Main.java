package atividade_II;
import java.time.LocalDate;

public class Main {
    static void main() {
    Entrega entregaNormal = new EntregaNormal();
    Entrega entregaExpressa = new EntregaExpressa();
    Entrega retiradaNaLoja = new RetiradaNaLoja();
    Entrega entregaAgendada = new EntregaAgendada(LocalDate.now().plusDays(5));

    Pedido pedido = new Pedido( "arthur",entregaNormal, 129.99, 10 );
    Pedido pedido2 = new Pedido( "pedro",entregaExpressa, 240.50, 1.5);
    Pedido pedido3 = new Pedido( "caiq",retiradaNaLoja, 100, 3);
    Pedido pedido4 = new Pedido( "joao",entregaAgendada, 245, 5);

    System.out.println(pedido4);
    }
}


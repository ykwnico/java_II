package atividade_II;

import java.time.LocalDate;

class EntregaExpressa extends Entrega {

    @Override
    public double calcularFrete(double valorProduto) {
        double taxa = 20;
        return (valorProduto * taxa) / 100 ;
    }

    @Override
    public int calcularPrazo() {
        return 2;
    }
}

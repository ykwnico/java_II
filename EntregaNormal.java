package atividade_II;

import java.time.LocalDate;

class EntregaNormal extends Entrega {

    @Override
    public double calcularFrete(double valorProduto) {
        double taxa = 10;
        return (valorProduto * taxa) / 100;
    }
    @Override
    public int calcularPrazo() {
        return 7;
    }
}

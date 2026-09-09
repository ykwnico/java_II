package atividade_II;

import java.time.LocalDate;

class RetiradaNaLoja extends Entrega {

    @Override
    public double calcularFrete(double valorProduto) {
        return 0;
    }
    @Override
    public int calcularPrazo() {
        return 1;
    }
}

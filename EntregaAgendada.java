package atividade_II;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

class EntregaAgendada extends Entrega {
    private LocalDate dataEscolhida;

    EntregaAgendada(LocalDate dataEscolhida) {
        if (dataEscolhida.isBefore(LocalDate.now())) {
            throw new IllegalArgumentException("A data de agendamento não pode ser no passado.");
        }
        this.dataEscolhida = dataEscolhida;
    }

    @Override
    public double calcularFrete(double valorProduto) {
        double taxa = 20;
        return (valorProduto * taxa) / 100 ;
    }

    @Override
    public int calcularPrazo() {
        long diasDePrazo = ChronoUnit.DAYS.between(LocalDate.now(), dataEscolhida);
        return (int) diasDePrazo;
    }
}
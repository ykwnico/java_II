package atividade_II;

public class Pedido {

    private static int contadorID = 0;

    public final int  idPedido;
    public final String nomeCliente;
    public final double valorProduto;
    public double pesoTotal;
    public double distanciaKM;
    private final Entrega modalidade;

    public Pedido(String nomeCliente, Entrega modalidade, double valorProduto, double pesoTotal){

        contadorID++;

        this.idPedido = contadorID;

        this.nomeCliente = nomeCliente;
        this.valorProduto = valorProduto;
        this.pesoTotal = pesoTotal;
        this.modalidade = modalidade;
    }

    public double getValorProduto() {
        return valorProduto;
    }

    public String getNomeCliente() {
        return nomeCliente;
    }

    public int getIdPedido() {
        return idPedido;
    }

    public double calcularFrete() {
        return this.modalidade.calcularFrete(this.valorProduto);
    }

    public int calcularPrazo(){
        return this.modalidade.calcularPrazo();
    }

    public double valorTotal(){
        return this.valorProduto + this.calcularFrete();
    }

    @Override
    public String toString() {
        return "Nome do cliente: " + nomeCliente +
                "\n ID do pedido: " + idPedido +
                "\n Peso total: " + pesoTotal +
                "\nTipo de entrega: " + modalidade.getClass().getSimpleName() +
                "\nPrazo de entrega: " + calcularPrazo() + " dia(s)" +
                "\nValor do produto: " + String.format("%.2f", valorProduto) +
                "\nFrete: " + String.format("%.2f", calcularFrete()) +
                "\n ___________________________________" +
                "\n Valor total: " + String.format("%.2f", valorTotal());
    }
}

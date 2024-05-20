package br.com.lyly.factory;

public class Gol implements Carro{
    @Override
    public void exibirInformacoes() {
        System.out.println("Modelo: Gol - Volkswagen");
    }

    @Override
    public void ligar() {
        System.out.println("O caro "+this.getClass().getSimpleName()+" está ligando.");
    }

    @Override
    public void frear() {
        System.out.println("O caro "+this.getClass().getSimpleName()+" está parando.");
    }
}

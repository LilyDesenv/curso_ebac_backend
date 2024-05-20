package br.com.lyly;

import br.com.lyly.factory.Carro;
import br.com.lyly.factory.CarroFactory;
import br.com.lyly.factory.ChevroletFactory;
import br.com.lyly.factory.VolkswagenFactory;

public class App {
    public static void main(String[] args) {
        CarroFactory chevroletFactory = new ChevroletFactory();
        Carro chev = chevroletFactory.criarCarro();
        chev.exibirInformacoes();
        chev.ligar();
        chev.frear();

        System.out.println("\n ************************************\n");

        CarroFactory volksFactory = new VolkswagenFactory();
        Carro volks = volksFactory.criarCarro();
        volks.exibirInformacoes();
        volks.ligar();
        volks.frear();
    }
}

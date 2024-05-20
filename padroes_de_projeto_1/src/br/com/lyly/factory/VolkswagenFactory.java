package br.com.lyly.factory;

public class VolkswagenFactory implements CarroFactory{
    @Override
    public Carro criarCarro() {
        return new Gol();
    }
}

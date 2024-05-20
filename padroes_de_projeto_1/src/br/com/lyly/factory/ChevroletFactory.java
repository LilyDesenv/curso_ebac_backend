package br.com.lyly.factory;

public class ChevroletFactory implements CarroFactory{
    @Override
    public Carro criarCarro() {
        return new Onix();
    }
}

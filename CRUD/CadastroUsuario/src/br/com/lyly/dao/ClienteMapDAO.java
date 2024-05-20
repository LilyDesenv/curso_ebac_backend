package br.com.lyly.dao;

import br.com.lyly.model.Cliente;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class ClienteMapDAO implements IClienteDAO{

    private Map<Long, Cliente> map;

    public ClienteMapDAO() {
        this.map = new HashMap<>();
    }

    @Override
    public Boolean cadastrar(Cliente cliente) {
        if (this.map.containsKey(cliente.getCpf())){
            return false;
        }
        this.map.put(cliente.getCpf(), cliente);
        return true;
    }

    @Override
    public void excluir(Long cpf) {
        Cliente c = this.map.get(cpf);

        if(c != null){
            this.map.remove(c.getCpf(), c);
        }

    }

    @Override
    public void alterar(Cliente cliente) {
        Cliente c = this.map.get(cliente.getCpf());

        if(c != null){
            c.setNome((cliente.getNome()));
            c.setTel(cliente.getTel());
            c.setNumero(cliente.getNumero());
            c.setEndereco(cliente.getEndereco());
            c.setCidade(cliente.getCidade());
            c.setEstado(cliente.getEstado());
        }
    }

    @Override
    public Cliente consultar(Long cpf) {
        return this.map.get(cpf);
    }

    @Override
    public Collection<Cliente> buscarTodos() {
        return this.map.values();
    }
}

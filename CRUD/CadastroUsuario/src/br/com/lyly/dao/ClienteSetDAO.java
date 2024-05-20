package br.com.lyly.dao;

import br.com.lyly.model.Cliente;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ClienteSetDAO implements IClienteDAO{

    private Set<Cliente> set;

    public ClienteSetDAO(){this.set = new HashSet<>();}

    @Override
    public Boolean cadastrar(Cliente cliente) {
        return this.set.add(cliente);
    }

    @Override
    public void excluir(Long cpf) {
        Cliente clienteEncontrado = null;
        for(Cliente c : this.set){
            if(c.getCpf().equals(cpf)){
                clienteEncontrado = c;
                break;
            }
        }

        if(clienteEncontrado != null){
            this.set.remove(clienteEncontrado);
        }
    }

    @Override
    public void alterar(Cliente cliente) {
        if(this.set.contains(cliente)){
            for(Cliente c: this.set){
                if(c.equals(cliente)){
                    c.setNome(cliente.getNome());
                    c.setTel(cliente.getTel());
                    c.setNumero(cliente.getNumero());
                    c.setEndereco(cliente.getEndereco());
                    c.setCidade(cliente.getCidade());
                    c.setEstado(cliente.getEstado());
                    break;
                }
            }
        }
    }

    @Override
    public Cliente consultar(Long cpf) {
        for (Cliente c : this.set){
            if(c.getCpf().equals(cpf)){
                return c;
            }
        }
        return null;
    }

    @Override
    public Collection<Cliente> buscarTodos() {
        return this.set;
    }
}

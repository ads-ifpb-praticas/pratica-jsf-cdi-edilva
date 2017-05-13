package br.edu.ifpb.praticas.pratica.jsf.cdi.controller;

import br.edu.ifpb.praticas.pratica.jsf.cdi.dao.ClienteDao;
import br.edu.ifpb.praticas.pratica.jsf.cdi.entidades.Cliente;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author Edilva
 */
@Named
@ViewScoped
public class ClienteController implements Serializable{
    
    @Inject
    private Cliente cliente;
    @Inject
    private ClienteDao dao;
    private List<Cliente> clientes = new ArrayList<>();
    
    public String salvar(){
        dao.salvar(cliente);
        limpar();
        return null;
    }
    
    public String editar(){
        dao.editar(cliente);
        limpar();
        return "gerenciamento.xhtml";
    }
    
    public String excluir(Cliente c){
        dao.remover(c.getId());
        return null;
    }
    
    public String exibir(Cliente c){
        cliente = c;
        return "cliente.xhtml";
    }
    
    private void limpar(){
        cliente = new Cliente();
    }
    
    public void listar(){
        clientes = dao.listar();
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public List<Cliente> getClientes() {
        return clientes;
    }

    public void setClientes(List<Cliente> clientes) {
        this.clientes = clientes;
    }
    
}

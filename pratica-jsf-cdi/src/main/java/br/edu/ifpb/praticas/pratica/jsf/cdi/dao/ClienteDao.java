
package br.edu.ifpb.praticas.pratica.jsf.cdi.dao;

import br.edu.ifpb.praticas.pratica.jsf.cdi.entidades.Cliente;
import java.util.List;

/**
 *
 * @author Edilva
 */
public interface ClienteDao {
    
    void salvar(Cliente cliente);
    void remover(int id);
    void editar(Cliente cliente);
    Cliente exibir(int id);
    List<Cliente> listar();
}

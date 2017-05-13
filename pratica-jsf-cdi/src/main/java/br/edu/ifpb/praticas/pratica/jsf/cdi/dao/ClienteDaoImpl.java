
package br.edu.ifpb.praticas.pratica.jsf.cdi.dao;

import br.edu.ifpb.praticas.pratica.jsf.cdi.entidades.Cliente;
import java.util.List;
import javax.inject.Inject;
import javax.persistence.EntityManager;

/**
 *
 * @author Edilva
 */
public class ClienteDaoImpl implements ClienteDao{
    
    @Inject
    private EntityManager entityManager;

    public ClienteDaoImpl() {
    }

    @Override
    public void salvar(Cliente cliente) {
        entityManager.persist(cliente);
    }

    @Override
    public void remover(int id) {
        Cliente cliente = exibir(id);
        entityManager.remove(cliente);
    }

    @Override
    public void editar(Cliente cliente) {
        entityManager.merge(cliente);
    }

    @Override
    public Cliente exibir(int id) {
        return entityManager.find(Cliente.class, id);
    }

    @Override
    public List<Cliente> listar() {
        return entityManager.createQuery("SELECT c FROM Cliente c", Cliente.class).getResultList();
    }
    
}

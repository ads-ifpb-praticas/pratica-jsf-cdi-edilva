package br.edu.ifpb.praticas.pratica.jsf.cdi.util;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Disposes;
import javax.enterprise.inject.Produces;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Edilva
 */
@ApplicationScoped
public class ProdutorEntityManager {

    private EntityManagerFactory factory;

    public ProdutorEntityManager() {
        this.factory = Persistence.createEntityManagerFactory("pratica-jsf-cdi");
    }
    
    @Produces
    @RequestScoped
    public EntityManager criaEntityManager() {
        return factory.createEntityManager();
    }
    
    public void finaliza(@Disposes EntityManager manager) {
      manager.close();
   }
}

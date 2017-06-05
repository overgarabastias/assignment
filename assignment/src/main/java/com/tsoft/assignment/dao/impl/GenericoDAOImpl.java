package com.tsoft.assignment.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.tsoft.assignment.dao.GenericoDAO;

@Repository
public class GenericoDAOImpl implements GenericoDAO{
	
	private EntityManager em = null;

    /*
     * Seteando el entity manager.
     */
    @PersistenceContext(type=PersistenceContextType.EXTENDED)
    public void setEntityManager(EntityManager em) {
        this.em = em;
    }
    
    @Transactional
	public Object guardarOActualizar(Object object) {
//    	 em.persist(object);
//    	 System.out.println(object.toString());
    	Object obj = em.merge(object);
		 return obj;
	}

	@SuppressWarnings("unchecked")
	@Transactional
	public List<Object> buscar(String query) {
		return em.createQuery(query).getResultList();
	}
	
	@Transactional
	public Query getQuery(String query){
		return em.createQuery(query);
	}

}

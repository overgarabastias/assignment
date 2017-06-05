package com.tsoft.assignment.dao.impl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tsoft.assignment.dao.GenericoDAO;
import com.tsoft.assignment.dao.ProyectoDAO;
import com.tsoft.assignment.to.CentroCostoTO;
import com.tsoft.assignment.to.ProyectoTO;
import com.tsoft.assignment.to.RecursoTO;

@Service
public class ProyectoDAOImpl implements ProyectoDAO {

	@Autowired
	private GenericoDAO genericoDao;
	
	private static String queryBuscarPorIdCentroCosto = "select p from ProyectoTO p where p.centroCosto.id= ?1";
	private static String queryBuscarPorIdRecurso = "select p from ProyectoTO p, ProyectoRecursoTO pr where p.id = pr.proyecto.id  and pr.recurso.id= ?1";
	private static String queryBuscarTodos = "select p from ProyectoTO p";

	public ProyectoTO guardarOActualizar(ProyectoTO proyecto) {
		return (ProyectoTO)genericoDao.guardarOActualizar(proyecto);
	}

	public List<ProyectoTO> buscarTodos() {
		List<Object> resultado = genericoDao.buscar(queryBuscarTodos);
		
		List<ProyectoTO> proyectos = new ArrayList<ProyectoTO>();
		for (int i = 0; i < resultado.size(); i++) {
			proyectos.add((ProyectoTO)resultado.get(i));
		}
		
		return proyectos;
	}

	@SuppressWarnings("unchecked")
	public List<ProyectoTO> buscarPorCentroCosto(CentroCostoTO centroCosto) {
		
		Query query = genericoDao.getQuery(queryBuscarPorIdCentroCosto);
		
		query.setParameter(1, centroCosto.getId());
		
		return query.getResultList();
	}

	public List<ProyectoTO> buscarPorRecurso(RecursoTO recurso) {
		
		Query query = genericoDao.getQuery(queryBuscarPorIdRecurso);
		
		query.setParameter(1, recurso.getId());
		
		return query.getResultList();
	}

}

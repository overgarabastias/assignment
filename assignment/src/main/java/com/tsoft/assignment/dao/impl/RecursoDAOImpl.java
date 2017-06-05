package com.tsoft.assignment.dao.impl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tsoft.assignment.dao.GenericoDAO;
import com.tsoft.assignment.dao.RecursoDAO;
import com.tsoft.assignment.to.ProyectoTO;
import com.tsoft.assignment.to.RecursoTO;

@Service
public class RecursoDAOImpl implements RecursoDAO {
	
	@Autowired
	private GenericoDAO genericoDao;
	
	private static String queryBuscarPorIdProyecto = "select r from RecursoTO r, ProyectoRecursoTO pr where r.id = pr.proyecto.id  and pr.proyecto.id= ?1";
	private static String queryBuscarTodos = "select r from RecursoTO r";

	public RecursoTO guardarOActualizar(RecursoTO recurso) {
		
		return (RecursoTO)genericoDao.guardarOActualizar(recurso);
	}

	public List<RecursoTO> buscarTodos() {
		List<Object> resultado = genericoDao.buscar(queryBuscarTodos);
		
		List<RecursoTO> recursos = new ArrayList<RecursoTO>();
		for (int i = 0; i < resultado.size(); i++) {
			recursos.add((RecursoTO)resultado.get(i));
		}
		return recursos;
	}

	public List<RecursoTO> buscarPorRecurso(ProyectoTO proyecto) {
		
		Query query = genericoDao.getQuery(queryBuscarPorIdProyecto);
		
		query.setParameter(1, proyecto.getId());
		
		return query.getResultList();
	}

}

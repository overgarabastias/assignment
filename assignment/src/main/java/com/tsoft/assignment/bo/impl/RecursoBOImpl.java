package com.tsoft.assignment.bo.impl;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tsoft.assignment.bo.RecursoBO;
import com.tsoft.assignment.dao.RecursoDAO;
import com.tsoft.assignment.to.ProyectoTO;
import com.tsoft.assignment.to.RecursoTO;

@Service
public class RecursoBOImpl implements RecursoBO {
	
	@Autowired
	private RecursoDAO recursoDao;

	public RecursoTO guardarOActualizar(RecursoTO parametros) {
		return recursoDao.guardarOActualizar(parametros);
	}

	public List<RecursoTO> buscarTodos() {
		return recursoDao.buscarTodos();
	}

	public List<RecursoTO> buscarPorProyecto(ProyectoTO proyecto) {
		return recursoDao.buscarPorRecurso(proyecto);
	}

}

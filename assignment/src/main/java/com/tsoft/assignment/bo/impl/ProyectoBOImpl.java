package com.tsoft.assignment.bo.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tsoft.assignment.bo.ProyectoBO;
import com.tsoft.assignment.dao.ProyectoDAO;
import com.tsoft.assignment.to.CentroCostoTO;
import com.tsoft.assignment.to.ProyectoTO;
import com.tsoft.assignment.to.RecursoTO;

@Service
public class ProyectoBOImpl implements ProyectoBO {

	@Autowired
	private ProyectoDAO proyectoDao;
	
	public ProyectoTO guardarOActualizar(ProyectoTO parametros) {
		return proyectoDao.guardarOActualizar(parametros);
	}

	public List<ProyectoTO> buscarTodos() {
		return proyectoDao.buscarTodos();
	}

	public List<ProyectoTO> buscarPorCentroCosto(CentroCostoTO centroCosto) {
		return proyectoDao.buscarPorCentroCosto(centroCosto);
	}

	public List<ProyectoTO> buscarPorRecurso(RecursoTO recurso) {
		// TODO Auto-generated method stub
		return proyectoDao.buscarPorRecurso(recurso);
	}
}

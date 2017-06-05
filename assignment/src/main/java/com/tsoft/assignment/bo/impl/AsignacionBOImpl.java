package com.tsoft.assignment.bo.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tsoft.assignment.bo.AsignacionBO;
import com.tsoft.assignment.dao.AsignacionDAO;
import com.tsoft.assignment.to.AsignacionFiltroTO;
import com.tsoft.assignment.to.AsignacionTO;

@Service
public class AsignacionBOImpl implements AsignacionBO {

	@Autowired
	private AsignacionDAO asignacionDao;

	public AsignacionTO guardarOActualizar(AsignacionTO asignacion) {
		return asignacionDao.guardarOActualizar(asignacion);
	}

	public List<AsignacionTO> buscarTodos() {
		return asignacionDao.buscarTodos();
	}

	public Boolean buscarPorRecursoYFecha(AsignacionFiltroTO parametros) {
		if(asignacionDao.buscarPorRecursoYFecha(parametros).size() > 0){
			return true;
		}else{
			return false;
		}
		
	}

}

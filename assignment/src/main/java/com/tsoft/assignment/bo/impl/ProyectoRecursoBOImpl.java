package com.tsoft.assignment.bo.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tsoft.assignment.bo.ProyectoRecursoBO;
import com.tsoft.assignment.dao.ProyectoRecursoDAO;
import com.tsoft.assignment.to.ProyectoRecursoTO;

@Service
public class ProyectoRecursoBOImpl implements ProyectoRecursoBO {

	@Autowired
	private ProyectoRecursoDAO proyectoRecursoDao;
	
	public ProyectoRecursoTO guardarOActualizar(ProyectoRecursoTO proyectoRecurso) {
		return proyectoRecursoDao.guardarOActualizar(proyectoRecurso);
	}

	public Boolean eliminar(ProyectoRecursoTO proyectoRecurso) {
		return proyectoRecursoDao.borrar(proyectoRecurso);
	}
	

}

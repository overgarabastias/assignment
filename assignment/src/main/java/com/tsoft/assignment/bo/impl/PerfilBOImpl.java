package com.tsoft.assignment.bo.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tsoft.assignment.bo.PerfilBO;
import com.tsoft.assignment.dao.PerfilDAO;
import com.tsoft.assignment.to.PerfilTO;

@Service
public class PerfilBOImpl implements PerfilBO {

	@Autowired
	private PerfilDAO perfilDao;
	
	public PerfilTO guardarOActualizar(PerfilTO parametros) {
		return perfilDao.guardarOActualizar(parametros);
	}

	public List<PerfilTO> buscarTodos() {
		return perfilDao.buscarTodos();
	}

}

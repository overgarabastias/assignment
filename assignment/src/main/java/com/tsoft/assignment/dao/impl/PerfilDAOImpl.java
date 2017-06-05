package com.tsoft.assignment.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tsoft.assignment.dao.GenericoDAO;
import com.tsoft.assignment.dao.PerfilDAO;
import com.tsoft.assignment.to.PerfilTO;

@Service
public class PerfilDAOImpl implements PerfilDAO {
	
	@Autowired
	private GenericoDAO genericoDao;
	
	private static String queryBuscarTodos = "select p from PerfilTO p";


	public PerfilTO guardarOActualizar(PerfilTO perfil) {
		return (PerfilTO)genericoDao.guardarOActualizar(perfil);
	}

	public List<PerfilTO> buscarTodos() {
		List<Object> resultado = genericoDao.buscar(queryBuscarTodos);
		
		List<PerfilTO> perfil = new ArrayList<PerfilTO>();
		for (int i = 0; i < resultado.size(); i++) {
			perfil.add((PerfilTO)resultado.get(i));
		}
		
		return perfil;
	}
}

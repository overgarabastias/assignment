package com.tsoft.assignment.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tsoft.assignment.dao.ClienteDAO;
import com.tsoft.assignment.dao.GenericoDAO;
import com.tsoft.assignment.to.ClienteTO;

@Service
public class ClienteDAOImpl implements ClienteDAO {
	
	@Autowired
	private GenericoDAO genericoDao;
	
	private static String queryBuscarTodos = "select c from ClienteTO c";

	public ClienteTO guardarOActualizar(ClienteTO cliente) {
		
		return (ClienteTO)genericoDao.guardarOActualizar(cliente);
	
	}

	public List<ClienteTO> buscarTodos() {
		
		List<Object> resultado = genericoDao.buscar(queryBuscarTodos);
		
		List<ClienteTO> clientes = new ArrayList<ClienteTO>();
		
		for (int i = 0; i < resultado.size(); i++) {
			clientes.add((ClienteTO)resultado.get(i));
		}
		
		return clientes;
	}

}


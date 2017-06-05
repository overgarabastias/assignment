package com.tsoft.assignment.bo.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tsoft.assignment.bo.ClienteBO;
import com.tsoft.assignment.dao.ClienteDAO;
import com.tsoft.assignment.to.ClienteTO;

@Service
public class ClienteBOImpl implements ClienteBO {
	
	@Autowired
	private ClienteDAO cliente;

	public List<ClienteTO> buscarTodos() {
		return cliente.buscarTodos();
	}
	
	public ClienteTO guardarOActualizar(ClienteTO parametros) {
		return cliente.guardarOActualizar(parametros);
	}

}

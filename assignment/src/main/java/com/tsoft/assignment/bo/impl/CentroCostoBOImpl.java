package com.tsoft.assignment.bo.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tsoft.assignment.bo.CentroCostoBO;
import com.tsoft.assignment.dao.CentroCostoDAO;
import com.tsoft.assignment.to.CentroCostoTO;
import com.tsoft.assignment.to.ClienteTO;

@Service
public class CentroCostoBOImpl implements CentroCostoBO {
	
	@Autowired
	private CentroCostoDAO centroCostoDao;

	public CentroCostoTO guardarOActualizar(CentroCostoTO parametros) {
		return centroCostoDao.guardarOActualizar(parametros);
	}

	public List<CentroCostoTO> buscarTodos() {
		return centroCostoDao.buscarTodos();
	}

	public List<CentroCostoTO> buscarPorCliente(ClienteTO cliente) {
		return centroCostoDao.buscarPorIdCliente(cliente);
	}

}

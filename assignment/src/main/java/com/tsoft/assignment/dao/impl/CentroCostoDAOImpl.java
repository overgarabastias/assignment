package com.tsoft.assignment.dao.impl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tsoft.assignment.dao.CentroCostoDAO;
import com.tsoft.assignment.dao.GenericoDAO;
import com.tsoft.assignment.to.CentroCostoTO;
import com.tsoft.assignment.to.ClienteTO;

@Service
public class CentroCostoDAOImpl implements CentroCostoDAO {

	@Autowired
	private GenericoDAO genericoDao;
	
	private static String queryBuscarPorIdCliente = "select c from CentroCostoTO c where c.cliente.id= ?1";
	private static String queryBuscarTodos = "select c from CentroCostoTO c";

	public CentroCostoTO guardarOActualizar(CentroCostoTO centroCosto) {
		return (CentroCostoTO)genericoDao.guardarOActualizar(centroCosto);
	}

	public List<CentroCostoTO> buscarTodos() {
		List<Object> resultado = genericoDao.buscar(queryBuscarTodos);
		
		List<CentroCostoTO> centroCostos = new ArrayList<CentroCostoTO>();
		for (int i = 0; i < resultado.size(); i++) {
			centroCostos.add((CentroCostoTO)resultado.get(i));
		}
		return centroCostos;
	}

	@SuppressWarnings("unchecked")
	public List<CentroCostoTO> buscarPorIdCliente(ClienteTO cliente) {
		
		Query query = genericoDao.getQuery(queryBuscarPorIdCliente);
		query.setParameter(1, cliente.getId());
		return query.getResultList();
	}

}

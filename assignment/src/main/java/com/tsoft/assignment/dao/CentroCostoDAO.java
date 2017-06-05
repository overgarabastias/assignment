package com.tsoft.assignment.dao;

import java.util.List;

import com.tsoft.assignment.to.CentroCostoTO;
import com.tsoft.assignment.to.ClienteTO;

/**
 * 
 * @author omar.vergara
 * Clase de la capa dao encargadad de los siguiente:
 * Guardar o actualizar los CentroCosto.
 * Buscar todos los PPM de la base de datos.
 */
public interface CentroCostoDAO {
	
	/**
	 * Metodo para actualizar o guardar los CentroCosto
	 * @param CentroCosto PerfilTO que sera el que se guarde o actualice
	 * @return retona el perfilTO que se actualizo o guardo
	 */
	public CentroCostoTO guardarOActualizar(CentroCostoTO CentroCosto);
	
	/**
	 * metodo que retona todos los CentroCosto de la base de datos
	 * @return retorna un listado de CentroCostoTO que estan en base de datos
	 */
	public List<CentroCostoTO> buscarTodos();
	
	/**
	 * Metodo que retorna todos los CentroCosto asignados a un cliente 
	 * @return retorna un listado de centro de costo
	 */
	public List<CentroCostoTO> buscarPorIdCliente(ClienteTO cliente);

}

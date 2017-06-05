package com.tsoft.assignment.bo;

import java.util.List;

import com.tsoft.assignment.to.CentroCostoTO;
import com.tsoft.assignment.to.ClienteTO;

/**
 * 
 * @author omar.vergara
 * Clase de la capa de negocio encargada de manejar la logica de los centro de costo:
 * Guardar o actualizar un centro de costo
 * Buscar todos los centro de costo
 */
public interface CentroCostoBO {

	/**
	 * Metodo para guardar o actualizar un centro de costo
	 * @param parametros parametros a guardar en la base de datos
	 * @return retorna el CentroCostoTO que fue guardado o modificado
	 */
	public CentroCostoTO guardarOActualizar(CentroCostoTO parametros);
	
	/**
	 * Metodo para buscar todos los centro de costo en la base de datos
	 * @return retorna una lista de CentroCostoTO
	 */
	public List<CentroCostoTO> buscarTodos();
	
	
	/**
	 * Metodo para buscar todos los centro de costo que estan asignados a un cliente
	 * @return retorna una lista de centroCostoTO
	 */
	public List<CentroCostoTO> buscarPorCliente(ClienteTO cliente);
	
}

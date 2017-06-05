package com.tsoft.assignment.dao;

import java.util.List;

import com.tsoft.assignment.to.ClienteTO;

/**
 * 
 * @author omar.vergara
 * Clase de la capa dao para relizar acciones en la base de datos.
 */
public interface ClienteDAO {
	
	/**
	 * Metodo para guardar o actualizar un cliente en la base de datos
	 * @param cliente ClienteTO con la informacion que se desea guardar en la base de datos
	 * @return retorna el clienteTO que se actualizo o ingreso.
	 */
	public ClienteTO guardarOActualizar(ClienteTO cliente);
	
	/**
	 * metodo engargado de buscar en la base de datos todos los clientes
	 * @return retorna una lista de clientesTO
	 */
	public List<ClienteTO> buscarTodos();
}

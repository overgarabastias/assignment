package com.tsoft.assignment.bo;

import java.util.List;

import com.tsoft.assignment.to.ClienteTO;

/***
 * 
 * @author omar.vergara
 * Clase de la capa de negocio encargada de manejar el negocio de los clientes.
 * Agregar o Actualizar un cliente.
 * Buscar todos los clientes.
 */
public interface ClienteBO {
	
	/**
	 * Metodo busca todos los clientes que estan en la base de datos.
	 * @return Retrona un listado de clientes obtenidos de la base de datos.
	 */
	public List<ClienteTO> buscarTodos();
	
	/**
	 * Metodo para guardar o actualizar un cliente.
	 * @param cliente objeto que se quiere guardar o actualizar en la base de datos.
	 * @return retorna el cliente que fue actualizado o guardado en la base de datos.
	 */
	public ClienteTO guardarOActualizar(ClienteTO cliente);

}

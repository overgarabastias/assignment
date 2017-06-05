package com.tsoft.assignment.dao;

import java.util.List;

import com.tsoft.assignment.to.PerfilTO;

/**
 * 
 * @author omar.vergara
 * Clase de la capa dao encargadad de los siguiente:
 * Guardar o actualizar los perfiles.
 * Buscar todos los perfiles de la base de datos.
 */
public interface PerfilDAO {
	
	
	/**
	 * Metodo para actualizar o guardar los perfiles
	 * @param perfil PerfilTO que sera el que se guarde o actualice
	 * @return retona el perfilTO que se actualizo o guardo
	 */
	public PerfilTO guardarOActualizar(PerfilTO perfil);
	
	/**
	 * metodo que retona todos los perfiles de la base de datos
	 * @return retorna un listado de PerfilesTO que estan en base de datos
	 */
	public List<PerfilTO> buscarTodos();

}

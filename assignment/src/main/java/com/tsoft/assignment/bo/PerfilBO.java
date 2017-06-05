package com.tsoft.assignment.bo;

import java.util.List;

import com.tsoft.assignment.to.PerfilTO;


/**
 * 
 * @author omar.vergara
 * Clase de la capa de negocio encargada de manejar la logica de los Perfiles:
 * Guardar o actualizar un Perfil
 * Buscar todos los perfiles
 */
public interface PerfilBO {
	
	/**
	 * Metodo para guardar o actualizar un Perfil
	 * @param parametros parametros a guardar en la base de datos
	 * @return retorna el perfilTO que fue guardado o modificado
	 */
	public PerfilTO guardarOActualizar(PerfilTO parametros);
	
	/**
	 * Metodo para buscar todos los perfiles en la base de datos
	 * @return retorna una lista de perfilTO
	 */
	public List<PerfilTO> buscarTodos();


}

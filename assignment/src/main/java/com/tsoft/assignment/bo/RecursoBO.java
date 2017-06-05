package com.tsoft.assignment.bo;

import java.util.List;

import com.tsoft.assignment.to.ProyectoTO;
import com.tsoft.assignment.to.RecursoTO;

/***
 * 
 * @author omar.vergara
 * Clase de la capa de negocio encargada de manejar la logica de los recursos:
 * Guardar o actualizar un recurso
 * Buscar todos los recursos
 */
public interface RecursoBO {
	
	/**
	 * Metodo para guardar o actualizar un recurso
	 * @param parametros parametros a guardar en la base de datos
	 * @return retorna el recrusoTO que fue guardado o modificado
	 */
	public RecursoTO guardarOActualizar(RecursoTO parametros);
	
	/**
	 * Metodo para buscar todos los recursos en la base de datos
	 * @return retorna una lista de RecursosTO
	 */
	public List<RecursoTO> buscarTodos();
	
	public List<RecursoTO> buscarPorProyecto(ProyectoTO proyecto);

}

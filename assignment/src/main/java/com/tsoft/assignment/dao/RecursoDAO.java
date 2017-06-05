package com.tsoft.assignment.dao;

import java.util.List;

import com.tsoft.assignment.to.ProyectoTO;
import com.tsoft.assignment.to.RecursoTO;

/**
 * 
 * @author omar.vergara
 * Clase de la capa dao encargada de:
 * Guardar o Actualizar los recursos
 * Buscar todos los recuros de la base de datos
 */
public interface RecursoDAO {
	
	/**
	 * Metodo para guardar o actualizar los recursos
	 * @param recurso RecursoTO que se guardara o actualizara
	 * @return retorna el recursoTO que se actualizo
	 */
	public RecursoTO guardarOActualizar(RecursoTO recurso);
	
	/**
	 * Metodo para buscar todos los recursos de la base de datos
	 * @return Retorna un listado de RecursosTO obtenidos de la base de datos.
	 */
	public List<RecursoTO> buscarTodos();
	
	public List<RecursoTO> buscarPorRecurso(ProyectoTO proyecto);

}

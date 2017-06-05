package com.tsoft.assignment.dao;

import java.util.List;

import com.tsoft.assignment.to.AsignacionFiltroTO;
import com.tsoft.assignment.to.AsignacionTO;


/**
 * 
 * @author omar.vergara
 * Clase de la capa dao encargadad de los siguiente:
 * Guardar o actualizar las Asignaciones.
 * Buscar todas las asignaciones de la base de datos.
 */
public interface AsignacionDAO {
	
	/**
	 * Metodo para actualizar o guardar los CentroCosto
	 * @param asignacion asignacion que sera el que se guarde o actualice
	 * @return retona el AsignacionTO que se actualizo o guardo
	 */
	public AsignacionTO guardarOActualizar(AsignacionTO asignacion);
	
	/**
	 * metodo que retona todos los Asignacion de la base de datos
	 * @return retorna un listado de AsignacionTO que estan en base de datos
	 */
	public List<AsignacionTO> buscarTodos();
	
	/**
	 * Metodo para buscar las asignaciones segun un recurso entre las fecha inicio y fecha fin 
	 * @param parametros Parametros para realizar la busqueda, id de usuario, fecha inicio y fecha fin
	 * @return retorna un listado de AsignacionTO
	 */
	public List<AsignacionTO> buscarPorRecursoYFecha(AsignacionFiltroTO parametros);

}

package com.tsoft.assignment.bo;

import java.util.List;

import com.tsoft.assignment.to.AsignacionFiltroTO;
import com.tsoft.assignment.to.AsignacionTO;

/**
 * 
 * @author omar.vergara
 * Clase de la capa de negocio encargada de manejar la logica de las Asignaciones:
 * Guardar o actualizar una asignacion
 * Buscar todas las asignaciones
 */
public interface AsignacionBO {
	
	/**
	 * Metodo para guardar o actualizar una asignacion
	 * @param parametros parametros a guardar en la base de datos
	 * @return retorna el AsignacionTO que fue guardado o modificado
	 */
	public AsignacionTO guardarOActualizar(AsignacionTO asignacion);
	
	/**
	 * Metodo para buscar todas las asignaciones en la base de datos
	 * @return retorna una lista de AsignacionTO
	 */
	public List<AsignacionTO> buscarTodos();
	
	
	/**
	 * Metodo para buscar las asignaciones segun un filtro
	 * @param parametros filtro a aplicarse para realizar la busqueda
	 * @return retorna un listado de AsignacionTO segun el filtro aplicado
	 */
	public Boolean buscarPorRecursoYFecha(AsignacionFiltroTO parametros);

}

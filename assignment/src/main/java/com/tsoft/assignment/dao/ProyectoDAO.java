package com.tsoft.assignment.dao;

import java.util.List;

import com.tsoft.assignment.to.CentroCostoTO;
import com.tsoft.assignment.to.ProyectoTO;
import com.tsoft.assignment.to.RecursoTO;

/**
 * 
 * @author omar.vergara
 * Clase de la capa dao encargadad de los siguiente:
 * Guardar o actualizar los proyectos.
 * Buscar todos los proyectos de la base de datos.
 */
public interface ProyectoDAO {
	
	/**
	 * Metodo para actualizar o guardar los proyectos
	 * @param proyecto ProyectoTO que sera el que se guarde o actualice
	 * @return retona el ProyectoTO que se actualizo o guardo
	 */
	public ProyectoTO guardarOActualizar(ProyectoTO proyecto);
	
	/**
	 * metodo que retorna todos los proyectos de la base de datos
	 * @return retorna un listado de ProyectoTO que estan en base de datos
	 */
	public List<ProyectoTO> buscarTodos();
	
	/**
	 * metodo que retorna todos los proyectos segun un centro de costo
	 * @param centroCosto
	 * @return retorna una lista de ProyectoTO
	 */
	public List<ProyectoTO> buscarPorCentroCosto(CentroCostoTO centroCosto);
	
	/**
	 * metodo que retorna todos los proyectos asignados a un recurso
	 * @param recurso
	 * @return retorna una lista de ProyectoTO
	 */
	public List<ProyectoTO> buscarPorRecurso(RecursoTO recurso);

}

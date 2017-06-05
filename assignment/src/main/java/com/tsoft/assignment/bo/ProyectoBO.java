package com.tsoft.assignment.bo;

import java.util.List;

import com.tsoft.assignment.to.CentroCostoTO;
import com.tsoft.assignment.to.ProyectoTO;
import com.tsoft.assignment.to.RecursoTO;

/**
 * 
 * @author omar.vergara
 * Clase de la capa de negocio encargada de manejar la logica de los proyectos:
 * Guardar o actualizar un proyecto
 * Buscar todos los proyectos
 */
public interface ProyectoBO {
	
	/**
	 * Metodo para guardar o actualizar un Perfil
	 * @param parametros parametros a guardar en la base de datos
	 * @return retorna el ProyectoTO que fue guardado o modificado
	 */
	public ProyectoTO guardarOActualizar(ProyectoTO parametros);
	
	/**
	 * Metodo para buscar todos los proyectos en la base de datos
	 * @return retorna una lista de ProyectoTO
	 */
	public List<ProyectoTO> buscarTodos();
	
	public List<ProyectoTO> buscarPorCentroCosto(CentroCostoTO centroCosto);
	
	public List<ProyectoTO> buscarPorRecurso(RecursoTO recurso);

}

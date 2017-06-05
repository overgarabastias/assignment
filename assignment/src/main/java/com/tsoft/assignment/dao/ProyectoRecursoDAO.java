package com.tsoft.assignment.dao;

import com.tsoft.assignment.to.ProyectoRecursoTO;

public interface ProyectoRecursoDAO {
	
	/**
	 * Metodo para actualizar o guardar la relacion entre recurso y proyecto
	 * @param proyectoRecurso ProyectoRecursoTO que sera el que se guarde o actualice
	 * @return retona el ProyectoRecursoTO que se actualizo o guardo
	 */
	public ProyectoRecursoTO guardarOActualizar(ProyectoRecursoTO proyectoRecurso);
	
	public Boolean borrar(ProyectoRecursoTO proyectoRecurso);
}

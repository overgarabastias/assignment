package com.tsoft.assignment.bo;

import com.tsoft.assignment.to.ProyectoRecursoTO;

public interface ProyectoRecursoBO {
	
	public ProyectoRecursoTO guardarOActualizar(ProyectoRecursoTO proyectoRecurso);
	public Boolean eliminar(ProyectoRecursoTO proyectoRecurso);

}

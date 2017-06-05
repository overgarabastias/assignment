package com.tsoft.assignment.dao.impl;

import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tsoft.assignment.dao.GenericoDAO;
import com.tsoft.assignment.dao.ProyectoRecursoDAO;
import com.tsoft.assignment.to.ProyectoRecursoTO;

@Service
public class ProyectoRecursoDAOImpl implements ProyectoRecursoDAO {

	@Autowired
	private GenericoDAO genericoDao;
	
	private static String queryElminarRegistro = "Delete from ProyectoRecursoTO pr where pr.proyecto.id = ?1 and pr.recurso.id = ?2";
	
	public ProyectoRecursoTO guardarOActualizar(ProyectoRecursoTO proyectoRecurso) {
		return (ProyectoRecursoTO)genericoDao.guardarOActualizar(proyectoRecurso);
	}

	@Transactional
	public Boolean borrar(ProyectoRecursoTO proyectoRecurso) {
		Query query = genericoDao.getQuery(queryElminarRegistro);
		query.setParameter(1, proyectoRecurso.getProyecto().getId());
		query.setParameter(2, proyectoRecurso.getRecurso().getId());
		
		Boolean result;
		
		if(query.executeUpdate() > 0){
			result = true;
		}else{
			result = false;
		}
		
		return result;
	}
	

}

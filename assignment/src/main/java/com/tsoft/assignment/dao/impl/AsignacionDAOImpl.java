package com.tsoft.assignment.dao.impl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Query;
import javax.persistence.TemporalType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.tsoft.assignment.dao.AsignacionDAO;
import com.tsoft.assignment.dao.GenericoDAO;
import com.tsoft.assignment.to.AsignacionFiltroTO;
import com.tsoft.assignment.to.AsignacionTO;
import com.tsoft.assignment.util.CalendarioUtil;

@Repository
public class AsignacionDAOImpl implements AsignacionDAO {
	
	@Autowired
	private GenericoDAO genericoDao;
	
	private CalendarioUtil calendario = new CalendarioUtil();
	
	private static String queryBuscarTodos = "select a from AsignacionTO a";
	private static String queryBuscarXFiltro = "select a from AsignacionTO a where a.recurso.idRecurso = ?1 and (a.fechaInicio BETWEEN ?2 and ?3 or a.fechaFin  BETWEEN ?2 and ?3)";
	public AsignacionTO guardarOActualizar(AsignacionTO asignacion) {
		return (AsignacionTO) genericoDao.guardarOActualizar(asignacion);
	}

	public List<AsignacionTO> buscarTodos() {
		List<Object> resultado = genericoDao.buscar(queryBuscarTodos);
		
		List<AsignacionTO> asignaciones = new ArrayList<AsignacionTO>();
		for (int i = 0; i < resultado.size(); i++) {
			asignaciones.add((AsignacionTO)resultado.get(i));
		}
		return asignaciones;
	}

	@SuppressWarnings("unchecked")
	@Transactional
	public List<AsignacionTO> buscarPorRecursoYFecha(AsignacionFiltroTO parametros) {
		
		if(parametros.getTipo() == 1){
			parametros.setFechaInicio(calendario.PrimerDiaMes(parametros.getAnnio(), parametros.getMes()));
			parametros.setFechaFin(calendario.UltimoDiaMes(parametros.getAnnio(), parametros.getMes()));
		}
		
		Query query = genericoDao.getQuery(queryBuscarXFiltro);
		
		query.setParameter(1, parametros.getRecurso().getId());
		query.setParameter(2, parametros.getFechaInicio(), TemporalType.DATE);
		query.setParameter(3, parametros.getFechaFin(), TemporalType.DATE);
		
		return query.getResultList();
	}

}

package com.tsoft.assignment.controladores;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.tsoft.assignment.bo.AsignacionBO;
import com.tsoft.assignment.to.AsignacionFiltroTO;
import com.tsoft.assignment.to.AsignacionTO;

@RestController
@RequestMapping(value = "/assignment/asignacion")
public class AsignacionControlador {
	
	private static final Logger log = Logger.getLogger(AsignacionControlador.class);
	
	@Autowired
	private AsignacionBO asignacionBo;
	
	@RequestMapping(value = "/guardar", method = RequestMethod.POST, produces="application/json")
	public ResponseEntity<AsignacionTO> guardar(@RequestBody AsignacionTO asignacion,Locale locale, Model model,HttpSession session){
		log.info("Consulta: /asignacion/guardar, " + asignacion.toString());
		try {
			if(asignacion.getProyecto() != null && 
			   asignacion.getRecurso() != null && 
			   asignacion.getLocalizacion() != null && 
			   asignacion.getFechaFin() != null && 
			   asignacion.getFechaInicio() != null &&
			   asignacion.getFacturable() != null &&
			   asignacion.getImputable() != null ){
				
				return new ResponseEntity<AsignacionTO>(asignacionBo.guardarOActualizar(asignacion), HttpStatus.OK);
			}else{
				log.error("/asignacion/guardar: Error por BAD_REQUEST");
				return new ResponseEntity<AsignacionTO>(new AsignacionTO(), HttpStatus.BAD_REQUEST);
			}
		} catch (Exception e) {
			log.error("Error: /asignacion/guardar", e);
			return new ResponseEntity<AsignacionTO>(new AsignacionTO(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}
	
	@RequestMapping(value = "/obtenerTodos", method = RequestMethod.GET)
	public ResponseEntity<List<AsignacionTO>> obtener(Locale locale, Model model,HttpSession session){
		log.info("Consulta: /asignacion/obtenerTodos");
		try {
			return new ResponseEntity<List<AsignacionTO>>(asignacionBo.buscarTodos(), HttpStatus.OK);
		} catch (Exception e) {
			log.error("Error: /asignacion/obtenerTodos", e);
			return new ResponseEntity<List<AsignacionTO>>(new ArrayList<AsignacionTO>(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}
	
	@RequestMapping(value = "/obtenerXFiltroRecursoFecha", method = RequestMethod.POST)
	public ResponseEntity<Boolean> obtenerXFiltroRecursoFecha(@RequestBody AsignacionFiltroTO parametros,Locale locale, Model model,HttpSession session){
		log.info("Consulta: /asignacion/obtenerXFiltroRecursoFecha, " + parametros.toString());	
		try {
			if(parametros.getTipo() != null &&
			   parametros.getRecurso() != null && 
			  ((parametros.getTipo() == 1 && parametros.getAnnio() != null && parametros.getMes() != null) ||
			  (parametros.getTipo() == 2 && parametros.getFechaFin() != null && parametros.getFechaInicio() != null))){
				return new ResponseEntity<Boolean>(asignacionBo.buscarPorRecursoYFecha(parametros), HttpStatus.OK);
			}else{
				log.error("/asignacion/obtenerXFiltroRecursoFecha: Error por BAD_REQUEST");
				return new ResponseEntity<Boolean>(false, HttpStatus.BAD_REQUEST);
			}
		} catch (Exception e) {
			log.error("Error: /asignacion/obtenerXFiltroRecursoFecha", e);
			return new ResponseEntity<Boolean>(false, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}

}

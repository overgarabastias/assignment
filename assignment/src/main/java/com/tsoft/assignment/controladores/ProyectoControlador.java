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

import com.tsoft.assignment.bo.ProyectoBO;
import com.tsoft.assignment.to.CentroCostoTO;
import com.tsoft.assignment.to.ProyectoTO;
import com.tsoft.assignment.to.RecursoTO;

@RestController
@RequestMapping(value = "/assignment/proyecto")
public class ProyectoControlador {
	
	private static final Logger log = Logger.getLogger(ProyectoControlador.class);

	@Autowired
	private ProyectoBO proyectoBo;
	
	@RequestMapping(value = "/guardar", method = RequestMethod.POST, produces="application/json")
	public ResponseEntity<ProyectoTO> guardar(@RequestBody ProyectoTO proyecto,Locale locale, Model model,HttpSession session){
		log.info("Consulta: /proyecto/guardar, " + proyecto.toString());
		try {
			if(proyecto.getNombre() != null && proyecto.getCentroCosto() != null){
				return new ResponseEntity<ProyectoTO>(proyectoBo.guardarOActualizar(proyecto), HttpStatus.OK);
			}else{
				log.error("/proyecto/guardar: Error por BAD_REQUEST");
				return new ResponseEntity<ProyectoTO>(new ProyectoTO(), HttpStatus.BAD_REQUEST);
			}
		} catch (Exception e) {
			log.error("Error: /proyecto/guardar", e);
			return new ResponseEntity<ProyectoTO>(new ProyectoTO(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}
	
	@RequestMapping(value = "/obtenerTodos", method = RequestMethod.GET)
	public ResponseEntity<List<ProyectoTO>> obtener(Locale locale, Model model,HttpSession session){
		log.info("Consulta: /proyecto/guardar");
		try {
			return new ResponseEntity<List<ProyectoTO>>(proyectoBo.buscarTodos(), HttpStatus.OK);
		} catch (Exception e) {
			log.error("Error: /proyecto/guardar", e);
			return new ResponseEntity<List<ProyectoTO>>(new ArrayList<ProyectoTO>(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}
	
	@RequestMapping(value = "/obtenerPorCentroCosto", method = RequestMethod.POST, produces="application/json")
	public ResponseEntity<List<ProyectoTO>> obtenerPorCliente(@RequestBody CentroCostoTO centroCosto,Locale locale, Model model,HttpSession session){
		log.info("Consulta: /proyecto/obtenerPorCentroCosto");
		try {
			if(centroCosto.getNombre() != null && centroCosto.getClass() != null){
				return new ResponseEntity<List<ProyectoTO>>(proyectoBo.buscarPorCentroCosto(centroCosto), HttpStatus.OK);
			}else{
				log.error("/proyecto/obtenerPorCentroCosto: Error por BAD_REQUEST");
				return new ResponseEntity<List<ProyectoTO>>(new ArrayList<ProyectoTO>(), HttpStatus.BAD_REQUEST);
			}
		}catch (Exception e) {
			log.error("Error: /proyecto/obtenerPorCentroCosto", e);
			return new ResponseEntity<List<ProyectoTO>>(new ArrayList<ProyectoTO>(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	
	@RequestMapping(value = "/obtenerPorRecurso", method = RequestMethod.POST, produces="application/json")
	public ResponseEntity<List<ProyectoTO>> obtenerPorRecurso(@RequestBody RecursoTO recurso,Locale locale, Model model,HttpSession session){
		log.info("Consulta: /proyecto/obtenerPorRecurso");
		try {
			if(recurso.getNombre() != null && recurso.getClass() != null){
				return new ResponseEntity<List<ProyectoTO>>(proyectoBo.buscarPorRecurso(recurso), HttpStatus.OK);
			}else{
				log.error("/proyecto/obtenerPorRecurso: Error por BAD_REQUEST");
				return new ResponseEntity<List<ProyectoTO>>(new ArrayList<ProyectoTO>(), HttpStatus.BAD_REQUEST);
			}
		}catch (Exception e) {
			log.error("Error: /proyecto/obtenerPorRecurso", e);
			return new ResponseEntity<List<ProyectoTO>>(new ArrayList<ProyectoTO>(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}

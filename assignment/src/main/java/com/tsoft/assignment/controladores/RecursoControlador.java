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

import com.tsoft.assignment.bo.RecursoBO;
import com.tsoft.assignment.to.ProyectoTO;
import com.tsoft.assignment.to.RecursoTO;

@RestController
@RequestMapping(value = "/assignment/recurso")
public class RecursoControlador {
	
	private static final Logger log = Logger.getLogger(RecursoControlador.class);

	@Autowired
	private RecursoBO recursoBo;
	
	@RequestMapping(value = "/guardar", method = RequestMethod.POST, produces="application/json")
	public ResponseEntity<RecursoTO> guardar(@RequestBody RecursoTO recurso,Locale locale, Model model,HttpSession session){
		log.info("Consulta: /recurso/guardar, " + recurso.toString());
		try {
			if(recurso.getNombre() != null && recurso.getPerfil() != null && recurso.getDinamico() != null){
				return new ResponseEntity<RecursoTO>(recursoBo.guardarOActualizar(recurso), HttpStatus.OK);
			}else{
				log.error("/recurso/guardar: Error por BAD_REQUEST");
				return new ResponseEntity<RecursoTO>(new RecursoTO(), HttpStatus.BAD_REQUEST);
			}
		} catch (Exception e) {
			log.error("Error: /recurso/guardar", e);
			return new ResponseEntity<RecursoTO>(new RecursoTO(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@RequestMapping(value = "/obtenerTodos", method = RequestMethod.GET, produces="application/json")
	public ResponseEntity<List<RecursoTO>> obtener(Locale locale, Model model,HttpSession session){
		log.info("Consulta: /recurso/guardar");
		try {
			return new ResponseEntity<List<RecursoTO>>(recursoBo.buscarTodos(), HttpStatus.OK);
		} catch (Exception e) {
			log.error("Error: /recurso/guardar", e);
			return new ResponseEntity<List<RecursoTO>>(new ArrayList<RecursoTO>(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}
	
	@RequestMapping(value = "/obtenerPorProyecto", method = RequestMethod.POST, produces="application/json")
	public ResponseEntity<List<RecursoTO>> obtenerPorProyecto(@RequestBody ProyectoTO proyecto,Locale locale, Model model,HttpSession session){
		log.info("Consulta: /recurso/obtenerPorProyecto");
		try {
			if(proyecto.getNombre() != null && proyecto.getClass() != null){
				return new ResponseEntity<List<RecursoTO>>(recursoBo.buscarPorProyecto(proyecto), HttpStatus.OK);
			}else{
				log.error("/recurso/obtenerPorProyecto: Error por BAD_REQUEST");
				return new ResponseEntity<List<RecursoTO>>(new ArrayList<RecursoTO>(), HttpStatus.BAD_REQUEST);
			}
		}catch (Exception e) {
			log.error("Error: /recurso/obtenerPorProyecto", e);
			return new ResponseEntity<List<RecursoTO>>(new ArrayList<RecursoTO>(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
}

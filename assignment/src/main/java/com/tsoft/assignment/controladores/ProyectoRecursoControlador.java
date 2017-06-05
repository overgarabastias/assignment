package com.tsoft.assignment.controladores;

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

import com.tsoft.assignment.bo.ProyectoRecursoBO;
import com.tsoft.assignment.to.ProyectoRecursoTO;

@RestController
@RequestMapping(value = "/assignment/proyectoRecurso")
public class ProyectoRecursoControlador {

	private static final Logger log = Logger.getLogger(ProyectoRecursoControlador.class);
	
	@Autowired
	private ProyectoRecursoBO proyectoRecursoBo;
	
	@RequestMapping(value = "/guardar", method = RequestMethod.POST, produces="application/json")
	public ResponseEntity<ProyectoRecursoTO> guardar(@RequestBody ProyectoRecursoTO proyectoRecurso,Locale locale, Model model,HttpSession session){
		log.info("Consulta: /proyectoRecurso/guardar, " + proyectoRecurso.toString());
		try {
			if(proyectoRecurso.getProyecto() != null && proyectoRecurso.getRecurso() != null){
				return new ResponseEntity<ProyectoRecursoTO>(proyectoRecursoBo.guardarOActualizar(proyectoRecurso), HttpStatus.OK);
			}else{
				log.error("/proyectoRecurso/guardar: Error por BAD_REQUEST");
				return new ResponseEntity<ProyectoRecursoTO>(new ProyectoRecursoTO(), HttpStatus.BAD_REQUEST);
			}
		}catch (Exception e) {
			log.error("Error: /proyectoRecurso/guardar", e);
			return new ResponseEntity<ProyectoRecursoTO>(new ProyectoRecursoTO(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	
	@RequestMapping(value = "/eliminar", method = RequestMethod.POST, produces="application/json")
	public ResponseEntity<Boolean> eliminar(@RequestBody ProyectoRecursoTO proyectoRecurso,Locale locale, Model model,HttpSession session){
		log.info("Consulta: /proyectoRecurso/eliminar, " + proyectoRecurso.toString());
		try {
			if(proyectoRecurso.getProyecto() != null && proyectoRecurso.getRecurso() != null){
				return new ResponseEntity<Boolean>(proyectoRecursoBo.eliminar(proyectoRecurso), HttpStatus.OK);
			}else{
				log.error("/proyectoRecurso/eliminar: Error por BAD_REQUEST");
				return new ResponseEntity<Boolean>(false, HttpStatus.BAD_REQUEST);
			}
		}catch (Exception e) {
			log.error("Error: /proyectoRecurso/eliminar", e);
			return new ResponseEntity<Boolean>(false, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
}

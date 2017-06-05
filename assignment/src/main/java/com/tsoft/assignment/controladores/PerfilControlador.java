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

import com.tsoft.assignment.bo.PerfilBO;
import com.tsoft.assignment.to.PerfilTO;

@RestController
@RequestMapping(value = "/assignment/perfil")
public class PerfilControlador {
	
	private static final Logger log = Logger.getLogger(PerfilControlador.class);
	
	@Autowired
	private PerfilBO perfilBo;
	
	@RequestMapping(value = "/guardar", method = RequestMethod.POST, produces="application/json")
	public ResponseEntity<PerfilTO> guardar(@RequestBody PerfilTO perfil,Locale locale, Model model,HttpSession session){
		log.info("Consulta: /perfil/guardar, " + perfil.toString());
		try {
			if(perfil.getNombre() != null){
				return new ResponseEntity<PerfilTO>(perfilBo.guardarOActualizar(perfil), HttpStatus.OK);
			}else{
				log.error("/perfil/guardar: Error por BAD_REQUEST");
				return new ResponseEntity<PerfilTO>(new PerfilTO(), HttpStatus.BAD_REQUEST);
			}
		} catch (Exception e) {
			log.error("Error: /perfil/guardar", e);
			return new ResponseEntity<PerfilTO>(new PerfilTO(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}
	
	@RequestMapping(value = "/obtenerTodos", method = RequestMethod.GET)
	public ResponseEntity<List<PerfilTO>> obtener(Locale locale, Model model,HttpSession session){
		log.info("Consulta: /perfil/obtenerTodos");
		try {
			return new ResponseEntity<List<PerfilTO>>(perfilBo.buscarTodos(), HttpStatus.OK);
		} catch (Exception e) {
			log.error("Error: /perfil/obtenerTodos", e);
			return new ResponseEntity<List<PerfilTO>>(new ArrayList<PerfilTO>(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}

}

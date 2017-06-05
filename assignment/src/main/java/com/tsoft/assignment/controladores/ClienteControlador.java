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

import com.tsoft.assignment.bo.ClienteBO;
import com.tsoft.assignment.to.ClienteTO;

@RestController
@RequestMapping(value = "/assignment/cliente")
public class ClienteControlador {
	
	private static final Logger log = Logger.getLogger(ClienteControlador.class);
	
	@Autowired
	private ClienteBO clienteBo;
	
	@RequestMapping(value = "/guardar", method = RequestMethod.POST, produces="application/json")
	public ResponseEntity<ClienteTO> guardar(@RequestBody ClienteTO cliente,Locale locale, Model model,HttpSession session){
		log.info("Consulta: /cliente/guardar, " + cliente.toString());
		try {
			if(cliente.getNombre() != null){
				return new ResponseEntity<ClienteTO>(clienteBo.guardarOActualizar(cliente), HttpStatus.OK);
			}else{
				log.error("/cliente/guardar: Error por BAD_REQUEST");
				return new ResponseEntity<ClienteTO>(new ClienteTO(), HttpStatus.BAD_REQUEST);
			}
		} catch (Exception e) {
			log.error("Error: /cliente/guardar", e);
			return new ResponseEntity<ClienteTO>(new ClienteTO(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}
	
	@RequestMapping(value = "/obtenerTodos", method = RequestMethod.GET)
	public ResponseEntity<List<ClienteTO>> obtener(Locale locale, Model model,HttpSession session){
		log.info("Consulta: /cliente/obtenerTodos");
		try {
			return new ResponseEntity<List<ClienteTO>>(clienteBo.buscarTodos(), HttpStatus.OK);
		} catch (Exception e) {
			log.error("Error: /cliente/obtenerTodos", e);
			return new ResponseEntity<List<ClienteTO>>(new ArrayList<ClienteTO>(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}

}

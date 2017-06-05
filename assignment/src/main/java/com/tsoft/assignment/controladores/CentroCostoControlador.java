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

import com.tsoft.assignment.bo.CentroCostoBO;
import com.tsoft.assignment.to.CentroCostoTO;
import com.tsoft.assignment.to.ClienteTO;

@RestController
@RequestMapping(value = "/assignment/centroCosto")
public class CentroCostoControlador {
	
	private static final Logger log = Logger.getLogger(CentroCostoControlador.class);
	
	@Autowired
	private CentroCostoBO centroCostoBo;
	
	@RequestMapping(value = "/guardar", method = RequestMethod.POST, produces="application/json")
	public ResponseEntity<CentroCostoTO> guardar(@RequestBody CentroCostoTO centroCosto,Locale locale, Model model,HttpSession session){
		log.info("Consulta: /centroCosto/guardar, " + centroCosto.toString());
		try {
			if(centroCosto.getNombre() != null && centroCosto.getCliente() != null){
				return new ResponseEntity<CentroCostoTO>(centroCostoBo.guardarOActualizar(centroCosto), HttpStatus.OK);
			}else{
				log.error("/centroCosto/guardar: Error por BAD_REQUEST");
				return new ResponseEntity<CentroCostoTO>(new CentroCostoTO(), HttpStatus.BAD_REQUEST);
			}
		}catch (Exception e) {
			log.error("Error: /centroCosto/guardar", e);
			return new ResponseEntity<CentroCostoTO>(new CentroCostoTO(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@RequestMapping(value = "/obtenerTodos", method = RequestMethod.GET)
	public ResponseEntity<List<CentroCostoTO>> obtener(Locale locale, Model model,HttpSession session){
		log.info("Consulta: /centroCosto/obtenerTodos");
		try {
			return new ResponseEntity<List<CentroCostoTO>>(centroCostoBo.buscarTodos(), HttpStatus.OK);
		} catch (Exception e) {
			log.error("Error: /centroCosto/obtenerTodos", e);
			return new ResponseEntity<List<CentroCostoTO>>(new ArrayList<CentroCostoTO>(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@RequestMapping(value = "/obtenerPorCliente", method = RequestMethod.POST, produces="application/json")
	public ResponseEntity<List<CentroCostoTO>> obtenerPorCliente(@RequestBody ClienteTO cliente,Locale locale, Model model,HttpSession session){
		log.info("Consulta: /centroCosto/obtenerPorCliente");
		try {
			if(cliente.getNombre() != null && cliente.getClass() != null){
				return new ResponseEntity<List<CentroCostoTO>>(centroCostoBo.buscarPorCliente(cliente), HttpStatus.OK);
			}else{
				log.error("/centroCosto/obtenerPorCliente: Error por BAD_REQUEST");
				return new ResponseEntity<List<CentroCostoTO>>(new ArrayList<CentroCostoTO>(), HttpStatus.BAD_REQUEST);
			}
		}catch (Exception e) {
			log.error("Error: /centroCosto/obtenerPorCliente", e);
			return new ResponseEntity<List<CentroCostoTO>>(new ArrayList<CentroCostoTO>(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}

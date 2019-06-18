package com.example.controllers;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.models.Amenidad;
import com.example.models.Entretenimiento;
import com.example.services.AmenidadService;
import com.example.services.EntretenimientoService;

@RestController
public class EntretenimientoController {
private static final Logger logger = LoggerFactory.getLogger(EntretenimientoController.class);
	
	@Autowired
	private EntretenimientoService entretenimientoService;
	
	@Autowired
	private AmenidadService amenidadesService;
	
	@GetMapping("/entretenimientos")
	public List<Entretenimiento> entretenimientos(){
		logger.info("call entretenimientos()");
		
		List<Entretenimiento> entretenimientos = entretenimientoService.listar();
		logger.info("entretenimientos: " + entretenimientos);
		
		return entretenimientos;
	}
	
	@GetMapping("/entretenimientos/{entretenimientos_id}/amenidades")
	public List<Amenidad> amenidades(@PathVariable Integer entretenimientos_id){
		logger.info("call amenidades(" + entretenimientos_id + ")");
		
		List<Amenidad> amenidades = amenidadesService.listar(entretenimientos_id);
		logger.info("amenidades: " + amenidades);
		
		return amenidades;
	}

}

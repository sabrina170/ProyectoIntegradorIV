package com.example.controllers;

import java.nio.file.Files;
import java.nio.file.Paths;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.models.Amenidad;
import com.example.services.AmenidadService;


@RestController
public class AmenidadController {
private static final Logger logger = LoggerFactory.getLogger(AmenidadController.class);
	
	private static final String FILEPATH = "/api/images";
	
	@Autowired
	private AmenidadService amenidadService;
	
	@GetMapping("/amenidades/{id}")
	public Amenidad amenidad(@PathVariable Integer id){
		logger.info("call amenidad(" + id + ")");
		
		Amenidad amenidad = amenidadService.obtener(id);
		logger.info("amenidad: " + amenidad);
		
		return amenidad;
	}
	
	@GetMapping("/amenidades/images/{filename:.+}")
	public ResponseEntity<Resource> file(@PathVariable String filename) throws Exception{
		logger.info("call file() " + filename);
		
		Resource resource = new UrlResource(Paths.get(FILEPATH).resolve(filename).toUri());
		logger.info("resource: " + resource);
		
		return ResponseEntity.ok()
				.header(HttpHeaders.CONTENT_DISPOSITION, "inline; filename=\""+resource.getFilename()+"\"")
				.header(HttpHeaders.CONTENT_TYPE, Files.probeContentType(Paths.get(FILEPATH).resolve(filename)))
				.header(HttpHeaders.CONTENT_LENGTH, String.valueOf(resource.contentLength()))
				.body(resource);
	}
}

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

import com.example.models.Tema;
import com.example.services.TemaService;



@RestController
public class TemaController {
private static final Logger logger = LoggerFactory.getLogger(TemaController.class);
	
	private static final String FILEPATH = "/api/images";
	
	@Autowired
	private TemaService temaService;
	
	@GetMapping("/temas/{id}")
	public Tema tema(@PathVariable Integer id){
		logger.info("call tema(" + id + ")");
		
		Tema tema = temaService.obtener(id);
		logger.info("tema: " + tema);
		
		return tema;
	}
	
	@GetMapping("/temas/images/{filename:.+}")
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

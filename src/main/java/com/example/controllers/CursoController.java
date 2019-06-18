package com.example.controllers;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.models.Curso;
import com.example.models.Tema;
import com.example.services.CursoService;
import com.example.services.TemaService;


@RestController
public class CursoController {
private static final Logger logger = LoggerFactory.getLogger(CursoController.class);
	
	@Autowired
	private CursoService cursoService;
	
	@Autowired
	private TemaService temaService;
	
	@GetMapping("/cursos")
	public List<Curso> cursos(){
		logger.info("call cursos()");
		
		List<Curso> cursos = cursoService.listar();
		logger.info("cursos: " + cursos);
		
		return cursos;
	}
	
	@GetMapping("/cursos/{cursos_id}/temas")
	public List<Tema> temas(@PathVariable Integer cursos_id){
		logger.info("call temas(" + cursos_id + ")");
		
		List<Tema> temas = temaService.listar(cursos_id);
		logger.info("temas: " + temas);
		
		return temas;
	}

}

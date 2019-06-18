package com.example.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.models.Curso;
import com.example.repository.CursoRepository;



@Service
public class CursoService {


	@Autowired
	private CursoRepository cursoRepository;
	
	public List<Curso> listar() {
		return cursoRepository.listar();
	}


}

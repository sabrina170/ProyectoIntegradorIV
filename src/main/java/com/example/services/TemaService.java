package com.example.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.models.Tema;
import com.example.repository.TemaRepository;


@Service
public class TemaService {
	@Autowired
	private TemaRepository temaRepository;
	
	public List<Tema> listar(Integer cursos_id) {
		return temaRepository.listar(cursos_id);
	}
	
	public Tema obtener(Integer id) {
		return temaRepository.obtener(id);
	}
}

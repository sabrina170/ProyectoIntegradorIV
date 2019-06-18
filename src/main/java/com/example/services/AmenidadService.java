package com.example.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.models.Amenidad;
import com.example.repository.AmenidadRepository;


@Service
public class AmenidadService {
	@Autowired
	private AmenidadRepository amenidadRepository;
	
	public List<Amenidad> listar(Integer entretenimientos_id) {
		return amenidadRepository.listar(entretenimientos_id);
	}
	
	public Amenidad obtener(Integer id) {
		return amenidadRepository.obtener(id);
	}
}

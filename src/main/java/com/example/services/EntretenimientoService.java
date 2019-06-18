package com.example.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.models.Entretenimiento;

import com.example.repository.EntretenimientoRepository;

@Service
public class EntretenimientoService {
	
	@Autowired
	private EntretenimientoRepository entretenimientoRepository;
	
	public List<Entretenimiento> listar() {
		return  entretenimientoRepository.listar();
	}
}

package com.example.models;



public class Tema {
	private Integer id;
	
	private Curso curso;
	
	private String nombre;
	
	private String imagen;
	
	private String ejercicio;
	
	private String respuesta;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Curso getCurso() {
		return curso;
	}

	public void setCurso(Curso curso) {
		this.curso = curso;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getImagen() {
		return imagen;
	}

	public void setImagen(String imagen) {
		this.imagen = imagen;
	}

	public String getEjercicio() {
		return ejercicio;
	}

	public void setEjercicio(String ejercicio) {
		this.ejercicio = ejercicio;
	}

	public String getRespuesta() {
		return respuesta;
	}

	public void setRespuesta(String respuesta) {
		this.respuesta = respuesta;
	}

	@Override
	public String toString() {
		return "Tema [id=" + id + ", curso=" + curso + ", nombre=" + nombre + ", imagen=" + imagen + ", ejercicio="
				+ ejercicio + ", respuesta=" + respuesta + "]";
	}
	
	
}

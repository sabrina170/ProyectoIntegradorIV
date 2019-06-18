package com.example.models;

public class Amenidad {

    private Integer id;
	
	private Entretenimiento entretenimiento;
	
	private String nombre;
	
	private String imagen;
	
	private String contenido;
	
	private String respuesta;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Entretenimiento getEntretenimiento() {
		return entretenimiento;
	}

	public void setEntretenimiento(Entretenimiento entretenimiento) {
		this.entretenimiento = entretenimiento;
	}


	public String getImagen() {
		return imagen;
	}

	public void setImagen(String imagen) {
		this.imagen = imagen;
	}

	public String getContenido() {
		return contenido;
	}

	public void setContenido(String contenido) {
		this.contenido = contenido;
	}

	public String getRespuesta() {
		return respuesta;
	}

	public void setRespuesta(String respuesta) {
		this.respuesta = respuesta;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@Override
	public String toString() {
		return "Amenidad [id=" + id + ", entretenimiento=" + entretenimiento + ", nombre=" + nombre + ", imagen="
				+ imagen + ", contenido=" + contenido + ", respuesta=" + respuesta + "]";
	}

	
	
	


}

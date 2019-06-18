package com.example.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.example.models.Amenidad;

import com.example.models.Entretenimiento;

@Repository
public class AmenidadRepository {

private static final Logger logger = LoggerFactory.getLogger(AmenidadRepository.class);
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public List<Amenidad> listar(Integer entretenimientos_id) {
		logger.info("call listar(" + entretenimientos_id + ")");
		
		String sql = "SELECT a.id, a.entretenimientos_id, a.nombre as entretenimientos_nombre, a.nombre, a.imagen, a.contenido, a.respuesta " + 
				"FROM amenidades a " + 
				"INNER JOIN entretenimientos e ON e.id=a.entretenimientos_id " + 
				"WHERE a.entretenimientos_id = ? " +
				"ORDER BY a.nombre";
		
		List<Amenidad> amenidades = jdbcTemplate.query(sql, new RowMapper<Amenidad>() {
			@Override
			public Amenidad mapRow(ResultSet rs, int rowNum) throws SQLException {
				Amenidad amenidad = new Amenidad();
				amenidad.setId(rs.getInt("id"));
				
				Entretenimiento entretenimiento = new Entretenimiento();
				entretenimiento.setId(rs.getInt("entretenimientos_id"));
				entretenimiento.setNombre(rs.getString("entretenimientos_nombre"));
				amenidad.setEntretenimiento(entretenimiento);
				
				amenidad.setNombre(rs.getString("nombre"));
				amenidad.setImagen(rs.getString("imagen"));
				amenidad.setContenido(rs.getString("contenido"));
				amenidad.setRespuesta(rs.getString("respuesta"));

				return amenidad;
			}
		}, entretenimientos_id);
		
		logger.info("amenidades: " + amenidades);
		
		return amenidades;
	}
	
	public Amenidad obtener(Integer id) {
		logger.info("call obtener(" + id + ")");
		
		String sql = "SELECT a.id,a.entretenimientos_id, e.nombre as entretenimientos_nombre, a.nombre, a.imagen, a.contenido, a.respuesta " + 
				"FROM amenidades a " + 
				"INNER JOIN entretenimientos e ON e.id=a.entretenimientos_id " + 
				"WHERE a.id = ? ";
		
		Amenidad amenidad = jdbcTemplate.queryForObject(sql, new RowMapper<Amenidad>() {
			@Override
			public Amenidad mapRow(ResultSet rs, int rowNum) throws SQLException {
				Amenidad amenidad = new Amenidad();
				amenidad.setId(rs.getInt("id"));
				
				Entretenimiento entre = new Entretenimiento();
				entre.setId(rs.getInt("entretenimientos_id"));
				entre.setNombre(rs.getString("entretenimientos_nombre"));
				amenidad.setEntretenimiento(entre);
				
				amenidad.setNombre(rs.getString("nombre"));
				amenidad.setImagen(rs.getString("imagen"));
				amenidad.setContenido(rs.getString("contenido"));
				amenidad.setRespuesta(rs.getString("respuesta"));

				return amenidad;
			}
		}, id);
		
		logger.info("amenidad: " + amenidad);
		
		return amenidad;
	}
}

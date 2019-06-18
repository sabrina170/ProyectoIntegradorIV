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

import com.example.models.Curso;
import com.example.models.Tema;


@Repository
public class TemaRepository {
private static final Logger logger = LoggerFactory.getLogger(TemaRepository.class);
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public List<Tema> listar(Integer cursos_id) {
		logger.info("call listar(" + cursos_id + ")");
		
		String sql = "SELECT t.id, t.cursos_id, c.nombre as cursos_nombre, t.nombre, t.imagen, t.ejercicio, t.respuesta " + 
				"FROM temas t " + 
				"INNER JOIN cursos c ON c.id=t.cursos_id " + 
				"WHERE t.cursos_id = ? " +
				"ORDER BY t.nombre";
		
		List<Tema> temas = jdbcTemplate.query(sql, new RowMapper<Tema>() {
			@Override
			public Tema mapRow(ResultSet rs, int rowNum) throws SQLException {
				Tema tema = new Tema();
				tema.setId(rs.getInt("id"));
				
				Curso curso = new Curso();
				curso.setId(rs.getInt("cursos_id"));
				curso.setNombre(rs.getString("cursos_nombre"));
				tema.setCurso(curso);
				
				tema.setNombre(rs.getString("nombre"));
				tema.setImagen(rs.getString("imagen"));
				tema.setEjercicio(rs.getString("ejercicio"));
				tema.setRespuesta(rs.getString("respuesta"));

				return tema;
			}
		}, cursos_id);
		
		logger.info("temas: " + temas);
		
		return temas;
	}
	
	public Tema obtener(Integer id) {
		logger.info("call obtener(" + id + ")");
		
		String sql = "SELECT t.id, t.cursos_id, c.nombre as cursos_nombre, t.nombre, t.imagen, t.ejercicio, t.respuesta " + 
				"FROM temas t " + 
				"INNER JOIN cursos c ON c.id=t.cursos_id " + 
				"WHERE t.id = ? ";
		
		Tema tema = jdbcTemplate.queryForObject(sql, new RowMapper<Tema>() {
			@Override
			public Tema mapRow(ResultSet rs, int rowNum) throws SQLException {
				Tema tema = new Tema();
				tema.setId(rs.getInt("id"));
				
				Curso curso = new Curso();
				curso.setId(rs.getInt("cursos_id"));
				curso.setNombre(rs.getString("cursos_nombre"));
				tema.setCurso(curso);
				
				tema.setNombre(rs.getString("nombre"));
				tema.setImagen(rs.getString("imagen"));
				tema.setEjercicio(rs.getString("ejercicio"));
				tema.setRespuesta(rs.getString("respuesta"));

				return tema;
			}
		}, id);
		
		logger.info("tema: " + tema);
		
		return tema;
	}
}

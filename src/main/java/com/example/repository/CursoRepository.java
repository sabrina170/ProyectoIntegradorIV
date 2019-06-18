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


@Repository
public class CursoRepository {

private static final Logger logger = LoggerFactory.getLogger(CursoRepository.class);
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public List<Curso> listar() {
		logger.info("call listar()");
		
		String sql = "select * from cursos";
		
		List<Curso> cursos = jdbcTemplate.query(sql, new RowMapper<Curso>() {
			@Override
			public Curso mapRow(ResultSet rs, int rowNum) throws SQLException {
				Curso curso = new Curso();
				curso.setId(rs.getInt("id"));
				curso.setNombre(rs.getString("nombre"));

				return curso;
			}
		});
		
		logger.info("cursos: " + cursos);
		
		return cursos;
	}

	


}

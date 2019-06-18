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

import com.example.models.Entretenimiento;

@Repository
public class EntretenimientoRepository {

private static final Logger logger = LoggerFactory.getLogger(EntretenimientoRepository.class);
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public List<Entretenimiento> listar() {
		logger.info("call listar()");
		
		String sql = "select * from entretenimientos";
		
		List<Entretenimiento> entretenimientos = jdbcTemplate.query(sql, new RowMapper<Entretenimiento>() {
			@Override
			public Entretenimiento mapRow(ResultSet rs, int rowNum) throws SQLException {
				Entretenimiento entretenimiento = new Entretenimiento();
				entretenimiento.setId(rs.getInt("id"));
				entretenimiento.setNombre(rs.getString("nombre"));

				return entretenimiento;
			}
		});
		
		logger.info("entretenimientos: " + entretenimientos);
		
		return entretenimientos;
	}
}

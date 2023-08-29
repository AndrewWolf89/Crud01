package com.api.crud.beans;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.stereotype.Component;

import com.api.crud.models.Conexion;
import com.api.crud.models.UserModel;

@Component
public class CreandoConexion {
	@Bean(name = "beanUsuario")
	public UserModel getUsuario() {
		return new UserModel();
	}
	
	@Bean(name="beanConexion")
	public Conexion getConexion() {
		Conexion conexion = new Conexion();
		conexion.setDb("MSSMS");
		conexion.setUrl("localhost");
		return conexion;
	}
	
	@Bean
	public DataSource getDataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql://localhost:3306/blog");
		dataSource.setUsername("sa");
		dataSource.setPassword("none");
		return dataSource;
	}

}

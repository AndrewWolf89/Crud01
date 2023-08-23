package com.api.crud.beans;

import org.springframework.context.annotation.Bean;
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
	
	@Bean(name="beanConexionDos")
	public Conexion getConexionDos() {
		Conexion conexion = new Conexion();
		conexion.setDb("MSSMS");
		conexion.setUrl("localhost");
		return conexion;
	}

}

package com.api.crud.models;

import java.util.Date;

public class UserPost {
	private int id;
	private String Descripcion;
	private String urlImg = "http://localhost/img/post.png";
	private Date Fecha = new Date();
	private String Titulo;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDescripcion() {
		return Descripcion;
	}
	public void setDescripcion(String descripcion) {
		Descripcion = descripcion;
	}
	public String getUrlImg() {
		return urlImg;
	}
	public void setUrlImg(String urlImg) {
		this.urlImg = urlImg;
	}
	public Date getFecha() {
		return Fecha;
	}
	public void setFecha(Date fecha) {
		Fecha = fecha;
	}
	public String getTitulo() {
		return Titulo;
	}
	public void setTitulo(String titulo) {
		Titulo = titulo;
	}
	
	public UserPost(int id, String descripcion, String urlImg, Date fecha, String titulo) {
		super();
		this.id = id;
		Descripcion = descripcion;
		this.urlImg = urlImg;
		Fecha = fecha;
		Titulo = titulo;
	}
	
	public UserPost() {
		
	}
	
	

}

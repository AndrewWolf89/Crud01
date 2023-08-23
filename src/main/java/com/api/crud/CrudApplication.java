package com.api.crud;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.api.crud.components.PostComponent;
import com.api.crud.models.Conexion;
import com.api.crud.services.impl.PostServiceImpl;

@SpringBootApplication
public class CrudApplication implements CommandLineRunner {
	@Autowired
	@Qualifier("beanConexion")
	private Conexion conexion;
	
	@Autowired
	@Qualifier("com.api.crud.components.PostComponent")
	public PostComponent postComponent;
	
	@Autowired
	public PostServiceImpl postService;
	
	public static void main(String[] args) {
		SpringApplication.run(CrudApplication.class, args);
	}
	
	@Override
	public void run(String... args) throws Exception {
		postService.validationId(postComponent.getPosts())
			.forEach((post) -> {
				System.out.println(post.getTitulo());
			});
	}

}

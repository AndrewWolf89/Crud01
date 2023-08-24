package com.api.crud;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.JdbcTemplate;

@SpringBootApplication
public class CrudApplication implements CommandLineRunner {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Value("${crud.jdbc.import.ruta}")
	private String ruta;
	
	@Value("${crud.jdbc.import}")
	private String importar;
	
	public CrudApplication() {
		
	}
	
	Log log = LogFactory.getLog(getClass());
	
	public static void main(String[] args) {
		SpringApplication.run(CrudApplication.class, args);
	}
	
	@Override
	public void run(String... args) throws Exception {
		
		if(importar.equalsIgnoreCase("true")) {
			Path path = Paths.get(ruta);
			
			
			try(BufferedReader bufferedReader = Files.newBufferedReader(path, Charset.forName("UTF-8"))) {
				String line;
				while((line = bufferedReader.readLine()) != null) {
					jdbcTemplate.execute(line);
				}
			} catch (IOException ex) {
				
			}
		}
		log.info("Tenemos esta cantidad de permisos: " + jdbcTemplate.queryForObject("SELECT count(*) FROM permiso;", Integer.class));
	}
}

package com.api.crud.components;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Component;

import com.api.crud.models.UserPost;

@Component("com.api.crud.components.PostComponent")
public class PostComponent {
	
	public List<UserPost>getPosts(){
		ArrayList<UserPost> post = new ArrayList<>();
		
		post.add(new UserPost(1,"Ejemplo de la desc Number 1", "http://localhost:8001/img/post.png", new Date(), "Ejemplo del Titulo"));
		post.add(new UserPost(2,"Ejemplo de la desc Number 2", "http://localhost:8001/img/post.png", new Date(), "Ejemplo del Titulo"));
		post.add(new UserPost(3,"Ejemplo de la desc Number 3", "http://localhost:8001/img/post.png", new Date(), "Ejemplo del Titulo"));
		post.add(new UserPost(4,"Ejemplo de la desc Number 4", "http://localhost:8001/img/post.png", new Date(), "Ejemplo del Titulo"));
		return post;
	}
}

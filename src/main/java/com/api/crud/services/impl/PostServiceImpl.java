package com.api.crud.services.impl;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Service;

import com.api.crud.models.UserPost;
import com.api.crud.services.PostService;

@Service
public class PostServiceImpl implements PostService {
	private final Log log = LogFactory.getLog(getClass());
	
	@Override
	public List<UserPost> validation(List<UserPost> posts) throws NullPointerException {
		log.info("Servicio 1");
		for(UserPost post : posts) {
			if(post.getTitulo()==null) {
				throw new NullPointerException("El titulo esta nulo");
			}
		}
		
		return posts;
	}
	
	@Override
	public void addClass(Class clazz) {
		System.out.println(clazz.getName());
	}
	

}

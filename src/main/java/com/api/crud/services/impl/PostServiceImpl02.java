package com.api.crud.services.impl;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Service;

import com.api.crud.models.UserPost;
import com.api.crud.services.PostService;

@Service("serviceDos")
public class PostServiceImpl02 implements PostService {
	private final Log log = LogFactory.getLog(getClass());
	
	@Override
	public List<UserPost> validation(List<UserPost> posts) throws NullPointerException {
		log.info("Servicio 2");
		for (UserPost post : posts) {
			if(post.getId() == 0) {
				throw new NullPointerException("El Id esta nulo");
			}
		}
		
		return posts;
	}
	
	@Override
	public void addClass(Class clazz) {
		System.out.println(clazz.getName());
	}
}

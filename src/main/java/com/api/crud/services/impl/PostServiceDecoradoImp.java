package com.api.crud.services.impl;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.api.crud.models.UserPost;
import com.api.crud.services.PostService;

@Service("serviceDecorado")
@Scope("singleton")
public class PostServiceDecoradoImp implements PostService {
	private final Log log = LogFactory.getLog(getClass());
	
	@Autowired
	private PostServiceImpl postServiceImpl;
	
	@Autowired
	private PostServiceImpl02 postServiceImplDos;

	@Override
	public List<UserPost> validation(List<UserPost> posts) throws NullPointerException {
		log.debug(posts);
		posts = postServiceImpl.validation(posts);
		posts = postServiceImplDos.validation(posts);
		for(UserPost post : posts) {
			if(post.getDescripcion()==null) {
				throw new NullPointerException("La Descripcion esta nulo");
			}
			if(post.getFecha()==null) {
				throw new NullPointerException("La Fecha esta nulo");
			}
		}
		return posts;
	}

	@Override
	public void addClass(Class clazz) {
		System.out.println(clazz.getName());
	}

}

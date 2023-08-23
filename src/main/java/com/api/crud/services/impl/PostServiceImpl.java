package com.api.crud.services.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.api.crud.models.UserPost;
import com.api.crud.services.PostService;

@Service
public class PostServiceImpl implements PostService {
	
	@Override
	public List<UserPost> validationId(List<UserPost> posts) {
		for(UserPost post : posts) {
			if(post.getTitulo()==null) {
				throw new NullPointerException("El titulo esta nulo");
			}
		}
		
		return posts;
	}
	

}

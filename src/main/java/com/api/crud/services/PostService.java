package com.api.crud.services;

import java.util.List;

import com.api.crud.models.UserPost;

public interface PostService {
	public List<UserPost> validation(List<UserPost> posts) throws NullPointerException;
	public void addClass(Class clazz);

}

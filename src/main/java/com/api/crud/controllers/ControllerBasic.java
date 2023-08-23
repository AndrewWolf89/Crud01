package com.api.crud.controllers;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.api.crud.components.PostComponent;
import com.api.crud.configuration.Pages;
import com.api.crud.models.UserPost;

@Controller
@RequestMapping("/")
public class ControllerBasic {
	
	@Autowired
	private PostComponent _postComponent;
	
	@GetMapping(path = {"/","/"})
	public String saludar(Model model) {
		model.addAttribute("posts", this._postComponent.getPosts());
		return "index";
	}
	@GetMapping(path = {"/post","/post/p/{post}"})
	public ModelAndView getPostIndividual(
			@PathVariable(required = true, name = "post") int id
			) {
		ModelAndView modelAndView = new ModelAndView(Pages.POST);
		
		List<UserPost> postFiltrado = this._postComponent.getPosts()
								.stream()
								.filter( (p) -> {
									return p.getId() == id;
								}).collect(Collectors.toList());
		
		modelAndView.addObject("post", postFiltrado.get(0));
		return modelAndView;
	}
	
	@GetMapping("/postNew")
	public ModelAndView getForm() {
		return new ModelAndView("form").addObject("post", new UserPost());
	}
	
	@PostMapping("/addNewPost")
	public String addNewPost(UserPost post, Model model) {
		List<UserPost> posts = this._postComponent.getPosts();
		posts.add(post);
		model.addAttribute("posts",posts);
		return "index";
	}

}

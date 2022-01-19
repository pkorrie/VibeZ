package com.revature.controllers;

import java.io.IOException;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.revature.models.Post;
import com.revature.services.PostService;

@RestController
@RequestMapping("/posts")
@CrossOrigin("*")
public class PostController {

	private PostService ps;
	 
	@Autowired public PostController(PostService ps) { 
		this.ps = ps; 
	} 
	//Allows for creation of a Reply
	@PostMapping
	public ResponseEntity<Post> create(@Valid @RequestBody Post p, @RequestParam(name = "username") String username) {
		return new ResponseEntity<>(ps.createPost(p, username), HttpStatus.CREATED);
	}

	//Allows for creation of a Post
	@PostMapping("/new")
	public ResponseEntity<Post> post(
			@RequestPart(value = "file", required = false) MultipartFile file,
			@RequestPart(value = "username", required = true) String username,
			@RequestPart(value = "title", required = true) String title,
			@RequestPart(value = "content", required = true) String content) throws IOException {
		Post p = new Post();
		p.setTitle(title);
		p.setContent(content);
		return new ResponseEntity<>(ps.createPostWithFile(p, username, file), HttpStatus.CREATED);
	}

	@GetMapping
	public List<Post> get() throws IOException {
		return ps.getTopLevelPosts();
	}
}
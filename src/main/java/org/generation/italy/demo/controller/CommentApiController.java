package org.generation.italy.demo.controller;

import java.util.List;

import org.generation.italy.demo.pojo.Comment;
import org.generation.italy.demo.pojo.Photo;
import org.generation.italy.demo.srv.CommentServ;
import org.generation.italy.demo.srv.PhotoServ;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/comments")
@CrossOrigin("*")
public class CommentApiController {
	
	@Autowired
	private PhotoServ photoServ;
	
	@Autowired
	private CommentServ commentServ;
	
	@GetMapping("/by/photo/{id}")
	public List<Comment> getCommentsByPhotoId(
			@PathVariable("id") int id) {
		
		return photoServ.getPhotoById(id).get().getCommentList();
	}
	
	@PostMapping("/add-comment/{id}")
	public Comment addCommentToPhoto(
			@PathVariable("id") int id, 
			@Valid @RequestBody Comment comment) {
		
		System.err.println(comment.getComment());
		Photo photo = photoServ.getPhotoById(id).get();
		
		Comment newComment = new Comment(comment.getComment(), photo);
		
		commentServ.save(newComment);
		
		return newComment;
	}
}

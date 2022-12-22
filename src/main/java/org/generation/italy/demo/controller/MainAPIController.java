 package org.generation.italy.demo.controller;

import java.util.List;

import org.generation.italy.demo.pojo.Comment;
import org.generation.italy.demo.pojo.Photo;
import org.generation.italy.demo.srv.PhotoServ;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/photos")
@CrossOrigin("*")
public class MainAPIController {

	@Autowired
	private PhotoServ photoServ;
	
	@GetMapping("/all")
	public List<Photo> getAll() {
		
		List<Photo> photoList = photoServ.findAll();		
		return photoList;
	}
	
	@GetMapping("/{id}")
	public List<Photo> getPhotoById(
			@PathVariable("id") int id
			)
	{
		List <Photo> photo = photoServ.findByIdAndVisible(id);
		return photo;
	}	
	
	@GetMapping("/search/{q}")
	public List<Photo> searchByName(
			Model model, 
			@PathVariable("q") String query
			) 
	{
		

		List<Photo> photoList = query == null || query.isEmpty()
							? photoServ.findAll()
							: photoServ.findByTitleOrTagListContaining(query.toLowerCase()); 
		
		model.addAttribute("photoList", photoList);
		model.addAttribute("query", query);
		
		System.out.println(query);
		
		System.out.println(photoList);
		
		return photoList;
	}
	
	@PostMapping("/create-comment")
	public Comment addComment(
			@PathVariable("id") int id, 
			@Valid @RequestBody Comment comment
	) {
		
//		Photo oldPhoto = photoServ.getPhotoById(id).get();
		
System.out.println(comment);		
//		photo.setCommentList(oldPhoto.setCommentList());
//		
//		Pizza newPizza = pizzaServ.save(pizza);
		
		return null;
	}
	


	
}
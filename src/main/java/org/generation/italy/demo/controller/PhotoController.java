package org.generation.italy.demo.controller;

import java.util.List;
import java.util.Optional;

import org.generation.italy.demo.pojo.Photo;
import org.generation.italy.demo.srv.PhotoServ;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@RequestMapping("/admin")
public class PhotoController {
	
	@Autowired
	private PhotoServ photoServ;
	
	@GetMapping("/")
	public String getHome(Model model) {
		
		List<Photo> photoList = photoServ.findAll();
		model.addAttribute("photoList", photoList);
		
		return "homePage";
	}
	
	@GetMapping("/{id}")
	public String getPhotoById(@PathVariable("id") int id, Model model)
	{
		Optional <Photo> optPhoto = photoServ.getPhotoById(id);
		
		Photo photo =optPhoto.get();
		
		model.addAttribute("photo", photo);
		
		return "show";
	}
	
	@GetMapping("/edit/{id}")
	public String editPhoto(@PathVariable("id") int id, Model model,Error e, BindingResult bindingResult, RedirectAttributes redirectAttributes)
	{

		if (bindingResult.hasErrors()) {
			
			System.err.println("ERROR ------------------------------------------");
			System.err.println(bindingResult.getAllErrors());
			System.err.println("------------------------------------------------");
			
			redirectAttributes.addFlashAttribute("errors", bindingResult.getAllErrors());
			
			return "redirect:/photo/create";
		}
		
		Optional<Photo> optPhoto = photoServ.getPhotoById(id);
		
		Photo photo =optPhoto.get();
		
		model.addAttribute("photo", photo);
		
		model.addAttribute("type", "edit");
		model.addAttribute("h1text", "Update photo:");
		
		
		return "photo/form";
	}

}

package org.generation.italy.demo.srv;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import java.util.stream.Collectors;

import org.generation.italy.demo.pojo.Photo;
import org.generation.italy.demo.pojo.Tag;
import org.generation.italy.demo.repo.PhotoRepo;
import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;

@Service
public class PhotoServ {

	@Autowired
	private PhotoRepo photoRepo;
	
	public void save(Photo photo)
	{
		photoRepo.save(photo);
	}
	
	public void delete(int id)
	{
		photoRepo.deleteById(id);
	}
	
	public List<Photo> findAllVisible()
	{
		List<Photo> itemList = photoRepo.findAll();
		
	    List<Photo> visibleItems = itemList.stream()
                .filter(item -> item.getVisible()) 
                .collect(Collectors.toList());
	    
	    return visibleItems;
	}
	
	public List <Photo> findByIdAndVisible(int id)
	{
		return photoRepo.findByIdAndVisible(id, true);
	}
	
	public List<Photo> findAll()
	{
		return photoRepo.findAll();
	}
	
	public Optional<Photo> getPhotoById(int id)
	{
		return photoRepo.findById(id);
	}
	
	@Transactional	
	public List<Photo> findAllWithComments()
	{
		List<Photo> photoList = photoRepo.findAll();
		
		for (Photo photo : photoList) {
			
			Hibernate.initialize(photo.getCommentList());
		}
		
		return photoList;
		
	}
	

	public List<Photo> findByTitleOrTagListContaining(String s)
	{
		List<Photo> photoListCheck = photoRepo.findAll();
		List<Photo> photoList = new ArrayList<Photo> ();
		
		for (Photo photo : photoListCheck) {

			if(!photo.getVisible())
				continue;
			
			if(photo.getTitle().toLowerCase().contains(s)) {
				photoList.add(photo);
				continue;
			}
			
			else {
				for (Tag tag : photo.getTagList())
				{
					if(tag.getTitle().toLowerCase().contains(s)) {
						photoList.add(photo);
						continue;
					}
				}
			}
		}
		return photoList;
	}
	
}

package org.generation.italy.demo.srv;

import java.util.List;

import org.generation.italy.demo.pojo.Photo;
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
	
	public List<Photo> findAll()
	{
		return photoRepo.findAll();
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
	
}

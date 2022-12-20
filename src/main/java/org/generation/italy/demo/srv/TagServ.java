package org.generation.italy.demo.srv;

import java.util.List;

import org.generation.italy.demo.pojo.Tag;
import org.generation.italy.demo.repo.TagRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TagServ {

	@Autowired
	private TagRepo tagRepo;
	
	public void save(Tag tag)
	{
		tagRepo.save(tag);
	}
	
	public void delete(int id)
	{
		tagRepo.deleteById(id);
	}
	
	public List<Tag> findAll()
	{
		return tagRepo.findAll();
	}
	

	
}

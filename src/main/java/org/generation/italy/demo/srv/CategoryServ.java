package org.generation.italy.demo.srv;

import java.util.List;

import org.generation.italy.demo.pojo.Category;
import org.generation.italy.demo.repo.CategoryRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoryServ {

	@Autowired
	private CategoryRepo categoryRepo;
	
	public void save(Category category)
	{
		categoryRepo.save(category);
	}
	
	public void delete(int id)
	{
		categoryRepo.deleteById(id);
	}
	
	public List<Category> findAll()
	{
		return categoryRepo.findAll();
	}
	

	
}

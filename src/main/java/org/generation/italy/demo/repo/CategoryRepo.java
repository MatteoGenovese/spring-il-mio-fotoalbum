package org.generation.italy.demo.repo;

import org.generation.italy.demo.pojo.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepo extends JpaRepository<Category, Integer>{ 
	
	

}

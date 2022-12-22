package org.generation.italy.demo.repo;


import java.util.List;
import java.util.Optional;

import org.generation.italy.demo.pojo.Photo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PhotoRepo extends JpaRepository<Photo, Integer>{ 
	
	
	public List<Photo> findByIdAndVisible(int id, boolean visible);	


}

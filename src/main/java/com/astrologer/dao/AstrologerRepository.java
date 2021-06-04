package com.astrologer.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.astrologer.entities.Astrologer;

public interface AstrologerRepository extends JpaRepository<Astrologer, Integer> {
	
	@Query("from Astrologer as c where c.user.id =:userId")
	public List<Astrologer> findByAstrologerByUser(@Param("userId") int userId);	

}

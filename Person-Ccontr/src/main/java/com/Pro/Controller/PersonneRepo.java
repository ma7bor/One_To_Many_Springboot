package com.Pro.Controller;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface PersonneRepo extends JpaRepository<PersonneEntity, Long> {
	
	
	
	
}

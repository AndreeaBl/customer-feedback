package org.app.domain.services;

import java.util.List;

import org.app.domain.Feedback;
import org.app.domain.RootEntity;
import org.app.domain.User;
/*
 * Use Spring Data JpaRepository
 */
//import org.springframework.data.repository.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface IAggregateRepositorySpringData 
	extends JpaRepository<Feedback, Integer>
{
	List<Feedback> findAll(); // extends Repository only
	
		// Queriable Annotated Operation
	@Query("SELECT r FROM Feedback r WHERE r.titlu like %:fname%")
	List<Feedback> findByName(@Param("fname") String titlu);
	
}

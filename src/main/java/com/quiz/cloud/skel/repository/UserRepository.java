package com.quiz.cloud.skel.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.quiz.cloud.skel.model.User;


@Repository
public interface UserRepository extends JpaRepository<User, Long> {
	User findByEmail(String email);

	User findByUsername(String username);
	
	User findBymId(Long id);
	
	User save(User u);
	
	@Query("FROM User u")
	List<User> findAll();
}

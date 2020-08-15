package com.quiz.cloud.skel.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.quiz.cloud.skel.model.Quiz;
import com.quiz.cloud.skel.model.User;


@Repository
public interface QuizRepository extends JpaRepository<Quiz, Long> {
//	User findByEmail(String email);
//
//	User findByUsername(String username);
//	
//	User findBymId(Long id);
	
	Quiz save(Quiz u);
	
	@Query("FROM Quiz q")
	List<Quiz> findAll();
}

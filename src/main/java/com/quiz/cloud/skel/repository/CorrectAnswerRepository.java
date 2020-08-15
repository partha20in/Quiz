package com.quiz.cloud.skel.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.quiz.cloud.skel.model.*;
import com.quiz.cloud.skel.model.Question;
import com.quiz.cloud.skel.model.Quiz;
import com.quiz.cloud.skel.model.User;


@Repository
public interface CorrectAnswerRepository extends JpaRepository<CorrectAnswer, Long> {
//	User findByEmail(String email);
//
	List<CorrectAnswer> findByUsername(String username);
//	
//	User findBymId(Long id);
	
	CorrectAnswer save(CorrectAnswer a);
	
	@Query("FROM CorrectAnswer a")
	List<CorrectAnswer> findAll();
}

package com.quiz.cloud.skel.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.quiz.cloud.skel.model.Answer;
import com.quiz.cloud.skel.model.Question;
import com.quiz.cloud.skel.model.Quiz;
import com.quiz.cloud.skel.model.User;


@Repository
public interface AnswerRepository extends JpaRepository<Answer, Long> {
//	User findByEmail(String email);
//
//	Answer findByUsername(String username);
//	
//	User findBymId(Long id);
	
	Answer save(Answer a);
	
	@Query("FROM Answer a")
	List<Answer> findAll();
}

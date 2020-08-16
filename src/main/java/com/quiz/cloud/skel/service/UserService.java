package com.quiz.cloud.skel.service;


import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.quiz.cloud.skel.exception.ResourceUnavailableException;
import com.quiz.cloud.skel.exception.UserAlreadyExistsException;
import com.quiz.cloud.skel.model.Answer;
import com.quiz.cloud.skel.model.CorrectAnswer;
import com.quiz.cloud.skel.model.Question;
import com.quiz.cloud.skel.model.Quiz;
import com.quiz.cloud.skel.model.Result;
import com.quiz.cloud.skel.model.User;
import com.quiz.cloud.skel.repository.AnswerRepository;
import com.quiz.cloud.skel.repository.CorrectAnswerRepository;
import com.quiz.cloud.skel.repository.QuestionRepository;
import com.quiz.cloud.skel.repository.QuizRepository;
import com.quiz.cloud.skel.repository.ResultRepository;
import com.quiz.cloud.skel.repository.UserRepository;



@Service
@Transactional
public class UserService {

	private static final Logger logger = LoggerFactory.getLogger(UserService.class);
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private QuestionRepository quesrepo;
	@Autowired
	private QuizRepository quizRepository;
	@Autowired
	private AnswerRepository anssrepo;
	
	@Autowired
	private CorrectAnswerRepository corranssrepo;
	
	@Autowired
	private ResultRepository resultRepo;
	
	private static int score;
	
	private static int hit;


	

//	@Override
//	/*
//	 * Look up by Username. Throw exception if it wasn't in
//	 * 
//	 */
	public User loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = null;

		try {
			user = findByUsername(username);
		} catch (ResourceUnavailableException e) {
			logger.info("User does not exist");
		}

		return user;
	}

	public User findByUsername(String username) throws ResourceUnavailableException {
		User user = userRepository.findByUsername(username);

		if (user == null) {
			logger.error("The user " + username + " doesn't exist");
			throw new ResourceUnavailableException("The user " + username + " doesn't exist");
		}

		return user;
	}
	
	public boolean validateUser(String username,String password) {
		User u=findByUsername(username);
		if(u.getPassword().equals(password)&& u.isEnabled()==true) {
			return true;
		}
		else {
		return false;
		}
		
	}
	
	public boolean validateAnswer(String Username,int order,String answer,boolean timeLifeline) {
		List<CorrectAnswer> correct=corranssrepo.findByUsername(Username);
		hit++;
		for(CorrectAnswer a:correct) {
		if(a.getQuestion().getOrder()==order){
			
			if(a.getCorrect().equalsIgnoreCase(answer)&& score<=5 && hit<=5) {
				
				score++;
				Result r=new Result(Username,score,new Date(),timeLifeline);
				resultRepo.save(r);
				
				return true;
			}
		}
		}
		return false;
		
		
	}
		


	
	public User findUserById(Long Id) {
		return userRepository.findBymId(Id);
	}
	
	public List<User> findAllUser() {
		return userRepository.findAll();
	}



}

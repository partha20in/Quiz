package com.quiz.cloud.skel.service;


import java.util.Date;
import java.util.List;
import java.util.Optional;

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
import com.quiz.cloud.skel.model.AuthenticatedUser;
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
	
	private PasswordEncoder passwordEncoder;
	
	private static int score;
	
	private static int hit;

//	@Autowired
//	public UserServiceImpl(UserRepository userRepository,
//			PasswordEncoder passwordEncoder) {
//		this.userRepository = userRepository;
//		this.passwordEncoder = passwordEncoder;
//	}

//	public User saveUser(User user) throws UserAlreadyExistsException {
//		if (userRepository.findByEmail(user.getEmail()) != null) {
//			logger.error( user.getEmail() + " is already registered");
//			throw new UserAlreadyExistsException(user.getEmail() + " is already in use");
//		}
//
//		user.setCreatedDate(new Date() );
//		Question qs=new Question();
//		qs.getOrder();
//		Answer as=new Answer();
//		Quiz q=new Quiz();
//		q.setDescription(user.getQuiz().getDescription());
//		q.setName(user.getQuiz().getName());
//		q.setQuestions(questions);
//		
//		User u= userRepository.save(user);
//		
//		
//		return u;
//	}

//	@Override
//	/*
//	 * Look up by both Email and Username. Throw exception if it wasn't in
//	 * either. TODO: Join Username and Email into one JPQL
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
			
			if(a.getCorrect().equalsIgnoreCase(answer)&& score<=10 && hit<=10) {
				
				score++;
				Result r=new Result(Username,score,new Date(),timeLifeline);
				resultRepo.save(r);
				
				return true;
			}
		}
		}
		return false;
		
		
	}
		

//	@Override
//	public User find(Long id) throws ResourceUnavailableException {
//		User user = userRepository.findOne(id);
//
//		if (user == null) {
//			logger.error("The user " + id + " can't be found");
//			throw new ResourceUnavailableException("User " + id + " not found.");
//		}
//
//		return user;
//	}
//
//	@Override
//	public void delete(Long user_id) throws UnauthorizedActionException, ResourceUnavailableException {
//		User userToDelete = find(user_id);
//
//		userRepository.delete(userToDelete);
//	}

//	public User setRegistrationCompleted(User user) {
//		User u=new User();
//		u.setEnabled(true);
//		u.setEmail(user.getEmail());
//		u.setId(user.getId());
//		u.setUsername(user.getUsername());
//		u.setPassword(user.getPassword());
//		logger.info("In setRegistrationCompleted :"+user.isEnabled());
//		return userRepository.save(u);
//	}
	
	public User findUserById(Long Id) {
		return userRepository.findBymId(Id);
	}
	
	public List<User> findAllUser() {
		return userRepository.findAll();
	}

//	@Override
//	public boolean isRegistrationCompleted(User user) {
//		return user.getEnabled();
//	}
//
//	@Override
//	public User findByEmail(String email) throws ResourceUnavailableException {
//		User user = userRepository.findByEmail(email);
//
//		if (user == null) {
//			logger.error("The mail " + email + " can't be found");
//			throw new ResourceUnavailableException("The mail " + email + " can't be found");
//		}
//
//		return user;
//	}
//
//	@Override
//	public User updatePassword(User user, String password) throws ResourceUnavailableException {
//		user.setPassword(passwordEncoder.encode(password));
//		return userRepository.save(user);
//	}

}

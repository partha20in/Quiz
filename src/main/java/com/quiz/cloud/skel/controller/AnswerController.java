package com.quiz.cloud.skel.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.quiz.cloud.skel.exception.ResourceUnavailableException;
import com.quiz.cloud.skel.model.AuthenticatedUser;
import com.quiz.cloud.skel.model.CorrectAnswer;
import com.quiz.cloud.skel.model.User;
import com.quiz.cloud.skel.repository.CorrectAnswerRepository;
import com.quiz.cloud.skel.repository.UserRepository;
import com.quiz.cloud.skel.service.UserService;
import io.swagger.annotations.Api;



@Component
@Path("/api/1.0/answer")
@Api()
public class AnswerController {

	//public static final String ROOT_MAPPING = "/api/users";
	private static final Logger logger = LoggerFactory.getLogger(AnswerController.class);

//	@Autowired
//	private RegistrationService registrationService;
//	
//	@Autowired
//	private UserManagementService userManagementService;

	@Autowired
	private UserService userService;
	
	@Autowired
	private CorrectAnswerRepository repo;

//	@Autowired
//	private QuizService quizService;

	
	@POST
    @Produces(MediaType.APPLICATION_JSON)
	@Transactional(readOnly = true, propagation = Propagation.REQUIRED)
	@Path("/insertCorrectAnswer")
	public Response<User> insertCorrectAnswer(@RequestBody CorrectAnswer ans) {

		//RestVerifier.verifyModelResult(result);
		CorrectAnswer correct = repo.save(ans);

		//if (registrationService.isRegistrationCompleted(newUser)) {
			return Response.ok();
//		} else {
//			return new ResponseEntity<User>(newUser, HttpStatus.OK);
//		}
	}

	
	

	@GET
    @Produces(MediaType.APPLICATION_JSON)
	@Transactional(readOnly = true, propagation = Propagation.REQUIRED)
	@Path("/allAnswer")
	public List<CorrectAnswer> allAnswer() {

		return repo.findAll();
	}

//	@RequestMapping(value = "/{user_id}/quizzes", method = RequestMethod.GET)
//	@PreAuthorize("permitAll")
//	@ResponseStatus(HttpStatus.OK)
//	public Page<Quiz> getQuizzesByUser(Pageable pageable, @PathVariable Long user_id) {
//		logger.debug("Requested page " + pageable.getPageNumber() + " from user " + user_id);
//		
//		User user = userService.find(user_id);
//		return quizService.findQuizzesByUser(user, pageable);
//	}
	
//	@RequestMapping(value = "/myQuizzes", method = RequestMethod.GET)
//	@PreAuthorize("isAuthenticated()")
//	@ResponseStatus(HttpStatus.OK)
//	public Page<Quiz> getQuizzesByCurrentUser(@AuthenticationPrincipal AuthenticatedUser authenticatedUser,
//			Pageable pageable) {
//		logger.debug("Requested page " + pageable.getPageNumber() + " from user " + authenticatedUser.getUsername());
//		
//		return getQuizzesByUser(pageable, authenticatedUser.getId());
//	}
	
	@POST
    @Produces(MediaType.APPLICATION_JSON)
	@Transactional(readOnly = false, propagation = Propagation.REQUIRES_NEW)
	@Path("/login/{username}/{password}")
	public Response<User> login(@PathParam(value="username") String username,@PathParam(value="password") String password) {
	
		boolean result=userService.validateUser(username,password);
		logger.info("In login api");
		if(result) {
		return Response.ok();
		}
		else {
		return Response.validationException();
		}
	}
	
	@GET
    @Produces(MediaType.APPLICATION_JSON)
	@Transactional(readOnly = true, propagation = Propagation.REQUIRES_NEW)
	@Path("/getUserQuiz/{username}/{password}")
	public User getQuizByUser(@PathParam(value="username") String username,@PathParam(value="password") String password) {
	
		boolean result=userService.validateUser(username,password);
		logger.info("In login api");
		if(result) {
		return userService.loadUserByUsername(username);
		}
		else {
		 throw new ResourceUnavailableException();
		}
		
		
	}
	
	
	
	@RequestMapping(value = "/logoutUser")
	@PreAuthorize("permitAll()")
	@ResponseStatus(HttpStatus.OK)
	public void logout() {
		// Dummy endpoint to point Spring Security to
		logger.debug("Logged out");
	}
	
//	@RequestMapping(value = "/forgotPassword")
//	@PreAuthorize("permitAll")
//	@ResponseStatus(HttpStatus.OK)
//	public User forgotPassword(String email) {
//		User user = userService.findByEmail(email);
//		userManagementService.resendPassword(user);
//		
//		return user;
//	}
	

}

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
import org.springframework.scheduling.annotation.Scheduled;
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
import com.quiz.cloud.skel.model.CorrectAnswer;
import com.quiz.cloud.skel.model.User;
import com.quiz.cloud.skel.repository.UserRepository;
import com.quiz.cloud.skel.service.UserService;
import io.swagger.annotations.Api;



@Component
@Path("/api/1.0/user")
@Api()
public class UserController {

	private static final Logger logger = LoggerFactory.getLogger(UserController.class);
	
	@Autowired
	private UserService userService;



	@GET
    @Produces(MediaType.APPLICATION_JSON)
	@Transactional(readOnly = true, propagation = Propagation.REQUIRED)
	@Path("/allUsers")
	public List<User> allUser() {

		return userService.findAllUser();
	}


	
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
	
	@GET
    @Produces(MediaType.APPLICATION_JSON)
	@Scheduled(fixedDelay = 15000)
	@Transactional(readOnly = true, propagation = Propagation.REQUIRES_NEW)
	@Path("/submitAnswer/{username}/{password}/{order}/{answer}")
	public Response<CorrectAnswer> submitAnswerAndValidate(@PathParam(value="username") String username,@PathParam(value="password") String password,
			@PathParam(value="order") int order,@PathParam(value="answer") String answer) {
	    boolean timeLifeLine=false;
		boolean result=userService.validateUser(username,password);
		if(result) {
			boolean res=userService.validateAnswer(username, order, answer,timeLifeLine);
			if(res) {
			return	Response.ok();
			}
		}
		
			
		return Response.WRONG_ANSWER();
		}
	
	@GET
    @Produces(MediaType.APPLICATION_JSON)
	@Scheduled(fixedDelay = 25000)
	@Transactional(readOnly = true, propagation = Propagation.REQUIRES_NEW)
	@Path("/submitAnswerTimeLifeline/{username}/{password}/{order}/{answer}")
	public Response<CorrectAnswer> submitAnswerAndValidateWithTimeLifeline(@PathParam(value="username") String username,@PathParam(value="password") String password,
			@PathParam(value="order") int order,@PathParam(value="answer") String answer) {
	    boolean timeLifeline=true;
		boolean result=userService.validateUser(username,password);
		if(result) {
			boolean res=userService.validateAnswer(username, order, answer,timeLifeline);
			if(res) {
			return	Response.ok();
			}
		}
		
			
		return Response.WRONG_ANSWER();
		}
		


	
	
	
	
	

}

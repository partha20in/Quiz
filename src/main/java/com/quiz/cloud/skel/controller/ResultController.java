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
import com.quiz.cloud.skel.model.CorrectAnswer;
import com.quiz.cloud.skel.model.Result;
import com.quiz.cloud.skel.model.User;
import com.quiz.cloud.skel.repository.CorrectAnswerRepository;
import com.quiz.cloud.skel.repository.ResultRepository;
import com.quiz.cloud.skel.repository.UserRepository;
import com.quiz.cloud.skel.service.UserService;
import io.swagger.annotations.Api;



@Component
@Path("/api/1.0/result")
@Api()
public class ResultController {

	//public static final String ROOT_MAPPING = "/api/users";
	private static final Logger logger = LoggerFactory.getLogger(ResultController.class);


	@Autowired
	private UserService userService;
	
	@Autowired
	private ResultRepository repo;


	

	@GET
    @Produces(MediaType.APPLICATION_JSON)
	@Transactional(readOnly = true, propagation = Propagation.REQUIRED)
	@Path("/allResult")
	public List<Result> allResult() {

		return repo.findAll();
	}



}

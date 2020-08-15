package com.quiz.cloud.skel;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Stream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import com.quiz.cloud.skel.controller.UserController;
import com.quiz.cloud.skel.model.Answer;
import com.quiz.cloud.skel.model.CorrectAnswer;
import com.quiz.cloud.skel.model.Question;
import com.quiz.cloud.skel.model.Quiz;
import com.quiz.cloud.skel.model.User;
import com.quiz.cloud.skel.repository.*;


@SpringBootApplication(scanBasePackageClasses = { UserController.class, SkelApplication.class })
@EnableJpaRepositories(basePackageClasses = { UserRepository.class ,QuizRepository.class ,CorrectAnswerRepository.class, QuestionRepository.class,AnswerRepository.class })
public class SkelApplication {
private static final Logger logger = LoggerFactory.getLogger(SkelApplication.class);
  public static void main(String[] args) {
    SpringApplication.run(SkelApplication.class, args);
  }
  User user;
  Quiz quiz;
  Question q1;
  Question q2;
  Question q3;
  Question q4;
  Set<Question> qs=new HashSet<Question>();
  Set<Answer> as=new HashSet<Answer>();
  Set<Answer> as1=new HashSet<Answer>();
  Set<Answer> as2=new HashSet<Answer>();
  Set<Answer> as3=new HashSet<Answer>();
  
//  Player player;
    
//  List<Account> accounts= new ArrayList<Account>();
//  
  
  @Bean
  ApplicationRunner initItems(UserRepository userrepository,QuizRepository quizrepository,QuestionRepository questionrepository,AnswerRepository answerrepository,
		  CorrectAnswerRepository correctAnswerRepository ) {
    return args -> {
    	
    	
//      Stream.of("abc@xyz.com")
//            .forEach(email -> {
//        	user.setUsername("abc");
//        	user.setEmail(email);
//        	user.setEnabled(true);
//        	user.setPassword("abc");
//        	
//            userrepository.save(user);
//            
//          });
    	Answer a1=new Answer();
    	a1.setOrder(1);
    	a1.setText("Stockholm");
    	answerrepository.save(a1);
    	Answer a2=new Answer();
    	a2.setOrder(2);
    	a2.setText("Copenhagen");
    	answerrepository.save(a2);
    	Answer a3=new Answer();
    	a3.setOrder(3);
    	a3.setText("NewDelhi");
    	answerrepository.save(a3);
    	as.add(a1);
    	as.add(a2);
    	as.add(a3);
    	
    	Answer a4=new Answer();
    	a4.setOrder(1);
    	a4.setText("Stockholm");
    	answerrepository.save(a4);
    	Answer a5=new Answer();
    	a5.setOrder(2);
    	a5.setText("Copenhagen");
    	answerrepository.save(a5);
    	Answer a6=new Answer();
    	a6.setOrder(3);
    	a6.setText("NewDelhi");
    	answerrepository.save(a6);
    	as1.add(a4);
    	as1.add(a5);
    	as1.add(a6);
    	
    	Answer a7=new Answer();
    	a7.setOrder(1);
    	a7.setText("Paris");
    	answerrepository.save(a7);
    	Answer a8=new Answer();
    	a8.setOrder(2);
    	a8.setText("Copenhagen");
    	answerrepository.save(a8);
    	Answer a9=new Answer();
    	a9.setOrder(3);
    	a9.setText("NewDelhi");
    	answerrepository.save(a9);
    	as2.add(a7);
    	as2.add(a8);
    	as2.add(a9);
    	
    	Answer a10=new Answer();
    	a10.setOrder(1);
    	a10.setText("Paris");
    	answerrepository.save(a10);
    	Answer a11=new Answer();
    	a11.setOrder(2);
    	a11.setText("Copenhagen");
    	answerrepository.save(a11);
    	Answer a12=new Answer();
    	a12.setOrder(3);
    	a12.setText("NewDelhi");
    	answerrepository.save(a12);
    	as3.add(a10);
    	as3.add(a11);
    	as3.add(a12);
    	
    	
    	q1=new Question();
    	q1.setOrder(1);
    	q1.setText("What is Capital of Sweden");
    	q1.setAnswers(as);
    	System.out.println("Answer"+q1.getAnswers());
    	questionrepository.save(q1);
    	q2=new Question();
    	q2.setOrder(2);
    	q2.setText("What is Capital of India");
    	q2.setAnswers(as1);
    	questionrepository.save(q2);
    	q3=new Question();
    	q3.setOrder(3);
    	q3.setAnswers(as2);
    	q3.setText("What is Capital of France");
    	questionrepository.save(q3);
    	q4=new Question();
    	q4.setOrder(4);
    	q4.setAnswers(as3);
    	q4.setText("What is Capital of Denmark");
    	questionrepository.save(q4);
    	qs.add(q1);
    	qs.add(q2);
    	qs.add(q3);
    	qs.add(q4);
    	
    	quiz=new Quiz();
    	quiz.setDescription("General Quiz");
    	quiz.setName("General");
    	quiz.setQuestions(qs);
    	quizrepository.save(quiz);
    	
    	user=new User();
    	user.setUsername("abc");
    	user.setEmail("abc@xyz.com");
    	user.setEnabled(true);
    	user.setPassword("abc");
    	user.setQuiz(quiz);
    	user.setCreatedDate(new Date());
    	userrepository.save(user);
    	
//    	User user1=new User();
//    	user1.setUsername("def");
//    	user1.setEmail("def@xyz.com");
//    	user1.setEnabled(true);
//    	user1.setPassword("def");
//    	//user1.setQuiz(quiz);
//    	user1.setCreatedDate(new Date());
//    	userrepository.save(user1);
    	
    	CorrectAnswer ans=new CorrectAnswer();
    	ans.setCreatedDate(new Date());
    	ans.setQuestion(q1);
    	ans.setUsername("abc");
    	ans.setCorrect("Stockholm");
    	correctAnswerRepository.save(ans);
    	
    	CorrectAnswer ans1=new CorrectAnswer();
    	ans1.setCreatedDate(new Date());
    	ans1.setQuestion(q2);
    	ans1.setUsername("abc");
    	ans1.setCorrect("NewDelhi");
    	correctAnswerRepository.save(ans1);
    	
    	CorrectAnswer ans2=new CorrectAnswer();
    	ans2.setCreatedDate(new Date());
    	ans2.setQuestion(q3);
    	ans2.setUsername("abc");
    	ans2.setCorrect("Paris");
    	correctAnswerRepository.save(ans2);
    	
    	CorrectAnswer ans3=new CorrectAnswer();
    	ans3.setCreatedDate(new Date());
    	ans3.setQuestion(q4);
    	ans3.setUsername("abc");
    	ans3.setCorrect("Copenhagen");
    	correctAnswerRepository.save(ans3);
    	
    	
    	
    	
//      logger.info("Account info at start"+accounts);
//      
//      
//      Stream.of("Player1", "Player2")
//    .forEach((name) -> {
//    	player=new Player();
//    	player.setName(name);
//    	player.setAge(18);
//    	player.setGender(Gender.MALE);
//    	if(name.equals("Player1")) {
//    	player.setAccount(accounts.get(0));
//    	}
//    	else {
//    	player.setAccount(accounts.get(1));
//    	}
//    	playerrepository.save(player);
//    	
//    });
//     
//
//
//    accountrepository.findAll().forEach(System.out::println);
//    playerrepository.findAll().forEach(System.out::println);
//    
  };
  }

}

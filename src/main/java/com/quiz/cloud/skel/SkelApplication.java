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
  Question q5;
  Set<Question> qs=new HashSet<Question>();
  Set<Answer> as=new HashSet<Answer>();
  Set<Answer> as1=new HashSet<Answer>();
  Set<Answer> as2=new HashSet<Answer>();
  Set<Answer> as3=new HashSet<Answer>();
  Set<Answer> as4=new HashSet<Answer>();
  
  
  
  @Bean
  ApplicationRunner initItems(UserRepository userrepository,QuizRepository quizrepository,QuestionRepository questionrepository,AnswerRepository answerrepository,
		  CorrectAnswerRepository correctAnswerRepository ) {
    return args -> {
    	
    	

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
    	Answer a13=new Answer();
    	a13.setOrder(4);
    	a13.setText("Oslo");
    	answerrepository.save(a13);
    	as.add(a1);
    	as.add(a2);
    	as.add(a3);
    	as.add(a13);
    	
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
    	Answer a16=new Answer();
    	a16.setOrder(4);
    	a16.setText("Oslo");
    	answerrepository.save(a16);
    	as1.add(a4);
    	as1.add(a5);
    	as1.add(a6);
    	as1.add(a16);
    	
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
    	Answer a19=new Answer();
    	a19.setOrder(4);
    	a19.setText("Oslo");
    	answerrepository.save(a19);
    	as2.add(a7);
    	as2.add(a8);
    	as2.add(a9);
    	as2.add(a19);
    	
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
    	Answer a122=new Answer();
    	a122.setOrder(4);
    	a122.setText("Oslo");
    	answerrepository.save(a122);
    	as3.add(a10);
    	as3.add(a11);
    	as3.add(a12);
    	as3.add(a122);
    	
    	Answer a20=new Answer();
    	a20.setOrder(1);
    	a20.setText("Paris");
    	answerrepository.save(a20);
    	Answer a21=new Answer();
    	a21.setOrder(2);
    	a21.setText("Copenhagen");
    	answerrepository.save(a21);
    	Answer a22=new Answer();
    	a22.setOrder(3);
    	a22.setText("NewDelhi");
    	answerrepository.save(a22);
    	Answer a23=new Answer();
    	a23.setOrder(4);
    	a23.setText("Oslo");
    	answerrepository.save(a23);
    	as4.add(a20);
    	as4.add(a21);
    	as4.add(a22);
    	as4.add(a23);
    	
    	
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
    	q5=new Question();
    	q5.setOrder(5);
    	q5.setAnswers(as4);
    	q5.setText("What is Capital of Norway");
    	questionrepository.save(q5);
    	qs.add(q1);
    	qs.add(q2);
    	qs.add(q3);
    	qs.add(q4);
    	qs.add(q5);
    	
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
    	
    	CorrectAnswer ans4=new CorrectAnswer();
    	ans4.setCreatedDate(new Date());
    	ans4.setQuestion(q5);
    	ans4.setUsername("abc");
    	ans4.setCorrect("Oslo");
    	correctAnswerRepository.save(ans4);
    	
    	
    	
    	

  };
  }

}

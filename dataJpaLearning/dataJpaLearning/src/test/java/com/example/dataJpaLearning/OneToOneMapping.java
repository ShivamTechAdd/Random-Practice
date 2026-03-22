package com.example.dataJpaLearning;

import com.example.dataJpaLearning.Model.Answer;
import com.example.dataJpaLearning.Model.Question;
import com.example.dataJpaLearning.Repository.AnswerRepository;
import com.example.dataJpaLearning.Repository.QuestionRepository;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

import java.io.IOException;

@SpringBootTest
public class OneToOneMapping {
    @Autowired
    private QuestionRepository questionRepository;
    @Autowired
    private AnswerRepository answerRepository;

    @Test
    @Transactional
    @Rollback(value = false)
    void saveQuestion() throws IOException {

        Question question1 = new Question();
        question1.setQuestionId(1212);
        question1.setQuestion("What is java ?");

        Answer answer = new Answer();
        answer.setAnswerId(343);
        answer.setAnswer("Java is a programing Language");

        question1.setAnswer(answer);

        answerRepository.save(answer);

        question1.setAnswer(answer);
        questionRepository.save(question1);
        System.out.println("1 Question saved successfully");
    }

    @Test
    @Transactional
    @Rollback(value = false)
    void fetchQuestion() throws IOException {
        Question question = questionRepository.findById(1212)
                .orElseThrow(()->new RuntimeException("Class Not Found"));

        System.out.println(question.getQuestion());
        System.out.println(question.getAnswer());

    }

    @Test
    @Transactional
    @Rollback(value = false)
    void fetchAnswer() throws IOException {

        Answer answer = answerRepository.findById(343)
                .orElseThrow(()->new RuntimeException("Class Not Found"));

        System.out.println(answer.getQuestion().getQuestion());
        System.out.println(answer.getAnswer());

    }

}






























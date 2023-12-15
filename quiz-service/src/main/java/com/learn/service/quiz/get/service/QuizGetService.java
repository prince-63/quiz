package com.learn.service.quiz.get.service;

import com.learn.config.QuizInterface;
import com.learn.model.QuestionWrapper;
import com.learn.model.Quiz;
import com.learn.repo.QuizRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class QuizGetService {

    @Autowired
    private QuizRepository quizRepository;

    @Autowired
    private QuizInterface quizInterface;

    public ResponseEntity<List<QuestionWrapper>> getQuestionById(Integer id) {
        Quiz quiz = quizRepository.findById(Long.valueOf(id)).orElse(null);
        log.info(quiz.toString());

        // extract question ids
        List<Integer> questionIds = quiz.getQuestionId();
        List<QuestionWrapper> questionWrappers = quizInterface.getQuestion(questionIds).getBody();
        log.info(questionWrappers.toString());
        return new ResponseEntity<>(questionWrappers, HttpStatus.OK);
    }
}

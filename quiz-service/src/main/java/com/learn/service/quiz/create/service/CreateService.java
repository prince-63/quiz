package com.learn.service.quiz.create.service;

import com.learn.config.QuizInterface;
import com.learn.model.Quiz;
import com.learn.repo.QuizRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class CreateService {

    @Autowired
    private QuizRepository quizRepository;

    @Autowired
    private QuizInterface quizInterface;

    public ResponseEntity<Quiz> createQuiz(String title, String category) {
        try {
            List<Integer> questionIds = quizInterface.getQuestionForQuiz(category).getBody();
            Quiz quiz = new Quiz();
            quiz.setTitle(title);
            quiz.setCategory(category);
            assert questionIds != null;
            quiz.getQuestionId().addAll(questionIds);
            log.info(quiz.toString());
            quizRepository.save(quiz);
            return new ResponseEntity<>(quiz, HttpStatus.CREATED);
        }
        catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }
}

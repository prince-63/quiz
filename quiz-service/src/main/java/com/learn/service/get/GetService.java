package com.learn.service.get;

import com.learn.config.QuizInterface;
import com.learn.model.QuestionWrapper;
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
public class GetService {

    @Autowired
    private QuizRepository quizRepository;

    @Autowired
    private QuizInterface quizInterface;

    public ResponseEntity<List<QuestionWrapper>> getQuestionById(Long id) {
        Quiz quiz = quizRepository.findById(id).orElseThrow();

        // extract question ids
        List<Long> questionIds = quiz.getQuestionId();
        List<QuestionWrapper> questionWrappers = quizInterface.getQuizByQuestionId(questionIds).getBody();

        return new ResponseEntity<>(questionWrappers, HttpStatus.OK);
    }
}

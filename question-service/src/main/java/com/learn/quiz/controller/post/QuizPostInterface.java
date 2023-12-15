package com.learn.quiz.controller.post;

import com.learn.model.QuestionWrapper;
import com.learn.model.Response;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface QuizPostInterface {
    public ResponseEntity<List<QuestionWrapper>> getQuizByQuestionId(List<Long> questionIds);
    public ResponseEntity<Integer> calculateResult(List<Response> responses);
}

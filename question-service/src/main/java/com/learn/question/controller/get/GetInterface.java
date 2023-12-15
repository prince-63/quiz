package com.learn.question.controller.get;

import com.learn.model.Question;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface GetInterface {
  public ResponseEntity<List<Question>> getAllQuestion();
  public ResponseEntity<Question> getQuestionById(Long id);
}

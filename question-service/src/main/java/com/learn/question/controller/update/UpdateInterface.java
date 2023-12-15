package com.learn.question.controller.update;

import com.learn.model.Question;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public interface UpdateInterface {
    public ResponseEntity<HttpStatus> updateQuestion(Question newQuestion, Long id);
}

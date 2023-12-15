package com.learn.question.controller.delete;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public interface DeleteInterface {
    public ResponseEntity<HttpStatus> deleteAllQuestion();
    public ResponseEntity<HttpStatus> deleteQuestionById(Long id);
}

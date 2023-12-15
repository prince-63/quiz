package com.learn.question.controller.post;

import com.learn.model.Question;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface PostInterface {
    public ResponseEntity<HttpStatus> postAllQuestion(List<Question> questions);
    public ResponseEntity<HttpStatus> postOneQuestion(Question question);
}

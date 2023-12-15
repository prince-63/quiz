package com.learn.quiz.controller.get;

import org.springframework.http.ResponseEntity;

import java.util.List;

public interface GetPostInterface {
    public ResponseEntity<List<Long>> createQuiz(String category);
}

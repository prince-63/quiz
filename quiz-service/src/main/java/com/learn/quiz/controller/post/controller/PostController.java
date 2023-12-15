package com.learn.quiz.controller.post.controller;

import com.learn.model.Quiz;
import com.learn.service.quiz.create.service.CreateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("quiz")
public class PostController {

    @Autowired
    private CreateService createService;

    @PostMapping("/create")
    public ResponseEntity<Quiz> createQuiz(@RequestParam String title, @RequestParam String category) {
        return createService.createQuiz(title, category);
    }
}

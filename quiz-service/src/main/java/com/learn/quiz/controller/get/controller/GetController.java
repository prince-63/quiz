package com.learn.quiz.controller.get.controller;

import com.learn.model.QuestionWrapper;
import com.learn.service.quiz.get.service.QuizGetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/quiz")
public class GetController {
    @Autowired
    private QuizGetService quizGetService;
    @PostMapping("/{id}")
    public ResponseEntity<List<QuestionWrapper>> getQuestionById(@PathVariable Integer id) {
        return quizGetService.getQuestionById(id);
        //return new ResponseEntity<>("Hello", HttpStatus.OK);
    }
}

package com.learn.quiz.controller.get;

import com.learn.quiz.service.get.QuizGetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/question/create")

public class QuizGetImplementationPost implements GetPostInterface {

    @Autowired
    private QuizGetService quizGetService;

    @Override
    @GetMapping("/quiz")
    public ResponseEntity<List<Long>> createQuiz(@RequestParam String category) {
        return quizGetService.findByCategory(category);
    }
}

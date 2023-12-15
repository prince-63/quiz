package com.learn.quiz.controller.post;

import com.learn.model.QuestionWrapper;
import com.learn.model.Response;
import com.learn.quiz.service.post.QuizPostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/question/get")
public class QuizPostPostImplementation implements QuizPostInterface {

    @Autowired
    private QuizPostService quizPostService;

    @Override
    @PostMapping("/quiz")
    public ResponseEntity<List<QuestionWrapper>> getQuizByQuestionId(@RequestBody List<Long> questionIds) {
        return quizPostService.getQuizByQuestionId(questionIds);
    }

    @Override
    @PostMapping("/submit")
    public ResponseEntity<Integer> calculateResult(@RequestBody List<Response> responses) {
        return quizPostService.calculateResult(responses);
    }
}

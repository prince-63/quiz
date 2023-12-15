package com.learn.config;

import com.learn.model.QuestionWrapper;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient("QUESTION-SERVICE")
public interface QuizInterface {
    @GetMapping("questions/quiz/create")
    public ResponseEntity<List<Integer>> getQuestionForQuiz(@RequestParam String category);
    @GetMapping("questions/quiz")
    public ResponseEntity<List<QuestionWrapper>> getQuestion(@RequestParam List<Integer> questionIds);
}

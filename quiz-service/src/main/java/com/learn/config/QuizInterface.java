package com.learn.config;

import com.learn.model.QuestionWrapper;
import com.learn.model.Response;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient("QUESTION-SERVICE")
public interface QuizInterface {
    @GetMapping("/question/create/quiz")
    public ResponseEntity<List<Long>> getQuestionForQuiz(@RequestParam String category);

    @PostMapping("question/get/quiz")
    public ResponseEntity<List<QuestionWrapper>> getQuizByQuestionId(@RequestBody List<Long> questionIds);

    @PostMapping("question/get/submit")
    public ResponseEntity<Integer> calculateResult(@RequestBody List<Response> responses);
}

package com.learn.question.controller.get;

import com.learn.model.Question;
import com.learn.question.service.get.GetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/question")
public class GetImplementation implements GetInterface{

    @Autowired
    private GetService getService;

    @Override
    @GetMapping("/all")
    public ResponseEntity<List<Question>> getAllQuestion() {
        return getService.getAllQuestion();
    }

    @Override
    @GetMapping("/{id}")
    public ResponseEntity<Question> getQuestionById(@PathVariable Long id) {
        return getService.getQuestionById(id);
    }
}

package com.learn.question.controller.delete;

import com.learn.question.service.delete.DeleteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/question")
public class DeleteImplementation implements DeleteInterface{

    @Autowired
    private DeleteService deleteService;

    @Override
    @DeleteMapping("/delete/all")
    public ResponseEntity<HttpStatus> deleteAllQuestion() {
        return deleteService.deleteAllQuestion();
    }

    @Override
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<HttpStatus> deleteQuestionById(@PathVariable Long id) {
        return deleteService.deleteQuestionById(id);
    }
}

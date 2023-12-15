package com.learn.question.controller.update;

import com.learn.model.Question;
import com.learn.question.service.update.UpdateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/question")
public class UpdateImplementation implements UpdateInterface{

    @Autowired
    private UpdateService updateService;

    @Override
    @PutMapping("/update/{id}")
    public ResponseEntity<HttpStatus> updateQuestion(@RequestBody Question newQuestion, @PathVariable Long id) {
        return updateService.updateQuestion(newQuestion,id);
    }
}

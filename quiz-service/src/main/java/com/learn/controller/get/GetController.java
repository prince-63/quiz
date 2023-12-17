package com.learn.controller.get;

import com.learn.model.QuestionWrapper;
import com.learn.service.get.GetService;
import com.learn.service.post.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/quiz")
public class GetController {
    @Autowired
    private GetService getService;

    @PostMapping("/{id}")
    public ResponseEntity<List<QuestionWrapper>> getQuestionById(@PathVariable Long id) {
        return getService.getQuestionById(id);
    }
}

package com.learn.controller.post;

import com.learn.model.Quiz;
import com.learn.model.Response;
import com.learn.service.get.GetService;
import com.learn.service.post.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("quiz")
public class PostController {

    @Autowired
    private PostService postService;

    @PostMapping("/create")
    public ResponseEntity<Quiz> createQuiz(@RequestParam String title, @RequestParam String category) {
        return postService.createQuiz(title, category);
    }

    @PostMapping("/submit")
    public ResponseEntity<Integer> submitQuiz(@RequestBody List<Response> response) {
        return postService.submitQuiz(response);
    }
}

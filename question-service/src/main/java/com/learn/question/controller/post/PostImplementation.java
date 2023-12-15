package com.learn.question.controller.post;

import com.learn.model.Question;
import com.learn.question.service.post.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/question")
public class PostImplementation implements PostInterface{

    @Autowired
    private PostService postService;

    @Override
    @PostMapping("/all/save")
    public ResponseEntity<HttpStatus> postAllQuestion(@RequestBody List<Question> questions) {
        return postService.postAllQuestion(questions);
    }

    @Override
    @PostMapping("/save")
    public ResponseEntity<HttpStatus> postOneQuestion(@RequestBody Question question) {
        return postService.postOneQuestion(question);
    }
}

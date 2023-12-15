package com.learn.question.service.post;

import com.learn.model.Question;
import com.learn.question.repo.QuestionRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostService {

    @Autowired
    private QuestionRepo questionRepo;

    public ResponseEntity<HttpStatus> postAllQuestion(List<Question> questions) {
        try {
            questionRepo.saveAll(questions);
            return new ResponseEntity<>(HttpStatus.CREATED);
        }
        catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    public ResponseEntity<HttpStatus> postOneQuestion(Question question) {
        try {
            questionRepo.save(question);
            return new ResponseEntity<>(HttpStatus.CREATED);
        }
        catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
}

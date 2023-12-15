package com.learn.question.service.get;

import com.learn.model.Question;
import com.learn.question.repo.QuestionRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GetService {

    @Autowired
    private QuestionRepo questionRepo;

    public ResponseEntity<List<Question>> getAllQuestion() {
        try {
            List<Question> questionList = questionRepo.findAll();
            return new ResponseEntity<>(questionList,HttpStatus.OK);
        }
        catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    public ResponseEntity<Question> getQuestionById(Long id) {
        try {
            Question question = questionRepo.findById(id).orElse(null);
            return new ResponseEntity<>(question,HttpStatus.OK);
        }
        catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
}

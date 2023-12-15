package com.learn.quiz.service.get;

import com.learn.model.Question;
import com.learn.quiz.repo.QuizRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class QuizGetService {

    @Autowired
    private QuizRepo quizRepo;

    public ResponseEntity<List<Long>> findByCategory(String category) {
        try {
            List<Long> questionIds = new ArrayList<>();
            List<Question> questionList = quizRepo.findByCategory(category);
            for(Question question : questionList) {
                questionIds.add(question.getId());
            }
            return new ResponseEntity<>(questionIds, HttpStatus.OK);
        }
        catch (Exception e) {
            return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
        }
    }
}

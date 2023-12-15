package com.learn.question.service.update;

import com.learn.model.Question;
import com.learn.question.repo.QuestionRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class UpdateService {

    @Autowired
    private QuestionRepo questionRepo;

    public ResponseEntity<HttpStatus> updateQuestion(Question newQuestion, Long id) {
        try {
            Question oldQuestion = questionRepo.findById(id).orElse(null);
            if (oldQuestion != null) {
                oldQuestion.setName(oldQuestion.getName().equals(newQuestion.getName()) ? oldQuestion.getName() : newQuestion.getName());
                oldQuestion.setOption1(oldQuestion.getOption1().equals(newQuestion.getOption1()) ? oldQuestion.getOption1() : newQuestion.getOption1());
                oldQuestion.setOption2(oldQuestion.getOption2().equals(newQuestion.getOption2()) ? oldQuestion.getOption2() : newQuestion.getOption2());
                oldQuestion.setOption3(oldQuestion.getOption3().equals(newQuestion.getOption3()) ? oldQuestion.getOption3() : newQuestion.getOption3());
                oldQuestion.setOption4(oldQuestion.getOption4().equals(newQuestion.getOption4()) ? oldQuestion.getOption4() : newQuestion.getOption4());
                oldQuestion.setResult(oldQuestion.getResult().equals(newQuestion.getResult()) ? oldQuestion.getResult() : newQuestion.getResult());
                oldQuestion.setCategory(oldQuestion.getCategory().equals(newQuestion.getCategory()) ? oldQuestion.getCategory() : newQuestion.getCategory());
                Question response = questionRepo.save(oldQuestion);
                return new ResponseEntity<>(HttpStatus.OK);
            } else {
                return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }
}

package com.learn.service.post;

import com.learn.config.QuizInterface;
import com.learn.model.QuestionWrapper;
import com.learn.model.Quiz;
import com.learn.model.Response;
import com.learn.repo.QuizRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class PostService {

    @Autowired
    private QuizRepository quizRepository;

    @Autowired
    private QuizInterface quizInterface;

    public ResponseEntity<Quiz> createQuiz(String title, String category) {
        try {
            List<Long> questionIds = quizInterface.getQuestionForQuiz(category).getBody();
            Quiz quiz = new Quiz();
            quiz.setTitle(title);
            quiz.setCategory(category);
            assert questionIds != null;
            quiz.getQuestionId().addAll(questionIds);
            quizRepository.save(quiz);
            return new ResponseEntity<>(quiz, HttpStatus.CREATED);
        }
        catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

    public ResponseEntity<Integer> submitQuiz(List<Response> response) {
        try {
            Integer result = quizInterface.calculateResult(response).getBody();
            return new ResponseEntity<>(result, HttpStatus.OK);
        }
        catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }
}

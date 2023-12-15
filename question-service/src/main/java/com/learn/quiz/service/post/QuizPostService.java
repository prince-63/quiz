package com.learn.quiz.service.post;

import com.learn.model.Question;
import com.learn.model.QuestionWrapper;
import com.learn.model.Response;
import com.learn.quiz.repo.QuizRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class QuizPostService {

    @Autowired
    private QuizRepo quizRepo;

    public ResponseEntity<List<QuestionWrapper>> getQuizByQuestionId(List<Long> questionIds) {
        try {
            List<QuestionWrapper> questionWrappers = new ArrayList<>();
            for (Long id : questionIds) {
                Question question = quizRepo.findById(id).orElse(null);
                QuestionWrapper questionWrapper = new QuestionWrapper();
                assert question != null;
                questionWrapper.setQuestionName(question.getName());
                questionWrapper.setOption1(question.getOption1());
                questionWrapper.setOption2(question.getOption2());
                questionWrapper.setOption3(question.getOption3());
                questionWrapper.setOption4(question.getOption4());
                questionWrapper.setId(question.getId());
                questionWrappers.add(questionWrapper);
            }
            return new ResponseEntity<>(questionWrappers, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(null, HttpStatus.BAD_GATEWAY);
        }
    }

    public ResponseEntity<Integer> calculateResult(List<Response> responses) {
        try {
            Integer result = 0;
            for (Response response : responses) {
                Question question = quizRepo.findById(response.getId()).orElse(null);
                assert question != null;
                if (question.getResult().equals(response.getResponse())) {
                    result++;
                }
            }
            return new ResponseEntity<>(result, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(null, HttpStatus.BAD_GATEWAY);
        }
    }
}

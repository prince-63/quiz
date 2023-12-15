package com.learn.quiz.repo;

import com.learn.model.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuizRepo extends JpaRepository<Question, Long> {
    List<Question> findByCategory(String category);
}

package com.quizapp.repository;

import com.quizapp.model.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface QuestionRepository  extends JpaRepository<Question, Integer> {

    /** custom method for the find question based on category **/
    public List<Question> findByCategory(String category);

    /** this custom method to find random question by category for test **/
    @Query(value = "SELECT * FROM quizz_table q where q.category=:category ORDER BY RANDOM() LIMIT :numQ",nativeQuery = true)
    List<Question> findRandomQuestionsByCategory(String category, int numQ);
}

package com.quizapp.service;


import com.quizapp.model.Question;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;


public interface QuestionService {

    public ResponseEntity<List<Question>> getAllQuestions();

   ResponseEntity<List<Question>> getQuestionsByCategory(String category);

    public  ResponseEntity<Question> saveNewQuestion(Question question);
}

package com.quizapp.service;

import com.quizapp.DTO.QuestionDTO;
import com.quizapp.model.Quiz;
import com.quizapp.quizResponse.QuizResponse;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface QuizService {

    /** this methosd is for create quiz**/
    ResponseEntity<Quiz> createQuiz(String category, int numQ, String title);

    /**  this method is to get the quiz questions**/
    ResponseEntity<List<QuestionDTO>> getQuizQuestions(Integer id);

    /** this methos is used to map the quiz response to orignal answer store in database **/
    ResponseEntity<Integer> calculateResult(Integer id, List<QuizResponse> quizResponse);
}

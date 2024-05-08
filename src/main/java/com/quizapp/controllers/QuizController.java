package com.quizapp.controllers;


import com.quizapp.DTO.QuestionDTO;
import com.quizapp.model.Quiz;
import com.quizapp.quizResponse.QuizResponse;
import com.quizapp.service.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/quiz")
public class QuizController {


    @Autowired
    private QuizService quizService;

    /**  here we create quiz  **/
    @PostMapping("/create")
    public ResponseEntity<Quiz> cretaeQuiz(@RequestParam String category, @RequestParam int numQ, @RequestParam String title){
     return quizService.createQuiz(category,numQ,title) ;

    }

    /** here we get quiz questions by quiz id **/
    @GetMapping("/get/{id}")
    public ResponseEntity<List<QuestionDTO>> getQuizQuestions(@PathVariable Integer id){
       return quizService.getQuizQuestions(id);

    }


    /** here we submit response of quiz questions **/
    @PostMapping("/submit/{id}")
    public ResponseEntity<Integer> submitQuiz(@PathVariable Integer id, @RequestBody List<QuizResponse> quizResponse){

        return quizService.calculateResult(id,quizResponse);

    }

}

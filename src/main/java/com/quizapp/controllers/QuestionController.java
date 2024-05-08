package com.quizapp.controllers;

import com.quizapp.model.Question;
import com.quizapp.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/question")
public class QuestionController {

    @Autowired
    private QuestionService questionService;


    @GetMapping("/allQuestions")
    public ResponseEntity<List<Question>> getAllQuestions(){
        return questionService.getAllQuestions();
    }


    @GetMapping("/category/{category}")
    public ResponseEntity<List<Question>> getQuestionsByCategories(@PathVariable String category ){

      return questionService.getQuestionsByCategory(category);
    }


    @PostMapping("/addQuestion")
    public ResponseEntity<Question> saveNewQuestion(@RequestBody Question question){
        return questionService.saveNewQuestion(question);
    }


}

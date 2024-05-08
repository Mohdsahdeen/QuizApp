package com.quizapp.service;

import com.quizapp.model.Question;
import com.quizapp.repository.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class QuestionsServiceImpl  implements QuestionService{

    /**  here we autowired the questionRepository**/
    @Autowired
    private QuestionRepository questionRepository;

    /** this method are the implementation of the get all questions interface **/
    @Override
    public ResponseEntity<List<Question>> getAllQuestions() {
        try{
            return new ResponseEntity<>(questionRepository.findAll(), HttpStatus.OK);
        }catch (Exception e){
            e.printStackTrace();
        }
        return new ResponseEntity<>(new ArrayList<>(), HttpStatus.BAD_REQUEST);

    }
     /**  this method are the implementation for the  getQuestion by the category**/
    @Override
    public ResponseEntity<List<Question>> getQuestionsByCategory(String category) {

        try{
            return new ResponseEntity<>(questionRepository.findByCategory(category),HttpStatus.OK);
        }catch (Exception e){
            e.printStackTrace();
        }
        return new ResponseEntity<>(new ArrayList<>(),HttpStatus.BAD_REQUEST);
    }

    /** this method are the implementation for to create new questions **/
    @Override
    public ResponseEntity<Question> saveNewQuestion(Question question) {
        try{
            return  new ResponseEntity<>(questionRepository.save(question), HttpStatus.CREATED);
        }catch (Exception e){
            e.printStackTrace();
        }
        return  new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }


}

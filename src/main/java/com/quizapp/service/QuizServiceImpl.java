package com.quizapp.service;


import com.quizapp.DTO.QuestionDTO;
import com.quizapp.model.Question;
import com.quizapp.model.Quiz;
import com.quizapp.quizResponse.QuizResponse;
import com.quizapp.repository.QuestionRepository;
import com.quizapp.repository.QuizRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class QuizServiceImpl implements QuizService {


    /** here we autowired the quizRepository**/
    @Autowired
    private QuizRepository quizRepository;

    /** here we autowired the questions repository**/
    @Autowired
   private  QuestionRepository questionRepository;

    /** this method are the implementation for the  creating quiz**/
    @Override
    public ResponseEntity<Quiz> createQuiz(String category, int numQ, String title) {
        List<Question> questions = questionRepository.findRandomQuestionsByCategory(category, numQ);

        Quiz quiz = new Quiz();
        quiz.setTitle(title);
        quiz.setQuestions(questions);
        quizRepository.save(quiz);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }


    /** this method are implementation for the get quiz questions**/
    @Override
    public ResponseEntity<List<QuestionDTO>> getQuizQuestions(Integer id) {
        Optional<Quiz> quiz = quizRepository.findById(id);
        List<Question> questionsFromDB = quiz.get().getQuestions();
        List<QuestionDTO> questionForUser = new ArrayList<>();
        for(Question q : questionsFromDB){
            QuestionDTO qd = new QuestionDTO(q.getId(), q.getQuestionTitle(),q.getOption1(),q.getOption2(),q.getOption3(),q.getOption4());
            questionForUser.add(qd);
        }

        return new ResponseEntity<>(questionForUser,HttpStatus.OK);
    }

    /** this method are the implementation for the calculate result which  map the response to original answer **/
    @Override
    public ResponseEntity<Integer> calculateResult(Integer id, List<QuizResponse> quizResponse) {
        Quiz quiz = quizRepository.findById(id).get();
        List<Question> quizQuestions = quiz.getQuestions();

        int right = 0;
        int i=0;
        for(QuizResponse response : quizResponse ){
            if(response.getQuizResponse().equals(quizQuestions.get(i).getRightAnswer()))
               right++;

            i++;
        }

        return new ResponseEntity<>(right,HttpStatus.OK);
    }
}

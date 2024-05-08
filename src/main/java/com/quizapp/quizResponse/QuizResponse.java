package com.quizapp.quizResponse;


import lombok.Data;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Data
@Setter
@Getter
@RequiredArgsConstructor
/** this class is made for the quiz response parameter  **/
public class QuizResponse {

    private Integer id;

    private String quizResponse;
}

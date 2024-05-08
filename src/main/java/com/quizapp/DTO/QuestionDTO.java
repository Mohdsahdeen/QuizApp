package com.quizapp.DTO;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;


@Data
@Getter
@Setter

/** this class is made for the question dto by which we provide question to users with question id, and questions options only **/
public class QuestionDTO {

    private  int id;

    private String questionTitle;

    private String option1;

    private String option2;


    private String option3;

    private String option4;

    public QuestionDTO(int id, String questionTitle, String option1, String option2, String option3, String option4) {
        this.id = id;
        this.questionTitle = questionTitle;
        this.option1 = option1;
        this.option2 = option2;
        this.option3 = option3;
        this.option4 = option4;
    }
}

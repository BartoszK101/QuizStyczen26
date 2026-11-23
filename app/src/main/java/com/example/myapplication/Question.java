package com.example.myapplication;

public class Question {

    private int image;
    private String question;
    private String answer1;
    private String answer2;
    private String answer3;
    private int correctAnswer;

    public Question(
            int image,
            String question,
            String answer1,
            String answer2,
            String answer3,
            int correctAnswer
    ) {
        this.image = image;
        this.question = question;
        this.answer1 = answer1;
        this.answer2 = answer2;
        this.answer3 = answer3;
        this.correctAnswer = correctAnswer;
    }

    public int getImage() {
        return image;
    }

    public String getQuestion() {
        return question;
    }

    public String getAnswer1() {
        return answer1;
    }

    public String getAnswer2() {
        return answer2;
    }

    public String getAnswer3() {
        return answer3;
    }

    public int getCorrectAnswer() {
        return correctAnswer;
    }
}

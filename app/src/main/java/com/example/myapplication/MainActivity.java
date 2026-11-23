package com.example.myapplication;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ImageView imageQuestion;
    TextView textQuestion;
    RadioGroup radioGroup;
    RadioButton radioAnswer1;
    RadioButton radioAnswer2;
    RadioButton radioAnswer3;
    Button buttonNext;

    ArrayList<Question> questions = new ArrayList<>();

    int currentQuestion = 0;
    int points = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageQuestion = findViewById(R.id.imageQuestion);
        textQuestion = findViewById(R.id.textQuestion);
        radioGroup = findViewById(R.id.radioGroup);
        radioAnswer1 = findViewById(R.id.radioAnswer1);
        radioAnswer2 = findViewById(R.id.radioAnswer2);
        radioAnswer3 = findViewById(R.id.radioAnswer3);
        buttonNext = findViewById(R.id.buttonNext);

        createQuestions();
        showQuestion();

        buttonNext.setOnClickListener(v -> nextQuestion());
    }

    private void createQuestions() {

        questions.add(new Question(
                R.drawable.zad1,
                "Które to schronisko?",
                "Na Rysiance.",
                "Na Wielkiej Raczy.",
                "Na Wielkiej Rycerzowej.",
                1
        ));

        questions.add(new Question(
                R.drawable.zad2,
                "Pytanie 2",
                "Odpowiedź 1",
                "Odpowiedź 2",
                "Odpowiedź 3",
                1
        ));

        questions.add(new Question(
                R.drawable.zad3,
                "Pytanie 3",
                "Odpowiedź 1",
                "Odpowiedź 2",
                "Odpowiedź 3",
                1
        ));
    }

    private void showQuestion() {

        Question question = questions.get(currentQuestion);

        textQuestion.setText(question.getQuestion());

        radioAnswer1.setText(question.getAnswer1());
        radioAnswer2.setText(question.getAnswer2());
        radioAnswer3.setText(question.getAnswer3());

        radioGroup.clearCheck();

        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inSampleSize = 2;

        Bitmap bitmap = BitmapFactory.decodeResource(
                getResources(),
                question.getImage(),
                options
        );

        imageQuestion.setImageBitmap(bitmap);
    }

    private void nextQuestion() {

        int selectedId = radioGroup.getCheckedRadioButtonId();

        if (selectedId == -1) {
            return;
        }

        int selectedAnswer = 0;

        if (selectedId == R.id.radioAnswer1) {
            selectedAnswer = 1;
        } else if (selectedId == R.id.radioAnswer2) {
            selectedAnswer = 2;
        } else if (selectedId == R.id.radioAnswer3) {
            selectedAnswer = 3;
        }

        if (selectedAnswer == questions.get(currentQuestion).getCorrectAnswer()) {
            points++;
        }

        currentQuestion++;

        if (currentQuestion >= questions.size()) {
            currentQuestion = 0;
        }

        showQuestion();
    }
}

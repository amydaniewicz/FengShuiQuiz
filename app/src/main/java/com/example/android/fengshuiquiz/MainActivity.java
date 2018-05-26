package com.example.android.fengshuiquiz;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

/**
 * This app displays an educational quiz covering feng shui principles.
 */
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * This method is called when the submit button is clicked.
     */
    public void submitQuiz(View view) {
        String studentName = getStudentName();
        int score = calculateScore();
        String toastMessage = createToastMessage(studentName, score);
        /** make toast */
        Toast.makeText(this, toastMessage, Toast.LENGTH_SHORT).show();
    }

    /**
     * This method gets the student's name entered into the app.
     */
    private String getStudentName() {
        EditText studentNameView = (EditText) findViewById(R.id.student_name);
        String studentName = studentNameView.getText().toString();
        return studentName;
    }

    /**
     * Calculates the student's score.
     * <p>
     * Correct answers are 1) b, 2) b/d, 3) energy, 4) a, 5) c, 6) b, 7) a, 8) c
     *
     * @return final score
     */
    private int calculateScore() {
        int score = 0;

        if (getQuestionOne()) {
            score += 1;
        }
        if (getQuestionTwo()) {
            score += 1;
        }
        if (getQuestionThree()) {
            score += 1;
        }
        if (getQuestionFour()) {
            score += 1;
        }
        if (getQuestionFive()) {
            score += 1;
        }
        if (getQuestionSix()) {
            score += 1;
        }
        if (getQuestionSeven()) {
            score += 1;
        }
        if (getQuestionEight()) {
            score += 1;
        }
        return score;
    }

    /**
     * This method determines if question one is correct.
     */
    private boolean getQuestionOne() {
        RadioButton questionOneAnswer = (RadioButton) findViewById(R.id.question_one_b);
        boolean isCorrect = questionOneAnswer.isChecked();
        return isCorrect;
    }

    /**
     * This method determines if question two is correct.
     */
    private boolean getQuestionTwo() {
        boolean isCorrect = false;
        CheckBox questionTwoACheckBox = (CheckBox) findViewById(R.id.question_two_a);
        boolean questionTwoA = questionTwoACheckBox.isChecked();
        CheckBox questionTwoBCheckBox = (CheckBox) findViewById(R.id.question_two_b);
        boolean questionTwoB = questionTwoBCheckBox.isChecked();
        CheckBox questionTwoCCheckBox = (CheckBox) findViewById(R.id.question_two_c);
        boolean questionTwoC = questionTwoCCheckBox.isChecked();
        CheckBox questionTwoDCheckBox = (CheckBox) findViewById(R.id.question_two_d);
        boolean questionTwoD = questionTwoDCheckBox.isChecked();
        if (questionTwoB && questionTwoD && !questionTwoA && !questionTwoC) {
            isCorrect = true;
        }
        return isCorrect;
    }

    /**
     * This method determines if question three is correct.
     */
    private boolean getQuestionThree() {
        EditText questionThreeAnswer = (EditText) findViewById(R.id.question_three_response);
        String questionThreeAnswerString = questionThreeAnswer.getText().toString();
        boolean isCorrect = false;
        if (questionThreeAnswerString.equalsIgnoreCase("energy")) {
            isCorrect = true;
        }
        return isCorrect;
    }

    /**
     * This method determines if question four is correct.
     */
    private boolean getQuestionFour() {
        RadioButton questionFourAnswer = (RadioButton) findViewById(R.id.question_four_a);
        boolean isCorrect = questionFourAnswer.isChecked();
        return isCorrect;
    }

    /**
     * This method determines if question five is correct.
     */
    private boolean getQuestionFive() {
        RadioButton questionFiveAnswer = (RadioButton) findViewById(R.id.question_five_c);
        boolean isCorrect = questionFiveAnswer.isChecked();
        return isCorrect;
    }

    /**
     * This method determines if question six is correct.
     */
    private boolean getQuestionSix() {
        RadioButton questionSixAnswer = (RadioButton) findViewById(R.id.question_six_b);
        boolean isCorrect = questionSixAnswer.isChecked();
        return isCorrect;
    }

    /**
     * This method determines if question seven is correct.
     */
    private boolean getQuestionSeven() {
        RadioButton questionSevenAnswer = (RadioButton) findViewById(R.id.question_seven_a);
        boolean isCorrect = questionSevenAnswer.isChecked();
        return isCorrect;
    }

    /**
     * This method determines if question eight is correct.
     */
    private boolean getQuestionEight() {
        RadioButton questionEightAnswer = (RadioButton) findViewById(R.id.question_eight_c);
        boolean isCorrect = questionEightAnswer.isChecked();
        return isCorrect;
    }

    /**
     * This method creates the content of the toast.
     *
     * @param studentName is the student's name
     * @param score       is the student's score
     */

    private String createToastMessage(String studentName, int score) {
        String scoreString = String.valueOf(score);
        String toastMessage = null;
        if (score < 4) {
            toastMessage = studentName + ", you answered " + scoreString + " out of 8 questions correctly. Seek the guidance of a feng shui master.";
        } else if (score < 8) {
            toastMessage = studentName + ", you answered " + scoreString + " out of 8 questions correctly. You have made great progress in your studies; keep up the good work.";
        } else {
            toastMessage = studentName + ", you answered " + scoreString + " out of 8 questions correctly. You are a feng shui master!";
        }
        return toastMessage;
    }

}

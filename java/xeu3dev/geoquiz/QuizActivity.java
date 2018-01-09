package xeu3dev.geoquiz;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

public class QuizActivity extends AppCompatActivity {


    private Button TrueButton;
    private Button FalseButton;
    private ImageButton PrevButton;
    private ImageButton NextButton;
    private TextView QuestionTextView;

    // Массив Question
    private Question [] QuestionBank = new Question[]{
            new Question(R.string.question_australia, true),
            new Question(R.string.question_oceans, true),
            new Question(R.string.question_mideast, false),
            new Question(R.string.question_africa,false),
            new Question(R.string.question_americas, true),
            new Question(R.string.question_asia, true),
    };

    private int CurrentIndex = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        // Подключение виджета TextView
        QuestionTextView = (TextView) findViewById(R.id.question_text_view);
        QuestionTextView.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick (View v) {
                CurrentIndex = (CurrentIndex + 1 ) % QuestionBank.length;
                updateQuestion();
            }
        });

        // Получение ссылок на виджеты
        TrueButton = (Button) findViewById(R.id.true_button);
        // Назначение слушателя для кнопки
        TrueButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public  void onClick(View v) {
        // Создание уведомлений
                checkAnswer(true);
            }
        });
        FalseButton = (Button) findViewById(R.id.false_button);
        FalseButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick (View v) {
                checkAnswer(false);
            }
        });
        // Подключение кноки Prev
        PrevButton = (ImageButton) findViewById(R.id.prev_button);
        PrevButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick (View v) {
                CurrentIndex = (CurrentIndex - 1 + QuestionBank.length) % QuestionBank.length;
                updateQuestion();
            }
        });
        // Подключение кнопки Next
        NextButton = (ImageButton) findViewById(R.id.next_button);
        NextButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick (View v) {
                CurrentIndex = (CurrentIndex + 1) % QuestionBank.length;
                updateQuestion();
            }
        });
        updateQuestion();
    }

    //Инкапсуляция в методе
    private void updateQuestion() {
        int question = QuestionBank[CurrentIndex].getTextResId();
        QuestionTextView.setText(question);
    }
     // Добавление метода checkAnswer
    private void checkAnswer (boolean userPressedTrue) {
        boolean answerIsTrue = QuestionBank[CurrentIndex].isAnswerTrue();
        int messageResId = 0;
        if (userPressedTrue == answerIsTrue) {
            messageResId = R.string.correct_toast;
        } else {
            messageResId = R.string.incorrect_toast;
        }
        Toast.makeText(this, messageResId, Toast.LENGTH_SHORT).show();
    }
}

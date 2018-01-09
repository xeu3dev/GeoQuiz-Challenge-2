package xeu3dev.geoquiz;


public class Question {
    private int TextResId;
    private boolean AnswerTrue;

    public Question (int textResId, boolean answerTrue) {
        TextResId = textResId;
        AnswerTrue = answerTrue;
    }

    public int getTextResId() {
        return TextResId;
    }

    public boolean isAnswerTrue() {
        return AnswerTrue;
    }

    public void setTextResId(int textResId) {
        TextResId = textResId;
    }

    public void setAnswerTrue(boolean answerTrue) {
        AnswerTrue = answerTrue;
    }

}

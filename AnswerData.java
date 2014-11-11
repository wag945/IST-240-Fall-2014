/*
 * @Course: IST 240 (FA 14)
 * @Section: 001
 *
 * @Group 08
 */
public class AnswerData {

    int questionId;
    String category;
    String question;
    String answer1, answer2, answer3;
    int correctAnswer;

    public AnswerData(int id,
            String theCategory,
            String theQuestion,
            String theAnswer1,
            String theAnswer2,
            String theAnswer3,
            int theCorrectAnswer) {
        setQuestionId(id);
        setCategory(theCategory);
        setQuestion(theQuestion);
        setAnswer1(theAnswer1);
        setAnswer2(theAnswer2);
        setAnswer3(theAnswer3);
        setCorrectAnswer(theCorrectAnswer);
    }

    int getQuestionId() {
        return questionId;
    }

    void setQuestionId(int id) {
        questionId = id;
    }

    String getCategory() {
        return category;
    }

    void setCategory(String theCategory) {
        category = theCategory;
    }

    String getQuestion() {
        return question;
    }

    void setQuestion(String theQuestion) {
        question = theQuestion;
    }

    String getAnswer1() {
        return answer1;
    }

    void setAnswer1(String theAnswer) {
        answer1 = theAnswer;
    }

    String getAnswer2() {
        return answer2;
    }

    void setAnswer2(String theAnswer) {
        answer2 = theAnswer;
    }

    String getAnswer3() {
        return answer3;
    }

    void setAnswer3(String theAnswer) {
        answer3 = theAnswer;
    }

    int getCorrectAnswer() {
        return correctAnswer;
    }

    void setCorrectAnswer(int theCorrectAnswer) {
        correctAnswer = theCorrectAnswer;
    }
}

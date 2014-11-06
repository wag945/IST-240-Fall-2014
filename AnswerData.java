/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Bill
 */
public class AnswerData {
    
    int questionId;
    String category;
    String question;
    String answer1,answer2,answer3;
    int correctAnswer;
    
    public AnswerData(  int id,
                        String theCategory,
                        String theQuestion,
                        String theAnswer1,
                        String theAnswer2,
                        String theAnswer3,
                        int theCorrectAnswer)
    {
        questionId = id;
        category = theCategory;
        question = theQuestion;
        answer1 = theAnswer1;
        answer2 = theAnswer2;
        answer3 = theAnswer3;
        correctAnswer = theCorrectAnswer;
    }
    
    int getQuestionId()
    {
        return questionId;
    }
    
    void setQuestionId(int id)
    {
        questionId = id;
    }
    
    String getCategory()
    {
        return category;
    }
    
    void setCategory(String theCategory)
    {
        category = theCategory;
    }
    String getQuestion()
    {
        return question;
    }
    
    void setQuestion(String theQuestion)
    {
        question = theQuestion;
    }
    
    String getAnswer1()
    {
        return answer1;
    }
    
    void setAnswer1(String theAnswer)
    {
        answer1 = theAnswer;
    }
    
    String getAnswer2()
    {
        return answer2;
    }
    
    void setAnswer2(String theAnswer)
    {
        answer2 = theAnswer;
    }
    
    String getAnswer3()
    {
        return answer3;
    }
    
    void setAnswer3(String theAnswer)
    {
        answer3 = theAnswer;
    }
    
    int getCorrectAnswer()
    {
        return correctAnswer;
    }
    
    void setCorrectAnswer(int theCorrectAnswer)
    {
        correctAnswer = theCorrectAnswer;
    }
}

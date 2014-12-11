/*
 * @Course: IST 240 (FA 14)
 * @Section: 001
 *
 * @Group 08
 */

import java.awt.Color;
import java.awt.Font;
import javax.swing.JButton;

class AnswerButton extends JButton {
    QuestionFrame questionFrame;
    Boolean IsAnswerCorrect;
    myJFrame parentFrame;
    Answer answer;
    int answerDataId;
    AnswerData answerData;
    int difficulty;
    String difficultyStr;
    String buttonValue;

    AnswerButton(String label,myJFrame frame, Answer inputAnswer, int id, int Difficulty) 
    {
        super();
        parentFrame = frame;
        setOpaque(true);
        setBackground(parentFrame.getGameButtonColor().darker().darker());
        setFont(new Font("Dialog", 1, 20));
        this.setForeground(new Color(0, 205, 0, 255));
        buttonValue = label;
        setText(label);
        answer = inputAnswer;
        answerDataId = id;
        difficulty = Difficulty;
        switch(difficulty)
        {
            case 1:
                difficultyStr = "K12";
                break;
            case 2:
                difficultyStr = "Undergrad";
                break;
            case 3:
                difficultyStr = "Grad";
                break;
        }
        answerData = answer.getAnswerDataByQuestionId(difficultyStr, answerDataId);
    } 
    
    public void onButtonPressed()
    {
        //Display dialog with question
        displayQuestion();
        
        setEnabled(false);
    }
    
    public void displayQuestion()
    {
        questionFrame = new QuestionFrame(this,parentFrame,answerData);
        questionFrame.displayWindow();
    }
        
    public String getButtonValue()
    {
        return buttonValue;
    }
}

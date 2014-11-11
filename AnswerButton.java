/*
 * @Course: IST 240 (FA 14)
 * @Section: 001
 *
 * @Group 08
 */
import java.awt.Color;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JOptionPane;

class AnswerButton extends JButton {
    QuestionFrame questionFrame;
    Boolean IsAnswerCorrect;
    myJFrame parentFrame;
    Answer answer;
    int answerDataId;
    AnswerData answerData;
    int difficulty;
    String difficultyStr;

    AnswerButton(String label,myJFrame frame, Answer inputAnswer, int id, int Difficulty) 
    {
        super();
        setOpaque(true);
        setBackground(Color.DARK_GRAY);
        setFont(new Font("Dialog", 1, 20));
        this.setForeground(new Color(0, 205, 0, 255));
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
        System.out.println("Answer difficultyStr = "+difficultyStr);
        answerData = answer.getAnswerDataByQuestionId(difficultyStr, answerDataId);
        System.out.println("AnswerButton ");
        answer.printAnswerData(answerData);
    } 
    
    public void onButtonPressed()
    {
        //Display dialog with question
        displayQuestion();
        
        setEnabled(false);
    }
    
    public void displayQuestion()
    {
        questionFrame = new QuestionFrame(answerData);
        questionFrame.displayWindow();
    }
    
    public boolean isAnswerCorrect(String input)
    {
        boolean returnValue = false;
        if (answer.equals(input))
        {
            returnValue = true;
        }
        return returnValue;
    }
}

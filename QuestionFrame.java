/*
 * @Course: IST 240 (FA 14)
 * @Section: 001
 *
 * @Group 08
 */

import java.awt.*;
import javax.swing.*;
import static javax.swing.JFrame.EXIT_ON_CLOSE;

public class QuestionFrame extends JFrame
{
    QuestionWindow window;
    AnswerData answerData;
    
    public QuestionFrame (AnswerData data)
    {
        super("Question");
        answerData = data;
        //------------------------------------------------------
        // Create components
        window = new QuestionWindow(this,answerData);
        //------------------------------------------------------
        // Choose a Layout for JFrame and 
        // add Jpanel to JFrame according to layout    	
        getContentPane().setLayout(new BorderLayout());
        getContentPane().add(window,BorderLayout.CENTER);

        
        //------------------------------------------------------
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setBounds(400,200,400,400);
        setVisible(false);
    }
    
    public void displayWindow()
    {
        setVisible(true);
        window.displayWindow();
    }
    
    public void hideWindow(boolean answerCorrect)
    {
        setVisible(false);
    }
}

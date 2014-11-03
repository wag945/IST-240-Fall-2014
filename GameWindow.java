/*
 * @Course: IST 240 (FA 14)
 * @Section: 001
 *
 * @Group 08
 */
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.awt.Color;
import java.util.Arrays;

public class GameWindow extends JPanel implements ActionListener
{
    //Might want this to be variable based on the game difficulty
    CategoryButton[] categoryButtons = new CategoryButton[6];
    //Might want this to be variable based on the game difficulty
    AnswerButton[] answerButtons = new AnswerButton[30];
    String oneHundred,twoHundred,threeHundred,fourHundred,fiveHundred;
    int numberAvailableAnswers;
    
    public GameWindow()
    {
        super();
        setBackground(Color.DARK_GRAY);
        oneHundred = "$100";
        twoHundred = "$200";
        threeHundred = "$300";
        fourHundred = "$400";
        fiveHundred = "$500";
        numberAvailableAnswers = 30;
        
        setLayout(new GridLayout(6,6));
        
        createCategoryButtons();

        createAnswerButtons();

        addButtonsToPanel();
        
        setVisible(false);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("myJPanelstd actionPerformed ");
        numberAvailableAnswers -= 1;
        for (int i = 0; i < answerButtons.length; i++)
        {
            if (e.getSource() == answerButtons[i])
            {
                answerButtons[i].onButtonPressed();
            }
        }
        if (0 == numberAvailableAnswers)
        {
            //Complete the board and move to double jeopardy
        }
    }
    
    public void createAnswerButtons()
    {
        for (int i = 0; i < answerButtons.length; i++)
        {
            //Temp till we have questions read from XML
            if (i < 6)
            {
                answerButtons[i] = new AnswerButton(oneHundred,"What (type test to check)","test");
            }
            else if (i >= 6 && i < 12)
            {
                answerButtons[i] = new AnswerButton(twoHundred,"What (type test to check)","test");
            }
            else if (i >= 12 && i < 18)
            {
                answerButtons[i] = new AnswerButton(threeHundred,"What (type test to check)","test");
            }
            else if (i >= 18 && i < 24)
            {
                answerButtons[i] = new AnswerButton(fourHundred,"What (type test to check)","test");
            }
            else
            {
                answerButtons[i] = new AnswerButton(fiveHundred,"What (type test to check)","test");                
            }
            answerButtons[i].addActionListener(this);
        }
    }
    
    public void createCategoryButtons()
    {
        for (int i = 0; i < categoryButtons.length; i++)
        {
            //Temp till we have actual categories read from XML
            Integer iStr = i+1;
            categoryButtons[i] = new CategoryButton("Category"+iStr.toString());
        }
    }
    
    public void addButtonsToPanel()
    {
        for (int i = 0; i < categoryButtons.length; i++)
        {
            add(categoryButtons[i]);
        }
        
        for (int i = 0; i < answerButtons.length; i++)
        {
            add(answerButtons[i]);
        }
    }
}

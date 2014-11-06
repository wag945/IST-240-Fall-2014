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
    
    JLabel lPlayerName;
    JLabel lScore;
    String CurrentPlayer;
    int CurrentPlayerNum;
    
    myJFrame ParentFrame;
    
    //Settings
    int DifficultyLevel = 0;    
    PlayersList CurrentPlayers;    
    
    public GameWindow(myJFrame mjf, GameTimerWindow gtw)
    {
        super();
        ParentFrame = mjf;
        CurrentPlayers = ParentFrame.setupWindow.SelectedPlayers;
        DifficultyLevel = ParentFrame.setupWindow.DifficultyLevel;
        gtw.resetTimer();
        
        setBackground(Color.DARK_GRAY);
        oneHundred = "$100";
        twoHundred = "$200";
        threeHundred = "$300";
        fourHundred = "$400";
        fiveHundred = "$500";
        numberAvailableAnswers = 30;
        CurrentPlayerNum = 1;
        
        setLayout(new GridLayout(7,6));
        
        createLabels();
        
        createCategoryButtons();

        createAnswerButtons();

        addButtonsToPanel();
        
        setVisible(false);
        
        resetScores();
        
        setPlayerNameOnLabel(CurrentPlayerNum);
        
    }
    

    
    public void setPlayerNameOnLabel(int PlayerNumber)
    {
        for (Object obj: CurrentPlayers.toArray())
        {
            Person pCurrent = (Person)obj;
            if (pCurrent.getPlayer() == PlayerNumber)
            {            
                lPlayerName.setText(pCurrent.getName());
                lScore.setText(String.valueOf(pCurrent.getScore()));            }
        }
    }
    
    public void addScore(int Score)
    {        
        for (Object obj: CurrentPlayers.toArray())
        {
            Person pCurrent = (Person)obj;
            if (pCurrent.getPlayer() == CurrentPlayerNum)
            {            
                int oldScore = pCurrent.getScore();
                pCurrent.setScore(Score+oldScore);
            }
        }
    }
    
    @Override
    public void actionPerformed(ActionEvent e) 
    {
        System.out.println("myJPanelstd actionPerformed ");
        numberAvailableAnswers -= 1;
        for (int i = 0; i < answerButtons.length; i++)
        {
            if (e.getSource() == answerButtons[i])
            {
                answerButtons[i].onButtonPressed();
//                if (answerButtons[i].questionFrame.window.answerCorrect)
//                {
//                    addScore(Integer.parseInt(answerButtons[i].getText().replace("$", "")));
//                }
            }
        }
        if (0 == numberAvailableAnswers)
        {
            //Complete the board and move to double jeopardy
        }
    }
    
     public final void createLabels()
    {

        Font font = new Font(Font.SANS_SERIF, Font.BOLD, 14);      

        JLabel lTemp = new JLabel("Player Name: ");
        lTemp.setFont(font);
        lTemp.setForeground(Color.white);
        lTemp.setHorizontalAlignment(SwingConstants.RIGHT);
        add(lTemp);
        
        lPlayerName = new JLabel();
        lPlayerName.setForeground(Color.white);
        lPlayerName.setFont(font);
        add(lPlayerName);
               
        JLabel lTemp2 = new JLabel();
        add(lTemp2);
        
        JLabel lTemp3 = new JLabel();
        add(lTemp3);
        
        lTemp = new JLabel("Score: ");
        lTemp.setForeground(Color.white);
        lTemp.setHorizontalAlignment(SwingConstants.RIGHT);
        lTemp.setFont(font);
        add(lTemp);
        
        lScore = new JLabel();
        lScore.setForeground(Color.white);
        lScore.setFont(font);
        add(lScore);

            
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
            categoryButtons[i] = new CategoryButton("Category "+iStr.toString());
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

    private void resetScores() 
    {
        for (Object obj: CurrentPlayers.toArray())
        {
            Person pCurrent = (Person)obj;           
            pCurrent.setScore(0);
        }
    }
}

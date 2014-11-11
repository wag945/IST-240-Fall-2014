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
    Answer answer;
    
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
        
        answer = new Answer();
        
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
                lScore.setText(String.valueOf(pCurrent.getScore()));            
            }
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
        String label = "";
        int categoryOneIndex = 0;
        int categoryTwoIndex = 11;
        int categoryThreeIndex = 21;
        int categoryFourIndex = 31;
        int categoryFiveIndex = 41;
        int categorySixIndex = 0;
        for (int i = 0; i < answerButtons.length; i++)
        {
            //Temp till we have questions read from XML
            if (i < 6)
            {
                label = oneHundred;
            }
            else if (i >= 6 && i < 12)
            {
                label = twoHundred;
            }
            else if (i >= 12 && i < 18)
            {
                label = threeHundred;
            }
            else if (i >= 18 && i < 24)
            {
                label = fourHundred;
            }
            else
            {
                label = fiveHundred;
            }
            
            switch(i)
            {
                case 0:
                case 6:
                case 12:
                case 18:
                case 24:
                    answerButtons[i] = new AnswerButton(label,ParentFrame,answer,answer.k12Answers[categoryOneIndex].questionId,DifficultyLevel);
                    categoryOneIndex++;
                    break;
                case 1:
                case 7:
                case 13:
                case 19:
                case 25:
                    answerButtons[i] = new AnswerButton(label,ParentFrame,answer,answer.k12Answers[categoryTwoIndex].questionId,DifficultyLevel);
                    categoryTwoIndex++;
                    break;
                case 2:
                case 8:
                case 14:
                case 20:
                case 26:
                    answerButtons[i] = new AnswerButton(label,ParentFrame,answer,answer.k12Answers[categoryThreeIndex].questionId,DifficultyLevel);
                    categoryThreeIndex++;
                    break;
                case 3:
                case 9:
                case 15:
                case 21:
                case 27:
                    answerButtons[i] = new AnswerButton(label,ParentFrame,answer,answer.k12Answers[categoryFourIndex].questionId,DifficultyLevel);
                    categoryFourIndex++;
                    break;
                case 4:
                case 10:
                case 16:
                case 22:
                case 28:
                    answerButtons[i] = new AnswerButton(label,ParentFrame,answer,answer.k12Answers[categoryFiveIndex].questionId,DifficultyLevel);
                    categoryFiveIndex++;
                    break;
                case 5:
                case 11:
                case 17:
                case 23:
                case 29:
                    answerButtons[i] = new AnswerButton(label,ParentFrame,answer,answer.k12Answers[categorySixIndex].questionId,DifficultyLevel);
                    categorySixIndex++;
                    break;
            }
            answerButtons[i].addActionListener(this);
        }
    }
    
    public void createCategoryButtons()
    {
        for (int i = 0; i < categoryButtons.length; i++)
        {
            String title = answer.getCategoryNameById(i+1);
            categoryButtons[i] = new CategoryButton(title);
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

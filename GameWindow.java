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
import java.util.Date;

public class GameWindow extends JPanel implements ActionListener
{
    //Might want this to be variable based on the game difficulty
    CategoryButton[] categoryButtons = new CategoryButton[6];
    //Might want this to be variable based on the game difficulty
    AnswerButton[] answerButtons = new AnswerButton[30];
    String oneHundred,twoHundred,threeHundred,fourHundred,fiveHundred;
    int numberAvailableAnswers;
    
    JLabel lPlayerWon;
    JLabel lPlayerWonName;
    JLabel lPlayerName;
    JLabel lScore;
    String CurrentPlayer;
    JLabel lTemp1;
    JLabel lTemp2;
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
        numberAvailableAnswers = 5;
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
                lScore.setText(String.valueOf(pCurrent.getTScore()));            
            }
        }
    }
    
    public void UpdateLables()
    {          
        lPlayerName.setText("");
        lScore.setText("");
        
        int MaxScore=0;
        String Winner = "";
        for (Object obj: CurrentPlayers.toArray())
        {
            Person pCurrent = (Person)obj;
            if (pCurrent.getTScore() > MaxScore)
            {
                MaxScore = pCurrent.getTScore();
                Winner = pCurrent.getName();
            }
        }
        
        if (Winner.equals(""))
        {
            Winner = "No one ";
            lPlayerWon.setForeground(Color.red);
            lPlayerWonName.setForeground(Color.red);
        }
        
        lPlayerWonName.setText(Winner);
        
        
        lTemp1.setVisible(false);
        lTemp2.setVisible(false);
        
        lPlayerWon.setVisible(true);        
        lPlayerWonName.setVisible(true);
    }
    
    public void addScore(int Score)
    {    
        System.out.println("GameWindow addScore score = "+Score);
        
        if (Score < 0)
        {
            if (CurrentPlayerNum == CurrentPlayers.getSize())
            {
                CurrentPlayerNum=1;
            }
            else
            {
                CurrentPlayerNum++;
            }
       }
        //else
        //{
        for (Object obj: CurrentPlayers.toArray())
        {
            Person pCurrent = (Person)obj;
            if (pCurrent.getPlayer() == CurrentPlayerNum)
            {            
                int oldScore = pCurrent.getTScore();
                pCurrent.setTScore(Score+oldScore);
                if ((Score+oldScore) > pCurrent.getScore())
                {
                    pCurrent.setScore(Score+oldScore);
                }
            }
        }
        //}
        setPlayerNameOnLabel(CurrentPlayerNum);
        
        CheckIfGameIsEnding();
    }
    
    public void CheckIfGameIsEnding()
    {
         if (0 == numberAvailableAnswers)
        {
            //Update lables telling who won
            UpdateLables();

            //Update full player list
            UpdateAllPlayerList();
            
            ParentFrame.setupWindow.SaveDataInXML();
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
    
    public void UpdateAllPlayerList()
    {
        Date date = new Date();
        for (Object obj: CurrentPlayers.toArray())
        {
            Person pCurrent = (Person)obj;
            for (Object obj2: ParentFrame.setupWindow.ListOfAllPlayers.toArray())
            {
                Person pAll = (Person)obj2;
                if (pCurrent.getName().equals(pAll.getName()))
                {
                    if (pCurrent.getTScore() > pAll.getScore())
                    {
                        pAll.setScore(pCurrent.getTScore());
                    }
                    pAll.setTScore(pCurrent.getTScore());
                    pAll.setDateLastPlayed(date);
                    break;
                }
            }
        }
    }
    
    
    public final void createLabels()
    {

        Font font = new Font(Font.SANS_SERIF, Font.BOLD, 14);      

        lTemp1 = new JLabel("Player Name: ");
        lTemp1.setFont(font);
        lTemp1.setForeground(Color.white);
        lTemp1.setHorizontalAlignment(SwingConstants.RIGHT);
        add(lTemp1);
        
        lPlayerName = new JLabel();
        lPlayerName.setForeground(Color.white);
        lPlayerName.setFont(font);
        add(lPlayerName);
               
        lPlayerWonName = new JLabel();
        lPlayerWonName.setForeground(Color.green);
        lPlayerWonName.setVisible(false);
        lPlayerWonName.setHorizontalAlignment(SwingConstants.RIGHT);
        lPlayerWonName.setFont(font);
        add(lPlayerWonName);
        
        lPlayerWon = new JLabel(" Won!");        
        lPlayerWon.setForeground(Color.green);
        lPlayerWon.setVisible(false);
        lPlayerWon.setFont(font);
        add(lPlayerWon);
                
        lTemp2 = new JLabel("Score: ");
        lTemp2.setForeground(Color.white);
        lTemp2.setHorizontalAlignment(SwingConstants.RIGHT);
        lTemp2.setFont(font);
        add(lTemp2);
        
        lScore = new JLabel();
        lScore.setForeground(Color.white);
        lScore.setFont(font);
        add(lScore);

            
    }
    
    public void createAnswerButtons()
    {
        String label = "";
        int categoryOneIndex = answer.getRandomQuestionNumberForCategory(1);
        int categoryTwoIndex = answer.getRandomQuestionNumberForCategory(2);
        int categoryThreeIndex = answer.getRandomQuestionNumberForCategory(3);
        int categoryFourIndex = answer.getRandomQuestionNumberForCategory(4);
        int categoryFiveIndex = answer.getRandomQuestionNumberForCategory(5);
        int categorySixIndex = answer.getRandomQuestionNumberForCategory(6);
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
                    System.out.println("GameWindow categoryOneIndex = "+categoryOneIndex);
                    answerButtons[i] = new AnswerButton(label,ParentFrame,answer,answer.k12Answers[categoryOneIndex].questionId,DifficultyLevel);
                    categoryOneIndex++;
                    if (categoryOneIndex >= answer.getLastQuestionIdByCategoryId(1))
                    {
                        categoryOneIndex = answer.getFirstQuestionIdByCategoryId(1);
                    }
                    break;
                case 1:
                case 7:
                case 13:
                case 19:
                case 25:
                    answerButtons[i] = new AnswerButton(label,ParentFrame,answer,answer.k12Answers[categoryTwoIndex].questionId,DifficultyLevel);
                    categoryTwoIndex++;
                    if (categoryTwoIndex >= answer.getLastQuestionIdByCategoryId(2))
                    {
                        categoryTwoIndex = answer.getFirstQuestionIdByCategoryId(2);
                    }
                    break;
                case 2:
                case 8:
                case 14:
                case 20:
                case 26:
                    answerButtons[i] = new AnswerButton(label,ParentFrame,answer,answer.k12Answers[categoryThreeIndex].questionId,DifficultyLevel);
                    categoryThreeIndex++;
                    if (categoryThreeIndex >= answer.getLastQuestionIdByCategoryId(3))
                    {
                        categoryThreeIndex = answer.getFirstQuestionIdByCategoryId(3);
                    }
                    break;
                case 3:
                case 9:
                case 15:
                case 21:
                case 27:
                    answerButtons[i] = new AnswerButton(label,ParentFrame,answer,answer.k12Answers[categoryFourIndex].questionId,DifficultyLevel);
                    categoryFourIndex++;
                    if (categoryFourIndex >= answer.getLastQuestionIdByCategoryId(4))
                    {
                        categoryFourIndex = answer.getFirstQuestionIdByCategoryId(4);
                    }
                    break;
                case 4:
                case 10:
                case 16:
                case 22:
                case 28:
                    answerButtons[i] = new AnswerButton(label,ParentFrame,answer,answer.k12Answers[categoryFiveIndex].questionId,DifficultyLevel);
                    categoryFiveIndex++;
                    if (categoryFiveIndex >= answer.getLastQuestionIdByCategoryId(5))
                    {
                        categoryFiveIndex = answer.getFirstQuestionIdByCategoryId(5);
                    }
                    break;
                case 5:
                case 11:
                case 17:
                case 23:
                case 29:
                    answerButtons[i] = new AnswerButton(label,ParentFrame,answer,answer.k12Answers[categorySixIndex].questionId,DifficultyLevel);
                    categorySixIndex++;
                    System.out.println("GameWindow categorySixIndex = "+categorySixIndex);
                      if (categorySixIndex >= answer.getLastQuestionIdByCategoryId(6))
                    {
                        categorySixIndex = answer.getFirstQuestionIdByCategoryId(6);
                    }
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

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
import java.util.Date;

public class GameWindow extends JPanel implements ActionListener
{
    //Might want this to be variable based on the game difficulty
    CategoryButton[] categoryButtons = new CategoryButton[6];
    //Might want this to be variable based on the game difficulty
    AnswerButton[] answerButtons = new AnswerButton[30];
    String oneHundred,twoHundred,threeHundred,fourHundred,fiveHundred;
    int numberAvailableAnswers;
    
    int CurrentPlayerNum;
    boolean QuestionButtonsDisabled;
    
    myJFrame ParentFrame;
    Answer answer;
    
    //Settings
    int DifficultyLevel = 0;    
    PlayersList CurrentPlayers;    
    
    GameHeader gameHeader;
    
    @Override
    public void actionPerformed(ActionEvent e) 
    {
        String sClass = e.getSource().getClass().toString();
        if (sClass.equals("class AnimateNumbersTimer"))
        {
            int newScore;
            int cScore;
            AnimateNumbersTimer tAnimateScore = (AnimateNumbersTimer)e.getSource();
            
            if (!tAnimateScore.isIsStopping())
            {
            newScore = tAnimateScore.getNewScore();
            cScore = tAnimateScore.getCurrentScore();
                if (cScore == tAnimateScore.getNewScore())
                {
                    tAnimateScore.setIsStopping(true);
                    tAnimateScore.stop();                                        
                    setNextPlayer(tAnimateScore.isAnimatePlusOrMinus());
                    HighlightPlayer(CurrentPlayerNum);
                    CheckIfGameIsEnding();
                    ParentFrame.setEnabled(true);
                }
                else
                {        
                    if (tAnimateScore.isAnimatePlusOrMinus())
                    {
                        if (Integer.toString(cScore).endsWith("99")) ParentFrame.SoundPlayer.play("score_up.au");
                        cScore++;                    
                    }
                    else
                    {
                        if (Integer.toString(cScore).endsWith("99"))ParentFrame.SoundPlayer.play("score_down.au");
                        cScore--;
                    }
                    
                    if (Integer.toString(cScore).endsWith("0")) tAnimateScore.getLabelPScore().setText(String.format("%d",cScore));
                    
                    tAnimateScore.setCurrentScore(cScore);
                }
            }
        }
        else if (sClass.equals("class AnswerButton"))
        {
            if (!QuestionButtonsDisabled)
            {
                numberAvailableAnswers -= 1;
                for (int i = 0; i < answerButtons.length; i++)
                {
                    if (e.getSource() == answerButtons[i])
                    {
                        answerButtons[i].onButtonPressed();
                    }
                }
            }           
        }
    }
    
    public GameWindow(myJFrame mjf, GameTimerWindow gtw, GameHeader gh)
    {
        super();
        ParentFrame = mjf;
        gameHeader = gh;
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
        
        setLayout(new GridLayout(6,6));
                
        answer = new Answer();
        
        createCategoryButtons();

        createAnswerButtons();

        addButtonsToPanel();
        
        setVisible(false);
        
        resetScores();
        
        setHeaderLabels();
        
        setPlayerNameOnLabel(false);
        HighlightPlayer(CurrentPlayerNum);
    }
    

    
    public void setPlayerNameOnLabel(boolean AnimateScoreOnAdd)
    {
                
        for (Object obj: CurrentPlayers.toArray())
        {
            Person pCurrent = (Person)obj;
            int cScore = pCurrent.getTodaysTempScore();
            String cName = pCurrent.getName();
            int cPlayerNum = pCurrent.getPlayer();
            int ScoreOnHeader;
            
            switch (cPlayerNum)
            {
                case 1:
                    gameHeader.lP1.setText(cName);
                    ScoreOnHeader = Integer.parseInt(gameHeader.lPScore1.getText());
                    if (ScoreOnHeader!=cScore) AnimateScore(gameHeader.lPScore1, Integer.parseInt(gameHeader.lPScore1.getText()), cScore, AnimateScoreOnAdd);
                    
                    break;
                case 2:
                    gameHeader.lP2.setText(cName);
                    ScoreOnHeader = Integer.parseInt(gameHeader.lPScore2.getText());
                    if (ScoreOnHeader!=cScore) AnimateScore(gameHeader.lPScore2, Integer.parseInt(gameHeader.lPScore2.getText()), cScore, AnimateScoreOnAdd);
                    break;
                case 3:
                    gameHeader.lP3.setText(cName);
                    ScoreOnHeader = Integer.parseInt(gameHeader.lPScore3.getText());
                    if (ScoreOnHeader!=cScore) AnimateScore(gameHeader.lPScore3, Integer.parseInt(gameHeader.lPScore3.getText()), cScore, AnimateScoreOnAdd);
                    break;
            }
        }
    }
    
    public void HighlightPlayer(int PlayerNumber)
    {
        Font font = new Font(Font.SANS_SERIF, Font.PLAIN, 11);
        Font fontB = new Font(Font.SANS_SERIF, Font.BOLD, 12);
        
        int NumOfPlayers = CurrentPlayers.getSize();
        //Dim/unhighlight players
        switch (NumOfPlayers)
        {
            case 1:
                gameHeader.lP1.setFont(font);
                gameHeader.lP1.setForeground(Color.gray);
                gameHeader.lPScore1.setFont(font);
                gameHeader.lPScore1.setForeground(Color.gray);
                break;
            case 2:
                gameHeader.lP1.setFont(font);
                gameHeader.lP1.setForeground(Color.gray);
                gameHeader.lPScore1.setFont(font);
                gameHeader.lPScore1.setForeground(Color.gray);
                gameHeader.lP2.setFont(font);
                gameHeader.lP2.setForeground(Color.gray);
                gameHeader.lPScore2.setFont(font);
                gameHeader.lPScore2.setForeground(Color.gray);
                break;
            case 3:
                gameHeader.lP1.setFont(font);
                gameHeader.lP1.setForeground(Color.gray);
                gameHeader.lPScore1.setFont(font);
                gameHeader.lPScore1.setForeground(Color.gray);
                gameHeader.lP2.setFont(font);
                gameHeader.lP2.setForeground(Color.gray);
                gameHeader.lPScore2.setFont(font);
                gameHeader.lPScore2.setForeground(Color.gray);
                gameHeader.lP3.setFont(font);
                gameHeader.lP3.setForeground(Color.gray);
                gameHeader.lPScore3.setFont(font);
                gameHeader.lPScore3.setForeground(Color.gray);
                break;
        }
        
        //Hilight player
        for (Object obj: CurrentPlayers.toArray())
        {
            Person pCurrent = (Person)obj;
            int cPlayerNum = pCurrent.getPlayer();
            
            if (cPlayerNum == PlayerNumber)
            {
                switch (cPlayerNum)
                {
                    case 1:
                        gameHeader.lP1.setFont(fontB);
                        gameHeader.lP1.setForeground(Color.white);
                        gameHeader.lPScore1.setFont(fontB);                        
                        gameHeader.lPScore1.setForeground(Color.white);
                        break;
                    case 2:
                        gameHeader.lP2.setFont(fontB);
                        gameHeader.lP2.setForeground(Color.white);
                        gameHeader.lPScore2.setFont(fontB);
                        gameHeader.lPScore2.setForeground(Color.white);
                        break;
                    case 3:
                        gameHeader.lP3.setFont(fontB);
                        gameHeader.lP3.setForeground(Color.white);
                        gameHeader.lPScore3.setFont(fontB);
                        gameHeader.lPScore3.setForeground(Color.white);
                        break;
                }
                break;
            }
        }
    }
    
    public void UpdateLables()
    {                  
        int MaxScore=0;
        String Winner = "";
        for (Object obj: CurrentPlayers.toArray())
        {
            Person pCurrent = (Person)obj;
            if (pCurrent.getTodaysTempScore() > MaxScore)
            {
                MaxScore = pCurrent.getTodaysTempScore();
                Winner = pCurrent.getName();
            }
        }
        
        if (Winner.equals(""))
        {
            Winner = "No one ";
            gameHeader.lWinner.setForeground(Color.red);
        }
        
        gameHeader.lWinner.setText(Winner + " Won!");
        gameHeader.lWinner.setForeground(Color.green);
    }
    
    public void addScore(int Score)
    {    
        boolean AnimateScoreOnAdd = false;
        if (Score > 0 ) AnimateScoreOnAdd = true;
        
        //for testing!
        //if (Score < 0 ) Score=Score*-1;
        //AnimateScoreOnAdd = true;
        
        for (Object obj: CurrentPlayers.toArray())
        {
            Person pCurrent = (Person)obj;
            if (pCurrent.getPlayer() == CurrentPlayerNum)
            {            
                int oldScore = pCurrent.getTodaysTempScore();
                pCurrent.setTodaysTempScore(Score+oldScore);
            }
        }

        setPlayerNameOnLabel(AnimateScoreOnAdd);
    }
    
    public void setNextPlayer(boolean DontChangePlayer)
    {
        if (!DontChangePlayer)
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
    }
    
    public void CheckIfGameIsEnding()
    {
        if (0 == numberAvailableAnswers)
        {
            //9000 Perfect score
            
            //Update lables telling who won
            UpdateLables();

            //Update full player list
            UpdateAllPlayerList();
            
            ParentFrame.timerFrame.hideWindow();
            
            ParentFrame.setupWindow.SaveDataInXML();
        }
    }
    
    public void UpdateAllPlayerList()
    {
        for (Object obj: CurrentPlayers.toArray())
        {
            Person pCurrent = (Person)obj;
            for (Object obj2: ParentFrame.setupWindow.ListOfAllPlayers.toArray())
            {
                Person pAll = (Person)obj2;
                if (pCurrent.getName().equals(pAll.getName()))
                {
                    if (pCurrent.getTodaysTempScore() > pAll.getScore())
                    {
                        pAll.setScore(pCurrent.getTodaysTempScore());
                    }
                    pAll.setTScore(pCurrent.getTodaysTempScore());
                    pAll.setDateLastPlayed(new Date());
                    break;
                }
            }
        }
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
            pCurrent.setTodaysTempScore(0);
        }
    }

    private void setHeaderLabels() 
    {
        gameHeader.lWinner.setForeground(new Color(51,51,51));
        
        switch (DifficultyLevel)
        {
            case 1:
                gameHeader.lDifficultyLevel.setText("K12");
                break;
            case 2:
                gameHeader.lDifficultyLevel.setText("Under Grad");
                break;
            case 3:
                gameHeader.lDifficultyLevel.setText("Grad");
                break;
        }
        
        
        int TNumOfPlayers = CurrentPlayers.getSize();
        switch (TNumOfPlayers)
        {
            case 1:
                gameHeader.lP1.setVisible(true);
                gameHeader.lPScore1.setVisible(true);
                gameHeader.lP2.setVisible(false);
                gameHeader.lPScore2.setVisible(false);
                gameHeader.lP3.setVisible(false);
                gameHeader.lPScore3.setVisible(false);
                break;
            case 2:
                gameHeader.lP1.setVisible(true);
                gameHeader.lPScore1.setVisible(true);
                gameHeader.lP2.setVisible(true);
                gameHeader.lPScore2.setVisible(true);
                gameHeader.lP3.setVisible(false);
                gameHeader.lPScore3.setVisible(false);
                break;
            case 3:
                gameHeader.lP1.setVisible(true);
                gameHeader.lPScore1.setVisible(true);
                gameHeader.lP2.setVisible(true);
                gameHeader.lPScore2.setVisible(true);
                gameHeader.lP3.setVisible(true);
                gameHeader.lPScore3.setVisible(true);
                break;
        }
    }

    private void AnimateScore(JLabel lPScore, int currentScore,int newScore, boolean AnimateScoreOnAdd) 
    {
        AnimateNumbersTimer tAnimate = new AnimateNumbersTimer(10,this,lPScore,currentScore,newScore,AnimateScoreOnAdd);
        tAnimate.addActionListener(this);        
        tAnimate.start();
    }
}

/*
 * @Course: IST 240 (FA 14)
 * @Section: 001
 *
 * @Group 08
 */

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;

public class QuestionWindow extends JPanel implements ActionListener {

    JTextField timeTextField;
    JTextArea questionTextField;
    Timer timer;
    int timeLeft;
    Integer minutes,seconds;
    JButton doneButton;
    QuestionFrame parentFrame;
    JPanel centerPanel,answerPanel;
    ButtonGroup answerButtonGroup;
    JCheckBox answerButton1,answerButton2,answerButton3;
    boolean answerCorrect = false;
    AnswerData answerData;
    
    public QuestionWindow(QuestionFrame frame,AnswerData data)
    {
        super();
        setLayout(new BorderLayout());
        parentFrame = frame;
        answerData = data;
        System.out.println("QuestionWindow");
        System.out.println("question id = "+answerData.getQuestionId());
        System.out.println("question = "+answerData.getQuestion());
        System.out.println("answer1 = "+answerData.getAnswer1());
        System.out.println("answer2 = "+answerData.getAnswer2());
        setBackground(Color.BLUE);
        setVisible(true);
        timeLeft = 10;
        minutes = 0;
        seconds = 10;
        timeTextField = new JTextField("START");
        add(timeTextField,BorderLayout.NORTH);
        timer = new Timer(1000,this);
	Font font = new Font("SansSerif", Font.BOLD, 22);
	timeTextField.setFont(font);
	timeTextField.setHorizontalAlignment(JTextField.CENTER);
        centerPanel = new JPanel();
        centerPanel.setLayout(new BorderLayout());
        centerPanel.setBackground(Color.BLUE);
        add(centerPanel);
        Font questionFont = new Font("SansSerif",Font.BOLD,16);
        questionTextField = new JTextArea(2,25);
        questionTextField.setLineWrap(true);
        questionTextField.setWrapStyleWord(true);
        questionTextField.setText(answerData.getQuestion());
        questionTextField.setAutoscrolls(true);
        questionTextField.setFont(questionFont);
        centerPanel.add(questionTextField,BorderLayout.NORTH);
        answerPanel = new JPanel();
        answerPanel.setLayout(new GridLayout(3,1));
        answerPanel.setBackground(Color.BLUE);
        centerPanel.add(answerPanel,BorderLayout.CENTER);
        answerButtonGroup = new ButtonGroup();
        answerButton1 = new JCheckBox();
        answerButton1.setText(answerData.getAnswer1());
	Font answerFont = new Font("SansSerif", Font.BOLD, 18);
        answerButton1.setFont(answerFont);
        answerButtonGroup.add(answerButton1);
        answerButton2 = new JCheckBox();
        answerButton2.setText(answerData.getAnswer2());
        answerButton2.setFont(answerFont);
        answerButtonGroup.add(answerButton2);
        answerButton3 = new JCheckBox();
        answerButton3.setText(answerData.getAnswer3());
        answerButton3.setFont(answerFont);
        answerButtonGroup.add(answerButton3);
        answerPanel.add(answerButton1);
        answerPanel.add(answerButton2);
        answerPanel.add(answerButton3);
        doneButton = new JButton();
        doneButton.setText("Done");
        doneButton.addActionListener(this);
        add(doneButton,BorderLayout.SOUTH);
    }

    public void displayWindow()
    {
        //Disable the parent game window
        parentFrame.parentFrame.setEnabled(false);
        timer.start();
    }
    
    public void hideWindow()
    {
        //Enable the parent game window
        parentFrame.parentFrame.setEnabled(true);
        timer.stop();
        answerCorrect = isAnswerCorrect();
        System.out.println("answerCorrect = "+answerCorrect);
        updateScore(answerCorrect);
        parentFrame.hideWindow(answerCorrect);
    }
    
    public boolean isAnswerCorrect()
    {
        switch(answerData.getCorrectAnswer())
        {
            case 1:
                answerCorrect = answerButton1.isSelected();
                break;
            case 2:
                answerCorrect = answerButton2.isSelected();
                break;
            case 3:
                answerCorrect = answerButton3.isSelected();
                break;
        }
        return answerCorrect;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if (timer == e.getSource())
        {
            updateTime();
        }
        if (doneButton == e.getSource())
        {
            hideWindow();
        }
    }
    
    public void updateTime()
    {
        if (seconds == 0)
        {
            seconds = 59;
            minutes--;
            if (minutes >= 0)
            {
                timeTextField.setText(minutes.toString()+":"+seconds.toString());
            }
            else
            {
                timeTextField.setText("TIME'S UP!");
                AudioPlayer player = new AudioPlayer();
                player.play("timesup.wav");
                hideWindow();
            }
        }
        else
        {
            seconds--;
            if (seconds < 10)
            {
                timeTextField.setText(minutes.toString()+":"+"0"+seconds.toString());
            }
            else
            {
                timeTextField.setText(minutes.toString()+":"+seconds.toString());
            }
        }        
    }
    
    public void updateScore(boolean correct)
    {
        int score = 0;
        //First get the score value for this question
        if (parentFrame.parentButton.getButtonValue().equals("$100"))
        {
            score = 100;
        }
        else if (parentFrame.parentButton.getButtonValue().equals("$200"))
        {
            score = 200;
        }
        else if (parentFrame.parentButton.getButtonValue().equals("$300"))
        {
            score = 300;
        }
        else if (parentFrame.parentButton.getButtonValue().equals("$400"))
        {
            score = 400;
        }
        else if (parentFrame.parentButton.getButtonValue().equals("$500"))
        {
            score = 500;
        }
        
        //Increment/decrement the score based on whether the answer is correct
        if (false == correct)
        {
            score *= -1;
        }
        
        //Notify the game window of the new score
        parentFrame.parentButton.parentFrame.gameWindow.addScore(score);
    }
}

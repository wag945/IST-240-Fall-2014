/*
 * @Course: IST 240 (FA 14)
 * @Section: 001
 *
 * @Group 04
 * @Round 2
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
    
    public QuestionWindow(QuestionFrame frame)
    {
        super();
        setLayout(new BorderLayout());
        parentFrame = frame;
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
        //questionTextField = new JTextField("University Joe Paterno played football for");
        questionTextField.setText("University Joe Paterno played "+"\n"+"football for");
        questionTextField.setAutoscrolls(true);
        questionTextField.setFont(questionFont);
        centerPanel.add(questionTextField,BorderLayout.NORTH);
        answerPanel = new JPanel();
        answerPanel.setLayout(new GridLayout(3,1));
        answerPanel.setBackground(Color.BLUE);
        centerPanel.add(answerPanel,BorderLayout.CENTER);
        answerButtonGroup = new ButtonGroup();
        answerButton1 = new JCheckBox();
        answerButton1.setText("Penn State");
	Font answerFont = new Font("SansSerif", Font.BOLD, 20);
        answerButton1.setFont(answerFont);
        answerButtonGroup.add(answerButton1);
        answerButton2 = new JCheckBox();
        answerButton2.setText("Brown");
        answerButton2.setFont(answerFont);
        answerButtonGroup.add(answerButton2);
        answerButton3 = new JCheckBox();
        answerButton3.setText("Michigan");
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
        timer.start();
    }
    
    public void hideWindow()
    {
        timer.stop();
        answerCorrect = answerButton2.isSelected();
        System.out.println("answerCorrect = "+answerCorrect);
        parentFrame.hideWindow(answerCorrect);
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
}

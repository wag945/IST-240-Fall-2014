/*
 * @Course: IST 240 (FA 14)
 * @Section: 001
 *
 * @Group 04
 * @Round 2
 */
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.awt.Color;
import java.awt.Font;

public class GameTimerWindow extends JPanel implements ActionListener {

    JTextField timeTextField;
    int timeLeft;
    Timer timer;
    Integer minutes,seconds;
    
    public GameTimerWindow()
    {
        super();
        setBackground(Color.BLUE);
        setVisible(true);
        timeLeft = 180;
        minutes = 5;
        seconds = 0;
        timeTextField = new JTextField("TIMER START");
        add(timeTextField);
        timer = new Timer(1000,this);
	Font font = new Font("SansSerif", Font.BOLD, 22);
	timeTextField.setFont(font);
	timeTextField.setHorizontalAlignment(JTextField.CENTER);
    }

    public void displayWindow()
    {
        timer.start();
    }
    
    public void hideWindow()
    {
        timer.stop();
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if (timer == e.getSource())
        {
            updateTime();
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
                timeTextField.setText("GAME OVER");
                timer.stop();
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

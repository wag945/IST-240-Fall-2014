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

public class HighScoresWindow extends JPanel implements ActionListener {

    JTextField text;
    public HighScoresWindow()
    {
        super();
        setBackground(Color.BLUE);
        text = new JTextField();
        text.setText("High scores go here...");
        add(text);
        setVisible(false);        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
    }
}

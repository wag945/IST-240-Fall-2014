/*
 * @Course: IST 240 (FA 14)
 * @Section: 001
 *
 * @Group 04
 * @Round 2
 */
import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.awt.Color;
import java.awt.event.ActionEvent;

public class SplashWindow extends JPanel implements ActionListener {
    
    
    public SplashWindow()
    {
        super();
        setBackground(Color.BLUE);
        JButton jeopardy = new JButton("");
        jeopardy.setIcon(new ImageIcon(getClass().getResource("/images/jeopardy.jpg")));
        add(jeopardy);
        setVisible(false);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
    }
}

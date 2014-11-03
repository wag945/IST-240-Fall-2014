/*
 * @Course: IST 240 (FA 14)
 * @Section: 001
 *
 * @Group 08
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
        setBackground(Color.DARK_GRAY);
        setLayout(null);
        JLabel jeopardy = new JLabel("");
        jeopardy.setIcon(new ImageIcon(getClass().getResource("/images/jeopardy.jpg")));
        jeopardy.setBounds(320, 100, 176, 176);
        add(jeopardy);
        setVisible(false);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
    }
}

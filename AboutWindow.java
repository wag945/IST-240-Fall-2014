/*
 * @Course: IST 240 (FA 14)
 * @Section: 001
 *
 * @Group 08
 */
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.awt.Color;

public class AboutWindow extends JPanel implements ActionListener {

    JTextField text;
    public AboutWindow()
    {
        super();
        setBackground(Color.BLUE);
        text = new JTextField();
        text.setText("Developed by :    Zunair Fayaz, Ronnel Avila, and William Ganley");
        add(text);
        setVisible(false);
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
    }
}

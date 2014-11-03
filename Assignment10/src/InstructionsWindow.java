/*
 * @Course: IST 240 (FA 14)
 * @Section: 001
 *
 * @Group 04
 * @Round 2
 */
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import javax.swing.*;

public class InstructionsWindow extends JPanel implements ActionListener {
    
    JTextField text;
    public InstructionsWindow() throws FileNotFoundException
    {
        super();
        setBackground(Color.BLUE);
        text = new JTextField();
        text.setText("Instructions go here...");
        add(text);
        setVisible(false);
        //test save by Ron Avila
    }

    @Override
    public void actionPerformed(ActionEvent e) {
    }
}

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

public class InstructionsWindow extends JPanel implements ActionListener {
    
    JTextField text;
    public InstructionsWindow()
    {
        super();
        setBackground(Color.BLUE);
        text = new JTextField();
        text.setText("Instructions go here...");
        add(text);
        setVisible(false);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
    }
}

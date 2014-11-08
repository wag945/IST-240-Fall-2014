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
    JButton instructionButton;
    public AboutWindow()
    {
        super();
        setBackground(Color.DARK_GRAY);
        text = new JTextField();
        text.setText("Developed by :    Zunair Fayaz, Ronnel Avila, and William Ganley");
        add(text);
        
        ImageIcon instructionsImage = new ImageIcon(getClass().getResource("/images/JeopardyInstructions-1.jpg"));
        instructionButton = new JButton(instructionsImage);
        instructionButton.setIcon(instructionsImage);
        add(instructionButton);
        
        setVisible(false);
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
    }
}

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

public class InstructionsWindow extends JPanel implements ActionListener 

{
    
//    JTextField text;
//    JButton instructionWindow;
    
    public InstructionsWindow()
    {
        super();
        setBackground(Color.DARK_GRAY);
    }

    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);

        ImageIcon instructionImage = new ImageIcon(getClass().getResource("/images/JeopardyInstructions-1.jpg"));
        Image gameInstructionImage = instructionImage.getImage();
        g.drawImage(gameInstructionImage, 50, 10, this);
    }
        
    @Override
    public void actionPerformed(ActionEvent e) 
    {

    }
}

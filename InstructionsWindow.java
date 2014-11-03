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
        setBackground(Color.BLUE);
//        text = new JTextField();
//        text.setText("Instructions go here...\n");
//        text.setText("test test test\n");
//        text.setText("test test1, test2, test3 \n");
//        add(text);
//        setVisible(false);
        
//        instructionWindow = new JButton();
    }

        public void paintComponent(Graphics g)
        {
            super.paintComponent(g);

            ImageIcon instructionImage = new ImageIcon(getClass().getResource("/images/JeopardyInstructions.jpg"));
            Image gameInstructionImage = instructionImage.getImage();
            g.drawImage(gameInstructionImage, 50, 10, this);
        }
        
    @Override
    public void actionPerformed(ActionEvent e) 
    {

    }
}

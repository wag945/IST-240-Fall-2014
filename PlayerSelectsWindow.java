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
import java.awt.Font;
import java.awt.Image;
import javax.imageio.ImageIO;

public class PlayerSelectsWindow extends JPanel 
{
    JTextField playerSelectsTextField;
    JTextField playerScoreDisplay;
    JButton playerSelectsButton;
    ImageIcon player1Image;
    int player1;
    int player2;
    int player3;
    
    public PlayerSelectsWindow()
    {
        super();
        setBackground(Color.DARK_GRAY);
        setVisible(true);
        playerSelectsTextField = new JTextField();
        playerScoreDisplay = new JTextField();
//        playerSelectsTextField.setHorizontalAlignment(JTextField.TOP);
//        playerScoreDisplay.setHorizontalAlignment(JTextField.BOTTOM);

        ImageIcon player1Image = new ImageIcon("/images/PennState-mascot.jpg");
        playerSelectsButton = new JButton(player1Image);
        add(playerSelectsButton);
        add(playerSelectsTextField);
        add(playerScoreDisplay);
        Font font = new Font("SansSerif", Font.BOLD, 32);
        
    }
    
    public void displayWindow()
    {
        playerSelectsTextField.setText("Player 1 selects");
        playerScoreDisplay.setText("Score: ");
    }
    
    public void hideWindow()
    {
        
    }    
    
}

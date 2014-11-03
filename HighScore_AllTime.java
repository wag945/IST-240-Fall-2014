
import java.awt.Color;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JPanel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author zfayaz
 */
public class HighScore_AllTime extends JPanel
{
    HighScore_AllTime(PlayersList ListOfAllPlayers)
    {
        super();
        setLayout(null);
        setBackground(Color.gray);
        
        Font font = new Font(Font.SANS_SERIF, Font.BOLD, 28);      
        
        JLabel lHeading = new JLabel();
        lHeading.setText("All Time High Score");
        lHeading.setFont(font);
        lHeading.setBounds(120, 10, 300, 36);
        lHeading.setVisible(true);
        add(lHeading);
        

    }
}

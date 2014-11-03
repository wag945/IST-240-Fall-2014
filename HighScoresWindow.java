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
import java.awt.GridLayout;

public class HighScoresWindow extends JPanel implements ActionListener {

//    JTextField text;
    HighScore_Todays TodaysHighScore;
    HighScore_AllTime AllTimeHighScore;
    
    myJFrame ParentJFrame;
    JButton bAHS;
    JButton bTHS;
    
    
    public HighScoresWindow(myJFrame mjf)
    {
        super();
        
        setLayout(null);
        
        setBackground(Color.DARK_GRAY);
        //setBackground(new Color(0, 255, 0, 0));
        //this.setOpaque(true);
//        text = new JTextField();
//        text.setText("High scores go here...");
//        add(text);
        
        bAHS = new JButton("All Time High Score");
        bAHS.addActionListener(this);
        bAHS.setBounds(165, 0, 226, 27);
        add(bAHS);
        
        bTHS = new JButton("Today's High Score");
        bTHS.addActionListener(this);
        bTHS.setBounds(395, 0, 226, 27);
        add(bTHS);
        
        
        ParentJFrame = mjf;
        
        setVisible(true);
        
        TodaysHighScore= new HighScore_Todays(ParentJFrame.setupWindow.ListOfAllPlayers);
        TodaysHighScore.setBounds(148, 50, 500, 500); 
        TodaysHighScore.setVisible(false);        
        add(TodaysHighScore);
        
        
        AllTimeHighScore= new HighScore_AllTime(ParentJFrame.setupWindow.ListOfAllPlayers);                
        AllTimeHighScore.setBounds(148, 50, 500, 500);
        AllTimeHighScore.setVisible(false);
        add(AllTimeHighScore);
    }

    @Override
    public void actionPerformed(ActionEvent e) 
    {
        if (e.getSource().equals(bAHS))
        {
            LoadAllTimeHighScore();
        }
        else if (e.getSource().equals(bTHS))
        {
            LoadTodaysTimeHighScore();
        }     
    }

    private void LoadAllTimeHighScore() 
    {
        TodaysHighScore.setVisible(false);
        //AllTimeHighScore.setBounds(150, 50, 500, 500);         
        AllTimeHighScore.setVisible(true);        
        //repaint();
    }

    private void LoadTodaysTimeHighScore() 
    {
        AllTimeHighScore.setVisible(false);
        //TodaysHighScore.setBounds(150, 50, 500, 500);                 
        TodaysHighScore.setVisible(true);
        //TodaysHighScore.repaint();
    }
}

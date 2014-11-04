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

public class HighScoresWindow extends JPanel implements ActionListener {

    HighScore_Panel TodaysHighScore;
    HighScore_Panel AllTimeHighScore;
    
    myJFrame ParentJFrame;
    JButton bAHS;
    JButton bTHS;
    
    
    public HighScoresWindow(myJFrame mjf)
    {
        super();
        
        setLayout(null);
        
        setBackground(Color.DARK_GRAY);
        
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
        if (TodaysHighScore!=null)
        {
            TodaysHighScore.setVisible(false);
            TodaysHighScore.removeAll();
            TodaysHighScore.repaint();
            TodaysHighScore = null;
        }
        
        if (AllTimeHighScore!=null)
        {
            AllTimeHighScore.setVisible(false);
            AllTimeHighScore.removeAll();
            AllTimeHighScore.repaint();
            AllTimeHighScore = null;
        }
         
        AllTimeHighScore= new HighScore_Panel(ParentJFrame.setupWindow.ListOfAllPlayers, "All Time High Scores", true);                
        AllTimeHighScore.setBounds(148, 50, 500, 500);
        AllTimeHighScore.setVisible(true);
        AllTimeHighScore.setVisible(true);
        this.add(AllTimeHighScore);
        this.repaint();
        
    }

    private void LoadTodaysTimeHighScore() 
    {
        if (AllTimeHighScore!=null)
        {
            AllTimeHighScore.setVisible(false);
            AllTimeHighScore.removeAll();
            AllTimeHighScore.repaint();
            AllTimeHighScore = null;
        }
        
        if (TodaysHighScore!=null)
        {
            TodaysHighScore.setVisible(false);
            TodaysHighScore.removeAll();
            TodaysHighScore.repaint();
            TodaysHighScore = null;
        }        
        
        TodaysHighScore = new HighScore_Panel(ParentJFrame.setupWindow.ListOfAllPlayers, "Today's High Scores", false);
        TodaysHighScore.setBounds(148, 50, 500, 500); 
        TodaysHighScore.setVisible(true);        
        TodaysHighScore.setVisible(true);        
        this.add(TodaysHighScore);   
        this.repaint();
    }
}

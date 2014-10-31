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

    //JTextField text;
    HighScore_Todays TodaysHighScore;
    HighScore_AllTime AllTimeHighScore;
    
    myJFrame ParentJFrame;
    JButton bAHS;
    JButton bTHS;
    
    
    public HighScoresWindow(myJFrame mjf)
    {
        super();
        setBackground(Color.BLUE);
//        text = new JTextField();
//        text.setText("High scores go here...");
//        add(text);
        
        bAHS = new JButton("All Time High Score");
        bAHS.addActionListener(this);
        add(bAHS);
        
        bTHS = new JButton("Today's High Score");
        bTHS.addActionListener(this);
        add(bTHS);
        
        
        ParentJFrame = mjf;
        
        setVisible(false);
        
        TodaysHighScore= new HighScore_Todays(ParentJFrame.setupWindow.ListOfAllPlayers);
        TodaysHighScore.setVisible(false);
        add(TodaysHighScore);
        TodaysHighScore.setBounds(150, 50, 500, 500); 
        
        AllTimeHighScore= new HighScore_AllTime(ParentJFrame.setupWindow.ListOfAllPlayers);
        AllTimeHighScore.setVisible(false);
        add(AllTimeHighScore);
        AllTimeHighScore.setBounds(150, 50, 500, 500);
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
        AllTimeHighScore.setVisible(false);
        TodaysHighScore.setVisible(true);
    }

    private void LoadTodaysTimeHighScore() 
    {
        TodaysHighScore.setVisible(false);
        AllTimeHighScore.setVisible(true);
    }
}

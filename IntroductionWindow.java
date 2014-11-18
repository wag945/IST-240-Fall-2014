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

public class IntroductionWindow extends JPanel implements ActionListener {
    JButton setupButton,aboutButton,highScoresButton,newGameButton;
    myJFrame parentFrame;
    //AudioPlayer SoundPlayer = new AudioPlayer();  //Done in the constructor
    public IntroductionWindow(myJFrame mjf) {
        super();
        setBackground(Color.DARK_GRAY);

        parentFrame = mjf;
        //instructionsButton = new JButton();
        //instructionsButton.setText("Instructions");
        //instructionsButton.addActionListener(this);
        setupButton = new JButton();
        setupButton.setText("Setup");        
        setupButton.addActionListener(this);        
        newGameButton = new JButton();
        newGameButton.setText("New Game");
        newGameButton.setEnabled(false);
        newGameButton.addActionListener(this);
        highScoresButton = new JButton();
        highScoresButton.setText("High Scores");
        highScoresButton.addActionListener(this);
        aboutButton = new JButton();
        aboutButton.setText("About");
        aboutButton.addActionListener(this);

        //add(instructionsButton);
        add(setupButton);
        add(highScoresButton);
        add(newGameButton);
        add(aboutButton);
        
        setTheme();
    }
    
    public void setTheme()
    {
        Color bColor = parentFrame.buttonColor.darker();
        Color fColor = bColor.brighter().brighter().brighter().brighter().brighter();

        setupButton.setBackground(bColor);
        setupButton.setForeground(fColor);
        newGameButton.setBackground(bColor);
        newGameButton.setForeground(fColor);
        highScoresButton.setBackground(bColor);
        highScoresButton.setForeground(fColor);
        aboutButton.setBackground(bColor);
        aboutButton.setForeground(fColor);               
    }

    @Override
    public void actionPerformed(ActionEvent e) {
//        if (instructionsButton == e.getSource())
//        {
//            System.out.println("instructionsButton pressed");
//            parentFrame.instructions();
//        }
//        else 
        if (setupButton == e.getSource())
        {
            System.out.println("setupButton pressed");
            parentFrame.setup();
        }
        else if (highScoresButton == e.getSource())
        {
            System.out.println("highScoresButton pressed");
            parentFrame.highScores();
        }
        else if (newGameButton == e.getSource())
        {
            System.out.println("newGameButton pressed");
            parentFrame.SoundPlayer.play("jboardfill.wav");
            parentFrame.newGame();
        }
        else if (aboutButton == e.getSource())
        {
            System.out.println("aboutButton pressed");
            parentFrame.about();
        }
    }
}

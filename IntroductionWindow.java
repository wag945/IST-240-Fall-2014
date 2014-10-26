/*
 * @Course: IST 240 (FA 14)
 * @Section: 001
 *
 * @Group 04
 * @Round 2
 */
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class IntroductionWindow extends JPanel implements ActionListener {
    JButton instructionsButton,setupButton,aboutButton,highScoresButton,newGameButton;
    myJFrame parentFrame;
    AudioPlayer SoundPlayer = new AudioPlayer();  //Done in the constructor
    public IntroductionWindow(myJFrame mjf) {
        super();
        setBackground(Color.BLUE);

        parentFrame = mjf;
        instructionsButton = new JButton();
        instructionsButton.setText("Instructions");
        instructionsButton.addActionListener(this);
        setupButton = new JButton();
        setupButton.setText("Setup");        
        setupButton.addActionListener(this);
        highScoresButton = new JButton();
        highScoresButton.setText("High Scores");
        highScoresButton.addActionListener(this);
        newGameButton = new JButton();
        newGameButton.setText("New Game");
        newGameButton.setEnabled(false);
        newGameButton.addActionListener(this);
        aboutButton = new JButton();
        aboutButton.setText("About");
        aboutButton.addActionListener(this);

        add(instructionsButton);
        add(setupButton);
        add(highScoresButton);
        add(newGameButton);
        add(aboutButton);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (instructionsButton == e.getSource())
        {
            System.out.println("instructionsButton pressed");
            parentFrame.instructions();
        }
        else if (setupButton == e.getSource())
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
            SoundPlayer.play("jboardfill.wav");
            parentFrame.newGame();
        }
        else if (aboutButton == e.getSource())
        {
            System.out.println("aboutButton pressed");
            parentFrame.about();
        }
    }
}

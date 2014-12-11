/*
 * @Course: IST 240 (FA 14)
 * @Section: 001
 *
 * @Group 08
 */

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.JTextArea;

public class AboutWindow extends JPanel implements ActionListener
{

    myJFrame ParentJFrame;
    JPanel aboutPanel;
    JPanel instructionsPanel;
    JButton aboutAuthors, instructionButton;
    
    public AboutWindow(myJFrame mjf)
    {
        super();
        setLayout(null);
        setBackground(Color.DARK_GRAY);
        
        aboutAuthors = new JButton("Credits");
        aboutAuthors.addActionListener(this);
        aboutAuthors.setBounds(260, 5, 150, 27);
        add(aboutAuthors);

        instructionButton = new JButton("Instructions");
        instructionButton.addActionListener(this);
        instructionButton.setBounds(420, 5, 150, 27);
        add(instructionButton);
        
        ParentJFrame = mjf;        
        setVisible(true);
        setTheme();
    }
    
    public void setTheme()
    {
        Color bColor = ParentJFrame.buttonColor.darker().darker();
        Color fColor = bColor.brighter().brighter().brighter().brighter().brighter().brighter();

        aboutAuthors.setBackground(bColor);
        aboutAuthors.setForeground(fColor);
        instructionButton.setBackground(bColor);
        instructionButton.setForeground(fColor);
    }

    static String aboutText = ""
        + "\n\n\n\n"
        + " Developed by\n\n"
        + "   Ron Avila\n"
        + " Zunair Fayaz\n"
        + "William Ganley"
        + "";

    static String instructionsText = "\n\n"
            + "Each game begins with user(s) selecting the number of \n"
            + "players, by pressing the Setup button at the top. \n"
            + "\n"
            + "Next the player(s) choose the level of difficulty. \n"
            + "The options are K12 level, Under Grad level, and finally \n"
            + "Grad level. \n"
            + "\n"
            + "After all the options have been chosen select new game \n"
            + "\n"
            + "Each player will take turns coming up with the \n" 
            + "question to each answer presented under each topic\n"
            + "at the top of the screen. \n"
            + "\n"
            + "The high lighted player will indicate who's turn it is \n"
            + "with player 1 going first, next player 2, then 3 and so on \n"
            + "\n"
            + "Player 1 starts the game by picking a category and the\n"
            + "square dollar amount under each category and clicking it. \n"
            + "a pop-up screen will appear and the player will have \n"
            + "10 seconds to click/check the correct answer. \n"
            + "If the player1 gets it wrong then it becomes player 2's turn \n"
            + "and so on, until all the squares on the board has \n"
            + "been picked or until time runs out. \n"
            + "\n"
            + "High Scores are recorded and the player with the most cash"
            + "accumulated at the end of the game wins.\n"
            + "\n"
            + "Players' records are kept for the most cash awarded. \n"
            + "\n"
            + "Please press Setup to begin!\n";

    @Override
    public void actionPerformed(ActionEvent e) 
    {    
        
        Object obj = e.getSource();
        if(obj == aboutAuthors)
        {
           loadAbout();  
        }
        
        if(obj == instructionButton)
        {
           loadInsructions(); 
        }       
    }
    
    private void loadAbout()
    {
        if (aboutPanel != null) remove(aboutPanel);
        if (instructionsPanel != null) remove(instructionsPanel);
        Font font = new Font(Font.SANS_SERIF, Font.BOLD, 25);
        aboutPanel = new JPanel();
        JTextArea jta1 = new JTextArea(aboutText);
        jta1.setFont(font);
        jta1.setWrapStyleWord(true);
        jta1.setBackground(Color.gray);
        jta1.setForeground(Color.white);
        jta1.setFocusable(false);
        jta1.setEditable(false);
        aboutPanel.setBounds(148, 50, 500, 560);
        aboutPanel.setBackground(Color.gray);
        aboutPanel.setForeground(Color.white);
        aboutPanel.add(jta1);
        aboutPanel.setBorder(BorderFactory.createLineBorder(Color.black));
        aboutPanel.setVisible(true);
        this.add(aboutPanel);
        validate();
        this.repaint();
    }
        
    private void loadInsructions()
    {
        if (aboutPanel != null) remove(aboutPanel);
        if (instructionsPanel != null) remove(instructionsPanel);
        Font font = new Font("Times", Font.BOLD, 14); 
        instructionsPanel = new JPanel();
        JTextArea jta2 = new JTextArea(instructionsText, 28, 35);
        jta2.setFocusable(false);
        jta2.setFont(font);
        jta2.setLineWrap(true);
        jta2.setBackground(Color.gray);
        jta2.setForeground(Color.white);
        jta2.setEditable(false);
        instructionsPanel.setBounds(148, 50, 500, 650);
        instructionsPanel.setBackground(Color.gray);
        instructionsPanel.setForeground(Color.white);
        instructionsPanel.setBorder(BorderFactory.createLineBorder(Color.black));
        instructionsPanel.add(jta2);
        instructionsPanel.setVisible(true);
        this.add(instructionsPanel);
        validate();
        this.repaint();
    }
}

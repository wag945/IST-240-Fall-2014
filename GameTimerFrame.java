/*
 * @Course: IST 240 (FA 14)
 * @Section: 001
 *
 * @Group 08
 */
import java.awt.*;
import javax.swing.*;
import static javax.swing.JFrame.EXIT_ON_CLOSE;

public class GameTimerFrame extends JFrame
{
    GameTimerWindow window;
    public GameTimerFrame ()
    {
        super("Timer");
        //------------------------------------------------------
        // Create components
        window = new GameTimerWindow();
        //------------------------------------------------------
        // Choose a Layout for JFrame and 
        // add Jpanel to JFrame according to layout    	
        getContentPane().setLayout(new BorderLayout());
        getContentPane().add(window,BorderLayout.CENTER);

        
        //------------------------------------------------------
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize (200, 200);
        setBounds(840,0,200,100);
        setVisible(false);
    }
    
    public void displayWindow()
    {
        setVisible(true);
        window.displayWindow();
    }
    
    public void hideWindow()
    {
        setVisible(false);
        window.hideWindow();
    }
}

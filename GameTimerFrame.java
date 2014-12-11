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

public class GameTimerFrame extends JDialog implements ActionListener
{
    GameTimerWindow window;
    myJFrame parentFrame;
    
    public GameTimerFrame (myJFrame frame)
    {
        super();
        parentFrame = frame;
        //------------------------------------------------------
        // Create components
        window = new GameTimerWindow(this);
        //------------------------------------------------------
        // Choose a Layout for JFrame and 
        // add Jpanel to JFrame according to layout    	
        getContentPane().setLayout(new BorderLayout());
        getContentPane().add(window,BorderLayout.CENTER);
        this.setFocusable(false);
        this.setFocusableWindowState(false);
        this.setAlwaysOnTop(true);
        //------------------------------------------------------
        //do not let timer window close manualy
        this.setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
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

    @Override
    public void actionPerformed(ActionEvent ae) 
    {
        
    }
}

/*
 * @Course: IST 240 (FA 14)
 * @Section: 001
 *
 * @Group 08
 */
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.*;
import static javax.swing.JFrame.EXIT_ON_CLOSE;

public class GameTimerFrame extends JDialog implements ActionListener
{
    GameTimerWindow window;
    public GameTimerFrame ()
    {
        //super("Timer");
        super();
        //------------------------------------------------------
        // Create components
        window = new GameTimerWindow();
        //------------------------------------------------------
        // Choose a Layout for JFrame and 
        // add Jpanel to JFrame according to layout    	
        getContentPane().setLayout(new BorderLayout());
        getContentPane().add(window,BorderLayout.CENTER);
        this.setFocusable(false);
        this.setFocusableWindowState(false);
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

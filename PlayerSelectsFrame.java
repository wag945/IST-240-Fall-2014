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

public class PlayerSelectsFrame extends JDialog implements ActionListener
{

    PlayerSelectsWindow playerSelects;
    public PlayerSelectsFrame()
    {
        super();
        playerSelects = new PlayerSelectsWindow();
        getContentPane().setLayout(new BorderLayout());
        getContentPane().add(playerSelects, BorderLayout.CENTER);
        this.setFocusable(false);
        this.setFocusableWindowState(false);

        this.setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
        this.addWindowListener(
            new WindowAdapter() 
            {
                @Override
                public void windowClosing(WindowEvent we) 
                {
                    //do not let timer window close manualy
                }
            });

        setVisible(false);    
    }

    public void displayWindow()
    {
        setVisible(true);
        playerSelects.displayWindow();
    }
    
    public void hideWindow()
    {
        setVisible(false);
        playerSelects.hideWindow();
    }

    @Override
    public void actionPerformed(ActionEvent ae) 
    {
        
    }
      
}

/*
 * @Course: IST 240 (FA 14)
 * @Section: 001
 *
 * @Group 08
 */
import java.awt.*;
import java.awt.event.HierarchyBoundsListener;
import java.awt.event.HierarchyEvent;
import javax.swing.*;

public class myJFrame extends JFrame
{
    GameWindow gameWindow;
    SetupWindow setupWindow;
    IntroductionWindow introductionWindow;
    InstructionsWindow instructionsWindow;
    AboutWindow aboutWindow;
    HighScoresWindow highScoresWindow;
    SplashWindow splashWindow;
    JButton jeopardy;
    GameTimerFrame timerFrame;
    AudioPlayer SoundPlayer;

    public myJFrame ()
    {
        super("PSU Jeopardy");
        //------------------------------------------------------
        // Create components
        gameWindow = new GameWindow();
        setupWindow = new SetupWindow(this);
        introductionWindow = new IntroductionWindow(this);
        instructionsWindow = new InstructionsWindow();
        aboutWindow = new AboutWindow();
        highScoresWindow = new HighScoresWindow(this);
        splashWindow = new SplashWindow();
        timerFrame = new GameTimerFrame();
        SoundPlayer = new AudioPlayer();
        
        this.getContentPane().addHierarchyBoundsListener(new HierarchyBoundsListener()
        {
 
            @Override
            public void ancestorMoved(HierarchyEvent e) 
            {
                if (timerFrame.isVisible())
                {
                    //timerFrame.setBounds(getBounds().x+840+4, getBounds().y-4, 300, 100);
                    timerFrame.setLocation(getBounds().x+840+4, getBounds().y-5);
                }
            }
            @Override
            public void ancestorResized(HierarchyEvent e) 
            {
                //System.out.println(e);                 
            }           

        });


        //------------------------------------------------------
        // Choose a Layout for JFrame and 
        // add Jpanel to JFrame according to layout    	
        getContentPane().setLayout(new BorderLayout());
        getContentPane().add(introductionWindow,BorderLayout.NORTH);
        getContentPane().add(gameWindow,BorderLayout.CENTER);
        getContentPane().add(instructionsWindow,BorderLayout.CENTER);
        getContentPane().add(highScoresWindow,BorderLayout.CENTER);
        getContentPane().add(aboutWindow,BorderLayout.CENTER);

        //jeopardy = new JButton("");
        //jeopardy.setIcon(new javax.swing.ImageIcon(getClass().getResource("images/jeopardy.jpg")));
        //getContentPane().add(jeopardy,BorderLayout.CENTER);
        
        //------------------------------------------------------
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize (840, 800);
        //setMinimumSize(new Dimension(840,800));
        this.setResizable(false);
        setVisible(true);
        splashWindow();
    }
    
    public void newGame()
    {
        allOff();
        gameBoardOn();
    }
    
    public void instructions()
    {
        allOff();
        instructionsWindowOn();
    }
    
    public void setup()
    {
        allOff();
        setupWindowOn();
    }
    
    public void about()
    {
        allOff();
        aboutWindowOn();
    }
    
    public void highScores()
    {
        allOff();
        highScoresWindowOn();
    }

    public void splashWindow()
    {
        allOff();
        splashWindowOn();
    }

    public void gameBoardOn()
    {
        if (false == gameWindow.isVisible())
        {
            getContentPane().add(gameWindow,BorderLayout.CENTER);
            gameWindow.setVisible(true);
            timerFrame.setBounds(getBounds().x+840+4, getBounds().y-4, 260, 100);
            timerFrame.displayWindow();
        }
    }
    
    public void gameBoardOff()
    {
        if (true == gameWindow.isVisible())
        {
            getContentPane().remove(gameWindow);
            gameWindow.setVisible(false);
            timerFrame.hideWindow();
        }        
    }
    
    public void setupWindowOn()
    {
        if (false == setupWindow.isVisible())
        {
            getContentPane().add(setupWindow,BorderLayout.CENTER);
            setupWindow.setVisible(true);
        }
    }
    
    public void setupWindowOff()
    {
        if (true == setupWindow.isVisible())
        {
            getContentPane().remove(setupWindow);
            setupWindow.setVisible(false);
        }
    }
    
    public void instructionsWindowOn()
    {
        if (false == instructionsWindow.isVisible())
        {
            getContentPane().add(instructionsWindow,BorderLayout.CENTER);
            instructionsWindow.setVisible(true);
        }
    }
    
    public void instructionsWindowOff()
    {
        if (true == instructionsWindow.isVisible())
        {
            getContentPane().remove(instructionsWindow);
            instructionsWindow.setVisible(false);
        }
    }
    
    public void aboutWindowOn()
    {
        if (false == aboutWindow.isVisible())
        {
            getContentPane().add(aboutWindow,BorderLayout.CENTER);
            aboutWindow.setVisible(true);
        }
    }
    
    public void aboutWindowOff()
    {
       if (true == aboutWindow.isVisible())
       {
           getContentPane().remove(aboutWindow);
           aboutWindow.setVisible(false);
       }
    }
    
    public void highScoresWindowOn()
    {
        if (false == highScoresWindow.isVisible())
        {
            getContentPane().add(highScoresWindow,BorderLayout.CENTER);
            highScoresWindow.setVisible(true);
        }
    }
    
    public void highScoresWindowOff()
    {
        if (true == highScoresWindow.isVisible())
        {
            getContentPane().remove(highScoresWindow);
            highScoresWindow.setVisible(false);
        }
    }
    
    public void splashWindowOn()
    {
        if (false == splashWindow.isVisible())
        {
            getContentPane().add(splashWindow,BorderLayout.CENTER);
            splashWindow.setVisible(true);
            SoundPlayer.play("lionroar.wav");
        }
    }
    
    public void splashWindowOff()
    {
        if (true == splashWindow.isVisible())
        {
            getContentPane().remove(splashWindow);
            splashWindow.setVisible(false);
        }
    }
    
    public void allOff()
    {
        gameBoardOff();
        setupWindowOff();
        instructionsWindowOff();
        aboutWindowOff();
        highScoresWindowOff();
        splashWindowOff();
    }
}

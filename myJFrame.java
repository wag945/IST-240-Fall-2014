/*
 * @Course: IST 240 (FA 14)
 * @Section: 001
 *
 * @Group 08
 */
import java.awt.*;
import java.awt.event.HierarchyBoundsListener;
import java.awt.event.HierarchyEvent;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import javax.swing.*;

public class myJFrame extends JFrame implements WindowListener
{
    GameWindow gameWindow;
    GameHeader gameHeader;
    SetupWindow setupWindow;
    IntroductionWindow introductionWindow;
    InstructionsWindow instructionsWindow;
    AboutWindow aboutWindow;
    HighScoresWindow highScoresWindow;
    SplashWindow splashWindow;
    JButton jeopardy;
    GameTimerFrame timerFrame;
    AudioPlayer SoundPlayer;
    //PlayerSelectsFrame playerTurnFrame;
    
    public myJFrame () 
    {
        super("PSU Jeopardy");
        //------------------------------------------------------
        // Create components
        //gameWindow = new GameWindow(this);
        setupWindow = new SetupWindow(this);
        introductionWindow = new IntroductionWindow(this);
        instructionsWindow = new InstructionsWindow();
        aboutWindow = new AboutWindow();
        highScoresWindow = new HighScoresWindow(this);
        splashWindow = new SplashWindow();
        timerFrame = new GameTimerFrame();
        //playerTurnFrame = new PlayerSelectsFrame();
        SoundPlayer = new AudioPlayer();
        
        this.addWindowListener(this);
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
                
//                if (playerTurnFrame.isVisible())
//                {
//                    playerTurnFrame.setLocation(getBounds().x+840+4, getBounds().y+100);
//                }
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
        //getContentPane().add(gameWindow,BorderLayout.CENTER);
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
        gameCreateNew();
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
            introductionWindowOff();
            //getContentPane().add(gameHeader,BorderLayout.NORTH);
            gameHeaderOn();
            getContentPane().add(gameWindow,BorderLayout.CENTER);            
            gameWindow.setVisible(true);
            timerFrame.setBounds(getBounds().x+840+4, getBounds().y-5, 260, 100);
            timerFrame.displayWindow();
            //repaint();
            //playerTurnFrame.setBounds(getBounds().x+840+4, getBounds().y+100, 260, 100);
            //playerTurnFrame.displayWindow();
            
        }
    }
    
    public void gameBoardOff()
    {
        if (gameWindow!=null)
        {
//            if (true == gameWindow.isVisible())
//            {
//                getContentPane().remove(gameWindow);
                gameWindow.setVisible(false);
                timerFrame.hideWindow();
                //playerTurnFrame.hideWindow();
//            }
            gameHeaderOff();
            introductionWindowOn();
            gameWindow.removeAll();
            gameWindow.repaint();
            getContentPane().remove(gameWindow);
            gameWindow = null;
            
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
    
    public void introductionWindowOff()
    {
        if (true == introductionWindow.isVisible())
        {
            getContentPane().remove(introductionWindow);
            introductionWindow.setVisible(false);
        }
    }
    
    public void introductionWindowOn()
    {
        if (false == introductionWindow.isVisible())
        {
            getContentPane().add(introductionWindow,BorderLayout.NORTH);
            introductionWindow.setVisible(true);
        }
    }
    
    public void gameHeaderOff()
    {
        if (true == gameHeader.isVisible())
        {
            getContentPane().remove(gameHeader);
            gameHeader.setVisible(false);
        }
    }
    
    public void gameHeaderOn()
    {
        if (false == gameHeader.isVisible())
        {
            getContentPane().add(gameHeader,BorderLayout.NORTH);
            gameHeader.setVisible(true);
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

    private void gameCreateNew() 
    {
        if (gameWindow!=null)
        {
            gameWindow.removeAll();
            gameWindow.repaint();
            getContentPane().remove(gameWindow);
            gameWindow = null;
        }
        gameHeader = new GameHeader(this);
        gameHeader.setVisible(false);
        gameWindow = new GameWindow(this, timerFrame.window, gameHeader);
        
        //getContentPane().add(gameWindow,BorderLayout.CENTER);
    }

    @Override
    public void windowOpened(WindowEvent we) 
    {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void windowClosing(WindowEvent we) 
    {
        int n = JOptionPane.showConfirmDialog(this,
                    "Are you sure you want to exit?",
                    "Exit",
                    JOptionPane.YES_NO_OPTION);
        if (n == JOptionPane.YES_OPTION)
        {
            setDefaultCloseOperation (WindowConstants.EXIT_ON_CLOSE);       
        }
        else
        {
            setDefaultCloseOperation (WindowConstants.DO_NOTHING_ON_CLOSE);                   
        }
    }

    @Override
    public void windowClosed(WindowEvent we) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void windowIconified(WindowEvent we) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void windowDeiconified(WindowEvent we) {
        ///throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void windowActivated(WindowEvent we) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void windowDeactivated(WindowEvent we) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}

/*
 * @Course: IST 240 (FA 14)
 * @Section: 001
 *
 * @Group 08
 */

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;

public class SplashPlayerName extends JPanel implements ActionListener
{
    private int SplashTime;
    private String PlayerName;
    Timer SplashTimer;
    
    public void paintComponent(Graphics g) 
    {
        super.paintComponent(g);
        if (getPlayerName()!=null)
        {
            g.drawString(getPlayerName(), 200, 300);
        }
    }
    
    SplashPlayerName()
    {
        super();
        
        Font font = new Font(Font.SANS_SERIF, Font.BOLD, 72);
        this.setBounds(0, 0, 840, 800);
        this.setLayout(null);        
        //this.setOpaque(true);        
        this.setBackground(Color.black);//new Color(102, 102, 102, 200));
        this.setForeground(Color.gray);//new Color(59, 51, 178, 200));
        this.setFont(font);
        this.setVisible(false);
    }
    
    public void start()
    {
        this.setVisible(true);
        this.SplashTimer = new Timer(getSplashTime()*1000, this);
        this.SplashTimer.addActionListener(this);
        this.SplashTimer.setRepeats(false);
        this.SplashTimer.start();
    }

    @Override
    public void actionPerformed(ActionEvent ae) 
    {
        if (ae.getSource() == this.SplashTimer)
        {
            this.setVisible(false);
            this.SplashTimer.stop();
        }
    }

    /**
     * @return the SplashTime
     */
    public int getSplashTime() {
        return SplashTime;
    }

    /**
     * @param SplashTime the SplashTime to set
     */
    public void setSplashTime(int SplashTime) {
        this.SplashTime = SplashTime;
    }

    /**
     * @return the PlayerName
     */
    public String getPlayerName() {
        return PlayerName;
    }

    /**
     * @param PlayerName the PlayerName to set
     */
    public void setPlayerName(String PlayerName) {
        this.PlayerName = PlayerName;
    }
}

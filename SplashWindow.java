/*
 * @Course: IST 240 (FA 14)
 * @Section: 001
 *
 * @Group 08
 */

import java.awt.AlphaComposite;
import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;

public class SplashWindow extends JPanel implements ActionListener {
    
    Timer t;
    JLabel jeopardy;
    
    public SplashWindow()
    {
        super();
        setBackground(Color.DARK_GRAY);
        setLayout(null);
        jeopardy = new JLabel("");
        //File imgFile = new File(getClass().getResource("/images/psu.png"));
        jeopardy.setBounds(215, 150, 50, 50);
        add(jeopardy);
        setVisible(false);
        
        t = new Timer(0,this);
        t.addActionListener(this);
        t.start();
    }

    @Override
    public void actionPerformed(ActionEvent e) 
    {
        if (e.getSource().equals(t))
        {
            int centerX = this.getWidth() / 2;
            int imageHalfWidth = jeopardy.getWidth()/2;
            
            if (jeopardy.getHeight() < 700)
            {
                jeopardy.setIcon(ResizeIcon(jeopardy.getWidth()+50,jeopardy.getHeight()+50));
                jeopardy.setBounds(centerX-imageHalfWidth-25, centerX-imageHalfWidth-70, jeopardy.getWidth()+50, jeopardy.getHeight()+50);
            }
            else
            {
                t.stop();
            }
        }
    }
    
    Icon ResizeIcon (int h, int w)
    {
        try 
        {
            Image img = ImageIO.read(getClass().getResourceAsStream("/images/psu.png"));        
            Image resizedImage = img.getScaledInstance(w, h, 0);
            return (new ImageIcon(resizedImage));
        } 
        catch (IOException ex) 
        {
            Logger.getLogger(SplashWindow.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
    
}

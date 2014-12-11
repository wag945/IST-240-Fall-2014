/*
 * @Course: IST 240 (FA 14)
 * @Section: 001
 *
 * @Group 08
 */

import java.awt.event.ActionListener;
import javax.swing.*;
import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;

public class SplashWindow extends JPanel implements ActionListener {
    
    Timer t;
    JLabel jeopardy;
    Image img;
    
    public SplashWindow()
    {
        super();
        
        setVisible(false);
        
        try 
        {
            img = ImageIO.read(getClass().getResourceAsStream("/images/psu.png"));
        } 
        catch (IOException ex) 
        {
            Logger.getLogger(SplashWindow.class.getName()).log(Level.SEVERE, null, ex);
        }
         
        setBackground(Color.DARK_GRAY);
        setLayout(null);
        jeopardy = new JLabel("");
        jeopardy.setBounds(215, 150, 50, 50);
        add(jeopardy);
        
        t = new Timer(0,this);
        t.addActionListener(this);
        t.start();
    }

    @Override
    public void actionPerformed(ActionEvent e) 
    {
        if (e.getSource().equals(t))
        {
            int centerX;// = this.getWidth() / 2; //getWidth is glitchy on MACs
            centerX = 420;
            int imageHalfWidth = jeopardy.getWidth()/2;
            
            if (jeopardy.getHeight() < 700)
            {
                jeopardy.setIcon(ResizeIcon(jeopardy.getWidth()+20,jeopardy.getHeight()+20));
                jeopardy.setBounds(centerX-imageHalfWidth-15, centerX-imageHalfWidth-70, jeopardy.getWidth()+20, jeopardy.getHeight()+20);            }
            else
            {
                t.stop();
            }
        }
    }
    
    Icon ResizeIcon (int h, int w)
    {    
        Image resizedImage = img.getScaledInstance(w, h, 0);
        return (new ImageIcon(resizedImage));
    }
}

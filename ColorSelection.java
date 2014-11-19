/*
 * @Course: IST 240 (FA 14)
 * @Section: 001
 *
 * @Group 08
 */
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

public class ColorSelection extends JPanel implements ActionListener
{
    JPanel pColorSelection;
    ButtonGroup intColorSelection;
    JButton bNext;
//    Color c_blue = new Color(Color.blue); //colors are not defined
//    Color c_white;
//    Color c_gray;
//    
    ColorSelection(int informedColorSelection, Color ThemeColor)
    {
        super();
        setLayout(null);
        setBackground(Color.gray);
        
        pColorSelection = new JPanel();
        pColorSelection.setOpaque(true);
        pColorSelection.setBackground(Color.gray);
        pColorSelection.setBorder(BorderFactory.createLineBorder(Color.black));
        pColorSelection.setVisible(true);
        pColorSelection.setLayout(null);
        pColorSelection.setBounds(105, 60, 300, 350);
        add(pColorSelection);
        
        Font font = new Font(Font.SANS_SERIF, Font.BOLD, 28);
        
        JLabel mHeading = new JLabel();
        mHeading.setText("Theme Selection");
        mHeading.setForeground(Color.white);
        mHeading.setFont(font);
        mHeading.setBounds(150, 10, 300, 36);
        mHeading.setVisible(true);
        add(mHeading);
        
        JRadioButton c1_Color = new JRadioButton("Navy");
        JRadioButton c2_Color = new JRadioButton("Gray");
        JRadioButton c3_Color = new JRadioButton("Dark Gray");
        
        font = new Font(Font.SANS_SERIF, Font.BOLD, 14);
        c1_Color.setFont(font);
        c2_Color.setFont(font);
        c3_Color.setFont(font);
        
        c1_Color.setMnemonic(KeyEvent.VK_N);
        c2_Color.setMnemonic(KeyEvent.VK_G);
        c3_Color.setMnemonic(KeyEvent.VK_D);
        
        c1_Color.setActionCommand("1");
        c2_Color.setActionCommand("2");
        c3_Color.setActionCommand("3");
        
        intColorSelection = new ButtonGroup();
        intColorSelection.add(c1_Color);
        intColorSelection.add(c2_Color);
        intColorSelection.add(c3_Color);
        
        c1_Color.setBounds(50, 80, 200, 37);
        c2_Color.setBounds(50, 137, 200, 37);
        c3_Color.setBounds(50, 194, 200, 37);
        
        setOpaque(true);
        c1_Color.setOpaque(true);
        c2_Color.setOpaque(true);
        c3_Color.setOpaque(true);
        
        setBackground(Color.DARK_GRAY);
        c1_Color.setBackground(null);
        c2_Color.setBackground(null);
        c3_Color.setBackground(null);
        
        c1_Color.setForeground(Color.white);
        c2_Color.setForeground(Color.white);
        c3_Color.setForeground(Color.white);
        
        pColorSelection.add(c1_Color);
        pColorSelection.add(c2_Color);
        pColorSelection.add(c3_Color);
        
        
        bNext = new JButton();
        bNext.setText("Select");  
        bNext.setName("bSave");
        bNext.setBounds(324, 420, 80, 27);
        bNext.addActionListener(this);
        add(bNext);
        
        switch (informedColorSelection)
        {
            case 1:
                c1_Color.setSelected(true);
                break;
            case 2:
                c2_Color.setSelected(true);
                break;
            case 3:
                c3_Color.setSelected(true);
                break;
            default:
                break;
        }        
 
        setTheme(ThemeColor);
    }
    
    public void setTheme(Color ThemeColor)
    {
        Color bColor = ThemeColor.darker();
        Color fColor = bColor.brighter().brighter().brighter().brighter().brighter();

        bNext.setBackground(bColor);
        bNext.setForeground(fColor);
    }

    @Override
    public void actionPerformed(ActionEvent ae) 
    {
        if (ae.getSource().getClass().toString().equals("class javax.swing.JButton"))
        {
            JButton bTemp = (JButton)ae.getSource();
            if (bTemp.getName().equals("bSave"))
            {
                if (intColorSelection.getSelection()!=null)
                {
                    int ColorSelection = Integer.parseInt(intColorSelection.getSelection().getActionCommand());
                    System.out.print("Color is " + ColorSelection + "\r\n"); //use ColorSelection here
                    

                    SetupWindow setup = (SetupWindow)this.getParent();

                    setup.ColorSelection = ColorSelection;
                    setup.colorSelection.setVisible(true);
                    setup.bDifficulty.setVisible(true);
                    setup.bPlayers.setVisible(true);
                    
                    switch (ColorSelection)
                    {
                        case 1:                     
                            setup.ParentFrame.setGameButtonColor(new Color(0,0,132));
                            break;
                        case 2:
                            setup.ParentFrame.setGameButtonColor(Color.white);
                            break;
                        case 3:
                            setup.ParentFrame.setGameButtonColor(Color.gray);
                            break;
                    }

                    if (setup.DifficultyLevel>0 && setup.ColorSelection>0 && !setup.SelectedPlayers.isEmpty())
                    {   
                        setup.ParentFrame.introductionWindow.setTheme();
                        setup.ParentFrame.setupWindow.setTheme();
                        setup.ParentFrame.introductionWindow.newGameButton.setEnabled(true);                        
                        setup.SaveDataInXML();
                    }
                    //this.removeAll();
                    PanelAnimate PanelToAnimate = new PanelAnimate(1,this);
                    PanelToAnimate.RemovePanelAfterAnimation(true);
                    PanelToAnimate.SlideLeft();
                }
            }        
        }        
        
    }
    
}

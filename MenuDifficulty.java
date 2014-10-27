/*
 * @Course: IST 240 (FA 14)
 * @Section: 001
 *
 * @Group 08
 */
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

public class MenuDifficulty extends JPanel implements ActionListener
{
    
    JPanel pDifficultySelection;
    ButtonGroup intDifficultyLevel;
    
    MenuDifficulty (int informedDifficultyLevel)
    {
        super();
        setLayout(null);
        setBackground(Color.gray);
                
        
        pDifficultySelection = new JPanel();
        pDifficultySelection.setOpaque(true);
        pDifficultySelection.setBackground(Color.BLACK);
        pDifficultySelection.setVisible(true);
        pDifficultySelection.setLayout(null);
        pDifficultySelection.setBounds(100, 50, 300, 300);
        add(pDifficultySelection);
        
         //Create Label
        JLabel lDifficulty = new JLabel();
        lDifficulty.setText("Select Difficulty Level:");
        
        //Create player choices
        JRadioButton r1_Difficulty = new JRadioButton("K12");
        JRadioButton r2_Difficulty = new JRadioButton("Under Grad");
        JRadioButton r3_Difficulty = new JRadioButton("Grad");
        
        r1_Difficulty.setMnemonic(KeyEvent.VK_K);
        r2_Difficulty.setMnemonic(KeyEvent.VK_U);
        r3_Difficulty.setMnemonic(KeyEvent.VK_G);        
        
        r1_Difficulty.setActionCommand("1");
        r2_Difficulty.setActionCommand("2");
        r3_Difficulty.setActionCommand("3");
        
        //r1_Difficulty.setSelected(true);
        
        //Add player choices in a group
        intDifficultyLevel = new ButtonGroup();
        intDifficultyLevel.add(r1_Difficulty);
        intDifficultyLevel.add(r2_Difficulty);
        intDifficultyLevel.add(r3_Difficulty);
        
        //SetLocation
        lDifficulty.setBounds(50, 060, 200, 40);
        r1_Difficulty.setBounds(50, 100, 200, 37);
        r2_Difficulty.setBounds(50, 137, 200, 37);
        r3_Difficulty.setBounds(50, 174, 200, 37);

        setOpaque(true);
        lDifficulty.setOpaque(true);
        r1_Difficulty.setOpaque(true);
        r2_Difficulty.setOpaque(true);
        r3_Difficulty.setOpaque(true);
        
        setBackground(Color.DARK_GRAY);
        lDifficulty.setBackground(null);
        r1_Difficulty.setBackground(null);
        r2_Difficulty.setBackground(null);
        r3_Difficulty.setBackground(null);
        
        
        lDifficulty.setForeground(Color.white);
        r1_Difficulty.setForeground(Color.white);
        r2_Difficulty.setForeground(Color.white);
        r3_Difficulty.setForeground(Color.white);

        //intDifficultyLevel.clearSelection();
        
        //bNext.setEnabled(false);
                
        //Add elements to the panel
        pDifficultySelection.add(lDifficulty);
        pDifficultySelection.add(r1_Difficulty);
        pDifficultySelection.add(r2_Difficulty);
        pDifficultySelection.add(r3_Difficulty);
        
        //Create next button
        JButton bNext;
        bNext = new JButton();
        bNext.setText("Select");  
        bNext.setName("bSave");
        bNext.setBounds(320, 360, 80, 27);
        bNext.addActionListener(this);
        add(bNext);
        

        switch (informedDifficultyLevel)
        {
            case 1:
                r1_Difficulty.setSelected(true);
                break;
            case 2:
                r2_Difficulty.setSelected(true);
                break;
            case 3:
                r3_Difficulty.setSelected(true);
                break;
            default:
                break;
        }
    }

    @Override
    public void actionPerformed(ActionEvent ae) 
    {
        if (ae.getSource().getClass().toString().equals("class javax.swing.JButton"))
        {
            JButton bTemp = (JButton)ae.getSource();
            if (bTemp.getName().equals("bSave"))
            {
                if (intDifficultyLevel.getSelection()!=null)
                {
                    int DifficultyLevel = Integer.parseInt(intDifficultyLevel.getSelection().getActionCommand());
                    System.out.print("Difficulty Level is " + DifficultyLevel + "\r\n");

                    SetupWindow setup = (SetupWindow)this.getParent();
                    setup.DifficultyLevel = DifficultyLevel;
                    setup.bDifficulty.setVisible(true);
                    setup.bPlayers.setVisible(true);
                    if (setup.DifficultyLevel>0 && !setup.SelectedPlayers.isEmpty())
                    {                        
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

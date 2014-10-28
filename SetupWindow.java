/*
 * @Course: IST 240 (FA 14)
 * @Section: 001
 *
 * @Group 08
 */
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.awt.Color;

public class SetupWindow extends JPanel implements ActionListener {
    
    JButton bPlayers;
    JButton bDifficulty;
    DefaultListModel SelectedPlayers = new DefaultListModel();
    DefaultListModel ListOfAllPlayers = new DefaultListModel();
    myJFrame ParentFrame;
    int DifficultyLevel = 0;
    
    MenuDifficulty DifficultyMenu;
    MenuPlayers PlayerMenu;
    
    public SetupWindow(myJFrame mjf)
    {
        super();
        //setLayout(new GridLayout(2,2));
        setBackground(Color.BLUE);
        //setLayout(null);
        ParentFrame = mjf;
        
        bPlayers = new JButton();
        bPlayers.setText("Select Player(s)");
        bPlayers.setName("bPlayers");
        bPlayers.addActionListener(this);
        
        add(bPlayers);
        
        bDifficulty = new JButton();
        bDifficulty.setText("Select Difficulty");
        bDifficulty.setName("bDifficulty");
        bDifficulty.addActionListener(this);
        add(bDifficulty);    
        
        LoadDataFromXML();
    }

    @Override
    public void actionPerformed(ActionEvent e) 
    {
        Object obj = e.getSource();
        JButton bTemp;
        if  (obj.getClass().getName().equals("javax.swing.JButton"))
        {
            bTemp = (JButton)obj;
            bDifficulty.setVisible(false);
            bPlayers.setVisible(false);
        
            setLayout(null);
            switch (bTemp.getName())
            {
                case "bPlayers":            
                    bPlayers_Pressed();
                    break;

                case "bDifficulty":   
                    bDifficulty_Pressed();
                    break;
            }
        }
    }
    
    void bPlayers_Pressed()
    {
        PlayerMenu = new MenuPlayers(SelectedPlayers, ListOfAllPlayers);
        PlayerMenu.setVisible(true);
        add(PlayerMenu);
        PlayerMenu.setBounds(150, 50, 500, 500);
    }
    
    void bDifficulty_Pressed()
    {
        DifficultyMenu = new MenuDifficulty(DifficultyLevel);
        DifficultyMenu.setVisible(true);
        add(DifficultyMenu);
        DifficultyMenu.setBounds(150, 50, 500, 500);
    }

    void SaveDataInXML()
    {
        //save all players and their high score in XML (ListOfAllPlayers)
        //save difficulty level in XML (DifficultyLevel)
    }
    
    private void LoadDataFromXML()
    {
        //Load all players and their high score in listOfAllPlayers;        
    }
}

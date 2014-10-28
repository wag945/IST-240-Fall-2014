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
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class MenuPlayers extends JPanel implements ActionListener
{
    //int NumberOfPlayers;    
    ButtonGroup NumberOfPlayers; //used for radio button

    DefaultListModel SelectedPlayers; // used for saving selected players
    DefaultListModel listOfAllPlayers = new DefaultListModel(); //list of all Players using Player Class
    
    JPanel pPlayerSelection;
    JPanel pPlayerProfileMenu;
    JPanel pCreatePlayerProfile;
    
    JTextField tName;
    JLabel lError = new JLabel("");;
            
    JButton bNext;
    
    int intMenu = 0;
    int NumOfPlayers;
    
    PanelAnimate PanelToAnimate;
    
    public MenuPlayers(DefaultListModel previousSelectedPlayers, DefaultListModel previouslistOfAllPlayers) 
    {
        super();
        setLayout(null);
        setBackground(Color.gray);
                
        SelectedPlayers = new DefaultListModel();

        SelectedPlayers = previousSelectedPlayers;
        listOfAllPlayers = previouslistOfAllPlayers;
        
        CreatePlayerSelectionMenu();
        
        //Create next button
        bNext = new JButton();
        bNext.setText("Select");  
        bNext.setName("bNext");
        bNext.setBounds(320, 360, 80, 27);
        bNext.addActionListener(this);
        add(bNext);
        
    }
    
    private void CreatePlayerSelectionMenu()
    {
        intMenu = 1;
        //Create new panel that will hold 3 players option and a lable
        pPlayerSelection = new JPanel();
        pPlayerSelection.setOpaque(true);
        pPlayerSelection.setBackground(Color.BLACK);
        pPlayerSelection.setVisible(true);
        pPlayerSelection.setLayout(null);
        pPlayerSelection.setBounds(100, 50, 300, 300);
        add(pPlayerSelection);
        
        //Create Label
        JLabel lPlayer = new JLabel();
        lPlayer.setText("Select Number of Players:");
        
        //Create player choices
        JRadioButton r1_Player = new JRadioButton("One Player");
        JRadioButton r2_Player = new JRadioButton("Two Players");
        JRadioButton r3_Player = new JRadioButton("Three Players");
        
        r1_Player.setMnemonic(KeyEvent.VK_O);
        r2_Player.setMnemonic(KeyEvent.VK_W);
        r3_Player.setMnemonic(KeyEvent.VK_R);        
        
        r1_Player.setActionCommand("O");
        r2_Player.setActionCommand("W");
        r3_Player.setActionCommand("R");
        
        //r1_Player.setSelected(true);
        
        //Add player choices in a group
        NumberOfPlayers = new ButtonGroup();
        NumberOfPlayers.add(r1_Player);
        NumberOfPlayers.add(r2_Player);
        NumberOfPlayers.add(r3_Player);
        
        //SetLocation
        lPlayer.setBounds(50, 060, 200, 40);
        r1_Player.setBounds(50, 100, 200, 37);
        r2_Player.setBounds(50, 137, 200, 37);
        r3_Player.setBounds(50, 174, 200, 37);

        setOpaque(true);
        lPlayer.setOpaque(true);
        r1_Player.setOpaque(true);
        r2_Player.setOpaque(true);
        r3_Player.setOpaque(true);
        
        setBackground(Color.DARK_GRAY);
        lPlayer.setBackground(null);
        r1_Player.setBackground(null);
        r2_Player.setBackground(null);
        r3_Player.setBackground(null);
        
        
        lPlayer.setForeground(Color.white);
        r1_Player.setForeground(Color.white);
        r2_Player.setForeground(Color.white);
        r3_Player.setForeground(Color.white);

        //NumberOfPlayers.clearSelection();
        
        //bNext.setEnabled(false);
                
        //Add elements to the panel
        pPlayerSelection.add(lPlayer);
        pPlayerSelection.add(r1_Player);
        pPlayerSelection.add(r2_Player);
        pPlayerSelection.add(r3_Player);      
        
        //Load previous players on current run
        if (SelectedPlayers.getSize()>0)
        {
            switch (SelectedPlayers.getSize())
            {
                case 1:
                    r1_Player.setSelected(true);
                    break;
                case 2:
                    r2_Player.setSelected(true);
                    break;
                case 3:
                    r3_Player.setSelected(true);
                    break;
            }
        } 
    }
    
    private void CreatePlayerProfileMenu()
    {
        intMenu = 2;
        bNext.setText("Select"); 
       
        //Create new panel that will hold player profile name, a lable and a button to create new profile 
        pPlayerProfileMenu = new JPanel();
        pPlayerProfileMenu.setOpaque(true);
        pPlayerProfileMenu.setBackground(Color.BLACK);
        pPlayerProfileMenu.setVisible(true);
        pPlayerProfileMenu.setLayout(null);
        pPlayerProfileMenu.setBounds(100, 50, 300, 300);
        add(pPlayerProfileMenu);

        //Get list of players that already has profiles from XML
        
        //loop start
            //Player tempPlayer = new Player("Create Profile...",1);
            //listOfAllPlayers.addElement(tempPlayer.getPlayerName());
        //loop end

        
        
        //Create combo boxes based on number of players
        int lableLocationY=37;
        for (int p=1 ; p<=NumOfPlayers;p++)
        {
            lableLocationY+=37;
                    
            //Create label
            JLabel lPlayerName = new JLabel("Player " + p + " Name:");
            lPlayerName.setBounds(30, lableLocationY, 100, 27);
            lPlayerName.setForeground(Color.white);            
            pPlayerProfileMenu.add(lPlayerName);

            JComboBox tPlayerNames = new JComboBox();
            tPlayerNames.setBounds(120, lableLocationY, 130, 27);        
            tPlayerNames.setName("Player_"+p);
            
            for (Object obj : listOfAllPlayers.toArray())
            {        
                People pCurrent = (People)obj;
                pCurrent.getPlayerName();
                tPlayerNames.addItem(pCurrent.getPlayerName());
            }
            
            //tPlayerNames.addItem("");
            pPlayerProfileMenu.add(tPlayerNames);
            
        }
        
        JButton bCreatePlayer = new JButton("Create Player...");
        bCreatePlayer.setBounds(120, lableLocationY + 37, 130, 27); 
        bCreatePlayer.setName("bCreatePlayer");
        bCreatePlayer.addActionListener(this);
        pPlayerProfileMenu.add(bCreatePlayer);

        //Create label
        JLabel lPlayerSelection = new JLabel("Add Player:");
        lPlayerSelection.setBounds(5, 0, 280, 37);
        lPlayerSelection.setForeground(Color.white);
        pPlayerProfileMenu.add(lPlayerSelection);
        
        //Load previous players on current run   
        for (Object objPCheck : SelectedPlayers.toArray())
        {        
            People pCurrent = (People)objPCheck;
            switch (pCurrent.getPlayerNumber())
            {
                case 1:
                    for (Object o: pPlayerProfileMenu.getComponents())
                    {
                        if (o.getClass().getName().equals("javax.swing.JComboBox"))
                        {                                                    
                            JComboBox t = (JComboBox) o;
                            if (t.getName().equals("Player_1"))
                            {                                
                                t.setSelectedItem(pCurrent.getPlayerName());
                            }
                        }
                    }
                    break;
                case 2:
                    for (Object o: pPlayerProfileMenu.getComponents())
                    {
                        if (o.getClass().getName().equals("javax.swing.JComboBox"))
                        {                            
                            JComboBox t = (JComboBox) o;
                            if (t.getName().equals("Player_2"))
                            {                                
                                t.setSelectedItem(pCurrent.getPlayerName());
                            }
                        }
                    }
                    break;
                case 3:
                    for (Object o: pPlayerProfileMenu.getComponents())
                    {
                        if (o.getClass().getName().equals("javax.swing.JComboBox"))
                        {                            
                            JComboBox t = (JComboBox) o;
                            if (t.getName().equals("Player_3"))
                            {                                
                                t.setSelectedItem(pCurrent.getPlayerName());
                            }
                        }
                    }
                    break;
            }
        }
        
        lError.setBounds(40, 230, 280, 27);
        lError.setForeground(Color.red);
        lError.setText("");
        pPlayerProfileMenu.add(lError);
        
    }
     
    private void CreatePlayerProfile() 
    {
        intMenu = 3;
        bNext.setText("Cancel"); 
        
        //Create new panel that will hold player profile name input, a lable and image selection
        pCreatePlayerProfile = new JPanel();        
        pCreatePlayerProfile.setOpaque(true);
        pCreatePlayerProfile.setBackground(Color.BLACK);
        pCreatePlayerProfile.setVisible(true);
        pCreatePlayerProfile.setLayout(null);
        pCreatePlayerProfile.setBounds(100, 50, 300, 300);
        add(pCreatePlayerProfile);
        
        //Create label
        JLabel CreatePlayerProfile = new JLabel("Create Profile");
        CreatePlayerProfile.setBounds(5, 0, 280, 37);
        CreatePlayerProfile.setForeground(Color.white);
        pCreatePlayerProfile.add(CreatePlayerProfile);
        
        //Create label
        JLabel lPlayerName = new JLabel("Player Name:");
        lPlayerName.setBounds(10, 64, 100, 27);
        lPlayerName.setForeground(Color.white);
        pCreatePlayerProfile.add(lPlayerName);

        tName = new JTextField();
        tName.setBounds(100, 64, 110, 27);        
        pCreatePlayerProfile.add(tName);

        JButton bAdd = new JButton("Add");
        bAdd.setBounds(220, 64, 60, 27); 
        bAdd.setName("bAdd");
        bAdd.addActionListener(this);
        pCreatePlayerProfile.add(bAdd);
                
        //Create error lable
        lError.setBounds(10, 130, 280, 27);
        lError.setForeground(Color.red);
        pCreatePlayerProfile.add(lError);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) 
    {                
        Object obj = e.getSource();
        JButton tempButton = null;
        String bName = "";
        
        lError.setText("");
        
        if (obj.getClass().getName().equals("javax.swing.JButton"))
        {
            tempButton = (JButton) obj;
            bName  = tempButton.getName();
        }
        
        switch (bName) 
        {
            case "bNext":
                switch (intMenu)
                {
                    case 1:
                        if (NumberOfPlayers.getSelection()!=null)
                        {
                            switch (NumberOfPlayers.getSelection().getActionCommand())
                            {
                                case "O":
                                    NumOfPlayers =1;
                                    break;
                                case "W":
                                    NumOfPlayers =2;
                                    break;
                                case "R":
                                    NumOfPlayers =3;
                                    break;
                            }
                            System.out.print("Number of player(s): " + NumOfPlayers + "\r\n");
                            PanelToAnimate = new PanelAnimate(1,pPlayerSelection);
                            PanelToAnimate.SlideLeft();
                            //bNext.setEnabled(false);
                            CreatePlayerProfileMenu();
                        }
                        break;
                    case 2:
                    case 3:
                        SelectedPlayers = new DefaultListModel();
                        for (Object o: pPlayerProfileMenu.getComponents())
                        {
                            if (o.getClass().getName().equals("javax.swing.JComboBox"))
                            {
                                //get selected players
                                JComboBox t = (JComboBox) o;
                                
                                for (Object objP : listOfAllPlayers.toArray())
                                {        
                                    People pCurrent = (People)objP;
                                    if (t.getSelectedItem().equals(pCurrent.getPlayerName()))
                                    {
                                        boolean AlreadyAdded = false;
                                        //This loop check if the player is already added to player list or not
                                        for (Object objPCheck : SelectedPlayers.toArray())
                                        {        
                                            People pCurrentCheck = (People)objPCheck;
                                            if (pCurrent.getPlayerName().equals(pCurrentCheck.getPlayerName()))
                                            {
                                                AlreadyAdded = true;
                                                break;
                                            }
                                        }
                                        if (!AlreadyAdded)
                                        {
                                            //Adds the player if its not in current play list
                                            SelectedPlayers.addElement(pCurrent);
                                            pCurrent.setPlayerNumber(Integer.parseInt(t.getName().replaceAll("Player_", "")));
                                        }
                                        break;
                                    }
                                }
                            }
                        }
                        if (intMenu == 3)
                        {
                            intMenu = 2;
                            hidepCreatePlayerProfile();
                            CreatePlayerProfileMenu();
                        }
                        else if (SelectedPlayers.getSize()<NumOfPlayers)
                        {
                            if (NumOfPlayers==1)
                            {
                                lError.setText("Please select a player.");                            
                            }
                            else
                            {
                                lError.setText("Please select " + NumOfPlayers + " different players.");                            
                            }
                            intMenu = 2;                            
                        }
                        else
                        {
                            intMenu = 4;
                            System.out.println("\r\n\r\nSave Players\r\n");
                            SetupWindow setup = (SetupWindow)this.getParent();
                            setup.SelectedPlayers = SelectedPlayers;
                            setup.ListOfAllPlayers = listOfAllPlayers;
                            setup.bDifficulty.setVisible(true);
                            setup.bPlayers.setVisible(true);
                            if (setup.DifficultyLevel>0 && !setup.SelectedPlayers.isEmpty())
                            {                        
                                setup.ParentFrame.introductionWindow.newGameButton.setEnabled(true);
                                //SaveDataInXML();
                            }
                            //this.removeAll();
                            PanelToAnimate = new PanelAnimate(1,this);
                            PanelToAnimate.RemovePanelAfterAnimation(true);
                            PanelToAnimate.SlideLeft();
                        }
                        break;
                     case 4:
                         break;
                }   
                break;
                
            case "bCreatePlayer":
                PanelToAnimate = new PanelAnimate(1,pPlayerProfileMenu);
                PanelToAnimate.SlideLeft();
                CreatePlayerProfile();
                break;
                
            case "bAdd":
                if (!tName.getText().trim().equals(""))
                {
                    People tempPlayer = new People(tName.getText(),1);
                    boolean pFound = false;
                    for (Object pExistObj: listOfAllPlayers.toArray())
                    {
                        People pCurrent = (People)pExistObj;
                        if (pCurrent.getPlayerName().equals(tName.getText()))
                        {
                            pFound = true;
                            break;
                        }
                    }
                    if (!pFound) //if player already exist, dont add
                    {
                        listOfAllPlayers.addElement(tempPlayer);
                    
                        hidepCreatePlayerProfile();
                        CreatePlayerProfileMenu();
                    }
                    else                        
                    {
                        lError.setText("<html>That name already exists!<br>Please try another name or use existing one.");
                    }
                }
                break;
        }
    }
    
    void hidepCreatePlayerProfile()
    {
        PanelToAnimate = new PanelAnimate(1,pCreatePlayerProfile);
        PanelToAnimate.SlideLeft();

        pPlayerProfileMenu.removeAll();
        pPlayerProfileMenu = null;
    }
}

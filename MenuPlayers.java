/*
 * @Course: IST 240 (FA 14)
 * @Section: 001
 *
 * @Group 08
 */
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
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

    PlayersList SelectedPlayers; // used for saving selected players
    PlayersList listOfAllPlayers = new PlayersList(); //list of all Players using Player Class
    
    JPanel pPlayerSelection;
    JPanel pPlayerProfileMenu;
    JPanel pCreatePlayerProfile;
    
    JTextField tName;
    JLabel lError = new JLabel("");;
            
    JButton bNext;
    JButton bCreatePlayer;
    JButton bAdd;
    
    int intMenu = 0;
    int NumOfPlayers;
    
    PanelAnimate PanelToAnimate;
    
    public MenuPlayers(PlayersList previousSelectedPlayers, PlayersList previouslistOfAllPlayers, Color ThemeColor) 
    {
        super();
        setLayout(null);
        setBackground(Color.gray);
                
        SelectedPlayers = new PlayersList();

        SelectedPlayers = previousSelectedPlayers;
        listOfAllPlayers = previouslistOfAllPlayers;
        
        CreatePlayerSelectionMenu();
        
        //Create next button
        bNext = new JButton();
        bNext.setText("Select");  
        bNext.setName("bNext");
        bNext.setBounds(324, 420, 80, 27);
        bNext.addActionListener(this);
        add(bNext);
        
        bCreatePlayer = new JButton("Create Player...");
        bAdd = new JButton("Add");
        
        setTheme(ThemeColor);
    }
    
    public void setTheme(Color ThemeColor)
    {
        Color bColor = ThemeColor.darker();
        Color fColor = bColor.brighter().brighter().brighter().brighter().brighter();

        bNext.setBackground(bColor);
        bNext.setForeground(fColor);
        bCreatePlayer.setBackground(bColor);
        bCreatePlayer.setForeground(fColor);
        bAdd.setBackground(bColor);
        bAdd.setForeground(fColor);
    }
    
    private void CreatePlayerSelectionMenu()
    {
        intMenu = 1;
        //Create new panel that will hold 3 players option and a lable
        pPlayerSelection = new JPanel();
        pPlayerSelection.setOpaque(true);
        pPlayerSelection.setBackground(Color.gray);
        pPlayerSelection.setBorder(BorderFactory.createLineBorder(Color.black));
        pPlayerSelection.setVisible(true);
        pPlayerSelection.setLayout(null);
        pPlayerSelection.setBounds(105, 60, 300, 350);
        add(pPlayerSelection);
        
        //Create Label
        //JLabel lPlayer = new JLabel();
        //lPlayer.setText("Select Number of Players:");
        Font font = new Font(Font.SANS_SERIF, Font.BOLD, 28);      

        JLabel lHeading = new JLabel();
        lHeading.setText("Number of Players");
        lHeading.setForeground(Color.white);
        lHeading.setFont(font);
        lHeading.setBounds(126, 10, 300, 36);
        lHeading.setVisible(true);
        add(lHeading);
        
        //Create player choices
        JRadioButton r1_Player = new JRadioButton("One Player");
        JRadioButton r2_Player = new JRadioButton("Two Players");
        JRadioButton r3_Player = new JRadioButton("Three Players");
        
        font = new Font(Font.SANS_SERIF, Font.BOLD, 14);
        r1_Player.setFont(font);
        r2_Player.setFont(font);
        r3_Player.setFont(font);
        
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
        //lPlayer.setBounds(50, 060, 200, 40);
        r1_Player.setBounds(50, 70, 200, 37);
        r2_Player.setBounds(50, 137, 200, 37);
        r3_Player.setBounds(50, 204, 200, 37);

        setOpaque(true);
        //lPlayer.setOpaque(true);
        r1_Player.setOpaque(true);
        r2_Player.setOpaque(true);
        r3_Player.setOpaque(true);
        
        setBackground(Color.DARK_GRAY);
        //lPlayer.setBackground(null);
        r1_Player.setBackground(null);
        r2_Player.setBackground(null);
        r3_Player.setBackground(null);
        
        
        //lPlayer.setForeground(Color.white);
        r1_Player.setForeground(Color.white);
        r2_Player.setForeground(Color.white);
        r3_Player.setForeground(Color.white);

        //NumberOfPlayers.clearSelection();
        
        //bNext.setEnabled(false);
                
        //Add elements to the panel
        //pPlayerSelection.add(lPlayer);
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
        pPlayerProfileMenu.setBackground(Color.gray);
        pPlayerProfileMenu.setBorder(BorderFactory.createLineBorder(Color.black));
        pPlayerProfileMenu.setVisible(true);
        pPlayerProfileMenu.setLayout(null);
        pPlayerProfileMenu.setBounds(105, 60, 300, 350);
        add(pPlayerProfileMenu);

        //Create combo boxes based on number of players
        int lableLocationY=27;
        for (int p=1 ; p<=NumOfPlayers;p++)
        {
            lableLocationY+=47;
                    
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
                Person pCurrent = (Person)obj;
                pCurrent.getName();
                tPlayerNames.addItem(pCurrent.getName());
                if (pCurrent.getPlayer() == p)
                {
                    tPlayerNames.setSelectedItem(pCurrent.getName());
                }
            }            
            
            pPlayerProfileMenu.add(tPlayerNames);
            
        }
        
        bCreatePlayer.setBounds(120, lableLocationY + 47, 130, 27); 
        bCreatePlayer.setName("bCreatePlayer");
        bCreatePlayer.addActionListener(this);
        pPlayerProfileMenu.add(bCreatePlayer);

        //Create label
//        JLabel lPlayerSelection = new JLabel("Add Player:");
//        lPlayerSelection.setBounds(5, 0, 280, 37);
//        lPlayerSelection.setForeground(Color.white);
//        pPlayerProfileMenu.add(lPlayerSelection);
        
        //Load previous players on current run   
        for (Object objPCheck : SelectedPlayers.toArray())
        {        
            Person pCurrent = (Person)objPCheck;
            switch (pCurrent.getPlayer())
            {
                case 1:
                    for (Object o: pPlayerProfileMenu.getComponents())
                    {
                        if (o.getClass().getName().equals("javax.swing.JComboBox"))
                        {                                                    
                            JComboBox t = (JComboBox) o;
                            if (t.getName().equals("Player_1"))
                            {                                
                                t.setSelectedItem(pCurrent.getName());
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
                                t.setSelectedItem(pCurrent.getName());
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
                                t.setSelectedItem(pCurrent.getName());
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
        if (pCreatePlayerProfile!=null)
        {
            this.remove(pCreatePlayerProfile);
        }
        pCreatePlayerProfile = new JPanel();        
        pCreatePlayerProfile.setOpaque(true);
        pCreatePlayerProfile.setBackground(Color.gray);
        pCreatePlayerProfile.setVisible(true);
        pCreatePlayerProfile.setLayout(null);
        pCreatePlayerProfile.setBounds(105, 60, 300, 350);
        add(pCreatePlayerProfile);
        
        //Create label
//        JLabel CreatePlayerProfile = new JLabel("Create Profile");
//        CreatePlayerProfile.setBounds(5, 0, 280, 37);
//        CreatePlayerProfile.setForeground(Color.white);
//        pCreatePlayerProfile.add(CreatePlayerProfile);
        
        //Create label
        JLabel lPlayerName = new JLabel("Player Name:");
        lPlayerName.setBounds(10, 64, 100, 27);
        lPlayerName.setForeground(Color.white);
        pCreatePlayerProfile.add(lPlayerName);

        tName = new JTextField();
        tName.setBounds(100, 64, 110, 27);        
        pCreatePlayerProfile.add(tName);

        bAdd.setBounds(220, 64, 60, 27); 
        bAdd.setName("bAdd");
        bAdd.addActionListener(this);
        pCreatePlayerProfile.add(bAdd);
                
        //Create error lable
        lError.setBounds(10, 130, 280, 27);
        lError.setForeground(Color.red);
        pCreatePlayerProfile.add(lError);
        
        pCreatePlayerProfile.setBorder(BorderFactory.createLineBorder(Color.black));
        this.repaint();
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
                        SelectedPlayers = new PlayersList();
                        for (Object o: pPlayerProfileMenu.getComponents())
                        {
                            if (o.getClass().getName().equals("javax.swing.JComboBox"))
                            {
                                //get selected players
                                JComboBox t = (JComboBox) o;
                                
                                for (Object objP : listOfAllPlayers.toArray())
                                {        
                                    Person pCurrent = (Person)objP;
                                    if (t.getSelectedItem().equals(pCurrent.getName()))
                                    {
                                        boolean AlreadyAdded = false;
                                        //This loop check if the player is already added to player list or not
                                        for (Object objPCheck : SelectedPlayers.toArray())
                                        {        
                                            Person pCurrentCheck = (Person)objPCheck;
                                            if (pCurrent.getName().equals(pCurrentCheck.getName()))
                                            {
                                                AlreadyAdded = true;
                                                break;
                                            }
                                        }
                                        if (!AlreadyAdded)
                                        {
                                            //Adds the player if its not in current play list
                                            SelectedPlayers.addElement(pCurrent);
                                            pCurrent.setPlayer(Integer.parseInt(t.getName().replaceAll("Player_", "")));
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
                            setup.colorSelection.setVisible(true);
                            setup.bPlayers.setVisible(true);
                            if (setup.DifficultyLevel>0 && !setup.SelectedPlayers.isEmpty())
                            {                        
                                setup.ParentFrame.introductionWindow.newGameButton.setEnabled(true);
                                setup.SaveDataInXML();
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
                    Person tempPlayer = new Person(tName.getText(),1,listOfAllPlayers.getSize());
                    boolean pFound = false;
                    for (Object pExistObj: listOfAllPlayers.toArray())
                    {
                        Person pCurrent = (Person)pExistObj;
                        if (pCurrent.getName().equals(tName.getText()))
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
        PanelToAnimate.RemovePanelAfterAnimation(true);
        PanelToAnimate.SlideLeft();

        pPlayerProfileMenu.removeAll();
        pPlayerProfileMenu = null;
    }
}

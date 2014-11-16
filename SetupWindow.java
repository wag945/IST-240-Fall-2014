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
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.logging.Level;
import java.util.logging.Logger;

public class SetupWindow extends JPanel implements ActionListener 
{
    JButton bPlayers;
    JButton bDifficulty;
    JButton colorSelection;
    PlayersList SelectedPlayers = new PlayersList();
    PlayersList ListOfAllPlayers = new PlayersList();
    myJFrame ParentFrame;
    int DifficultyLevel = 1; //Set level to K12 by default
    int ColorSelection = 1; //Set color blue by default
    
    MenuDifficulty DifficultyMenu;
    MenuPlayers PlayerMenu;
    ColorSelection ColorSelectionMenu;
    
    public SetupWindow(myJFrame mjf)
    {
        super();
        //setLayout(new GridLayout(2,2));
        setBackground(Color.DARK_GRAY);
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
        
        colorSelection = new JButton();
        colorSelection.setText("Color Options");
        colorSelection.setName("colorSelection");
        colorSelection.addActionListener(this);
        add(colorSelection);
        
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
            colorSelection.setVisible(false);
        
            setLayout(null);
            switch (bTemp.getName())
            {
                case "bPlayers":            
                    bPlayers_Pressed();
                    break;

                case "bDifficulty":   
                    bDifficulty_Pressed();
                    break;
                    
                case "colorSelection":
                    colorSelection_Pressed();
                    break;
            }
        }
    }
    
    void bPlayers_Pressed()
    {
        PlayerMenu = new MenuPlayers(SelectedPlayers, ListOfAllPlayers);
        PlayerMenu.setVisible(true);
        add(PlayerMenu);
        PlayerMenu.setBounds(148, 50, 500, 500);
    }
    
    void bDifficulty_Pressed()
    {
        DifficultyMenu = new MenuDifficulty(DifficultyLevel);
        DifficultyMenu.setVisible(true);
        add(DifficultyMenu);
        DifficultyMenu.setBounds(148, 50, 500, 500);
    }
    
    void colorSelection_Pressed()
    {
        ColorSelectionMenu = new ColorSelection(ColorSelection);
        ColorSelectionMenu.setVisible(true);
        add(ColorSelectionMenu);
        ColorSelectionMenu.setBounds(148, 50, 500, 500);
    }

    void SaveDataInXML()
    {        
        //save all players and their high score in XML (ListOfAllPlayers)
        //save difficulty level in XML (DifficultyLevel)
        XML_240 XMLWriter = new XML_240();

        XMLWriter.openWriterXML("//settings//setup.xml");
        XMLWriter.writeObject(ListOfAllPlayers);
        XMLWriter.writeObject(SelectedPlayers);
        XMLWriter.writeObject(DifficultyLevel);
//        XMLWriter.writeObject(ColorSelectionMenu);
        XMLWriter.closeWriterXML();
        
        UploadSetupXML();        
    }
    
    private void UploadSetupXML()
    {
        InputStream f;
        try 
        {
            f = new FileInputStream(System.getProperty("user.dir") + "\\settings\\setup.xml");
            FTP_javabeat fUpload = new FTP_javabeat ();
            try {
                fUpload.upload("ftp.ai-dot.net", "xml%40ai-dot.net ", "XMLReadWrite!1", "setup.xml", f);
            } catch (IOException ex) {
                Logger.getLogger(SetupWindow.class.getName()).log(Level.SEVERE, null, ex);
            }
        } 
        catch (FileNotFoundException ex) 
        {
            Logger.getLogger(SetupWindow.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void LoadDataFromXML()
    {         
        DownloadSetupXML();
        
        //Load all players and their high score in ListOfAllPlayers;        
        XML_240 XMLReader = new XML_240();
        XMLReader.openReaderXML("\\settings\\setup.xml");
        ListOfAllPlayers = (PlayersList) XMLReader.ReadObject();
        SelectedPlayers = (PlayersList) XMLReader.ReadObject();
        Object tempObj = XMLReader.ReadObject();
        if (tempObj!=null)
        {
            DifficultyLevel = (int)tempObj;
        }

        if (ListOfAllPlayers == null)
        {
            ListOfAllPlayers = new PlayersList();
        }

        if (SelectedPlayers == null)
        {
            SelectedPlayers = new PlayersList();
        }
        
        XMLReader.closeReaderXML();
    }
    
    private void DownloadSetupXML()
    {
        File dir = new File("settings");
        if (!dir.exists())
        {
            dir.mkdir();
        }
        
        FileOutputStream f;
        try 
        {
            f = new FileOutputStream(System.getProperty("user.dir") + "\\settings\\setup.xml");
            FTP_javabeat fDownload = new FTP_javabeat ();
            try 
            {
                fDownload.download("ftp.ai-dot.net", "xml%40ai-dot.net ", "XMLReadWrite!1", "setup.xml", f);
            } 
            catch (IOException ex) 
            {
                Logger.getLogger(SetupWindow.class.getName()).log(Level.SEVERE, null, ex);
            }
        } 
        catch (FileNotFoundException ex) 
        {
            Logger.getLogger(SetupWindow.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}

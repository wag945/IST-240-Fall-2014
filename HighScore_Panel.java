/*
 * @Course: IST 240 (FA 14)
 * @Section: 001
 *
 * @Group 08
 */

import java.awt.Color;
import java.awt.Font;
import java.util.Arrays;
import java.util.Date;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class HighScore_Panel extends JPanel
{
    JLabel lHeading;
    
    
    HighScore_Panel(PlayersList ListOfAllPlayers, String Heading, boolean AllTime)
    {
        super();
        setLayout(null);
        setBackground(Color.gray);
        
        Font font = new Font(Font.SANS_SERIF, Font.BOLD, 28);      
        
        lHeading = new JLabel();
        lHeading.setText(Heading);
        
        lHeading.setFont(font);
        if (AllTime)
        {
            lHeading.setBounds(112, 10, 300, 36);
        }
        else
        {
            lHeading.setBounds(117, 10, 300, 36);
        }
        lHeading.setVisible(true);
        add(lHeading);
        
        JPanel scoreListDisplay = new JPanel();

        scoreListDisplay.setLayout(null);
        scoreListDisplay.setBounds(105, 60, 300, 350);
        add(scoreListDisplay);
        
        int lY = 30; // initial label
        int lX = 30; // initial label
        JLabel[] lNum = new JLabel[10];
        JLabel[] lName = new JLabel[10];
        JLabel[] lScore = new JLabel[10];        
        
        String[][] ArrayOfPlayersAndScores = GetScores(ListOfAllPlayers, AllTime);
        
        if (ArrayOfPlayersAndScores!=null)
        {
            for(int i=0; i<10 ; i++) //reverse order of array
            {                  
                lNum[i] = new JLabel();
                lNum[i].setName("lNum_" + (i+1));                
                lNum[i].setText("" + (i+1));
                lNum[i].setBounds(lX, lY, 16, 27);
                scoreListDisplay.add(lNum[i]);        

                lName[i] = new JLabel();
                lName[i].setName("lName_" + (i+1));                
                lName[i].setText(ArrayOfPlayersAndScores[i][0]);
                lName[i].setBounds(lX + 30, lY, 150, 27);
                scoreListDisplay.add(lName[i]);        

                lScore[i] = new JLabel();
                lScore[i].setName("lScore_" + (i+1));
                lScore[i].setText(ArrayOfPlayersAndScores[i][1].trim());
                lScore[i].setBounds(lX + 170, lY, 140, 27);
                scoreListDisplay.add(lScore[i]);
                lY += 30;   

                if (ArrayOfPlayersAndScores[i+1][0] == null)
                {
                    break;
                }
            }
        }

    }

    private String[][] GetScores(PlayersList ListOfAllPlayers, boolean AllTime)  
    {
        int PlayerCount = ListOfAllPlayers.toArray().length;
        String[][] ArrayOfAllPlayersAndScores = new String [PlayerCount][2];
        Date date = new Date();

        int i=0;
        for (Object obj : ListOfAllPlayers.toArray()) // Extract score from each person
        {            
            Person pCurrent = (Person)obj;
            if (AllTime)
            {                
                ArrayOfAllPlayersAndScores[i][0] = pCurrent.getName().toUpperCase();
                ArrayOfAllPlayersAndScores[i][1] = String.format("%,10d", pCurrent.getScore()); //formats score in 10 digit string with commas
                i++;
            }            
            else
            {                
                if (pCurrent.getDateLastPlayed() != null)
                {
                    if (date.equals(pCurrent.getDateLastPlayed()))
                    {
                        ArrayOfAllPlayersAndScores[i][0] = pCurrent.getName().toUpperCase();
                        ArrayOfAllPlayersAndScores[i][1] = String.format("%,10d", pCurrent.getScore()); //formats score in 10 digit string with commas
                        i++;                
                    }
                }
            }            
        }  
        
        if (i>0)
        {
            //Sorts multidimension array in assending order using scores column
            Arrays.sort(ArrayOfAllPlayersAndScores, new ColumnComparator(1));

            String[][] ArrayOfPlayersAndScores = new String [10][2];               
            i=0;
            for(int r=PlayerCount-1; r>=0 ; r--) //reverse order of array
            {
                ArrayOfPlayersAndScores[i][0] = ArrayOfAllPlayersAndScores[r][0];
                ArrayOfPlayersAndScores[i][1] = ArrayOfAllPlayersAndScores[r][1];
                i++;
                if (i==10)
                {
                    break;
                }
            }   
        
            return ArrayOfPlayersAndScores;
        }
        else
        {
            return null;
        }        
    }
}


//                FOREACH
//                for (String row1 : row) { 
//                    System.out.print(row1 + " | ");
//                }
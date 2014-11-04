
import java.util.Date;

/*
 * @Course: IST 240 (FA 14)
 * @Section: 001
 *
 * @Group 08
 */

/**
 * This class is used keep the user info together
 */
public class Person 
{
    private String Name;
    private Integer Score;
    private int Level;
    private int Player;
    private Date DateLastPlayed;
    
    public Person()
    {        
    }
    
    public Person(String informedName, int informedLevel, int informedPlayerCount)
    {
        super();
        Name = informedName;
        Level = informedLevel;
        Player = informedPlayerCount+1;
        DateLastPlayed = new Date();
    } 

    /**
     * @return the Name
     */
    public String getName() {
        return Name;
    }

    /**
     * @param Name the Name to set
     */
    public void setName(String Name) {
        this.Name = Name;
    }

    /**
     * @return the Score
     */
    public int getScore() {
         if (Score != null)
        {
            return Score;
        }
        else
        {
            return 0;
        }
    }

    /**
     * @param Score the Score to set
     */
    public void setScore(int Score) {
        this.Score = Score;
    }

    /**
     * @return the Level
     */
    public int getLevel() {
        return Level;
    }

    /**
     * @param Level the Level to set
     */
    public void setLevel(int Level) {
        this.Level = Level;
    }

    /**
     * @return the Player
     */
    public int getPlayer() {
        return Player;
    }

    /**
     * @param Player the Player to set
     */
    public void setPlayer(int Player) {
        this.Player = Player;
    }

    /**
     * @return the DateLastPlayed
     */
    public Date getDateLastPlayed() {
        return DateLastPlayed;
    }

    /**
     * @param DateLastPlayed the DateLastPlayed to set
     */
    public void setDateLastPlayed(Date DateLastPlayed) {
        this.DateLastPlayed = DateLastPlayed;
    }

   
}

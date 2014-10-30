/*
 * @Course: IST 240 (FA 14)
 * @Section: 001
 *
 * @Group 08
 */
public class Person 
{
    private String Name;
    private int Score;
    private int Level;
    private int Player;
    
    public Person()
    {        
    }
    
    public Person(String informedName, int informedLevel, int informedPlayerCount)
    {
        super();
        Name = informedName;
        Level = informedLevel;
        Player = informedPlayerCount+1;
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
        return Score;
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
   
}

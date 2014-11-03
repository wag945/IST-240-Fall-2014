/*
 * @Course: IST 240 (FA 14)
 * @Section: 001
 *
 * @Group 08
 */
public class People 
{
    private String strName;
    private int intScore;
    private int intLevel;
    private int intPlayer;
    
    People(String informedName, int informedLevel)
    {
        strName = informedName;
        intLevel = informedLevel;
        intScore = 0;    
    }    
    
    public void setHighScore (int informedScore)
    {
        intScore = informedScore;
    }
    
    public int getHighScore()
    {
        return intScore;
    }
    
    public int getPlayerNumber()
    {
        return intPlayer;
    }
    
    public String getPlayerName()
    {
        return strName;
    }
    
    public int getPlayerLevel()
    {
        return intLevel;
    }
    
    public void setPlayerNumber(int informedPlayerNumber)
    {
        intPlayer = informedPlayerNumber;
    }
    
    public int getLastLevelPlayed()
    {
        return intLevel;
    }
}

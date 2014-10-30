/*
 * @Course: IST 240 (FA 14)
 * @Section: 001
 *
 * @Group 08
 */

import javax.swing.DefaultListModel;

public class PlayersList extends DefaultListModel
{            
    public PlayersList()
    {
    }
    
    public PlayersList(boolean b)
    {
        super();        
    }
    
    public void add(Person p)
    {
        this.addElement(p);
    }

}

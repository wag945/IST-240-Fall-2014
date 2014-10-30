
import javax.swing.DefaultListModel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author zfayaz
 */
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

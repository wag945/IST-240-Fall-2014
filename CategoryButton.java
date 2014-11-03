/*
 * @Course: IST 240 (FA 14)
 * @Section: 001
 *
 * @Group 08
 */
import java.awt.Color;
import java.awt.Font;
import javax.swing.JButton;

public class CategoryButton extends JButton {

    public CategoryButton(String text)
    {
        super();
        setBackground(new Color(105, 105, 105, 255));
        setFont(new Font("Dialog", 1, 20));
        this.setForeground(new Color(0, 206, 209, 255));
        
        //this.setDisabledIcon(correctIcon);
        //this.setDisabledIcon(incorrectIcon);
        setText("<html>" + text + "</html>"); //html tag turns on text wrapping
    }
}

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
        setFont(new Font("Dialog", 1, 20));
        setText(text);
    }
}

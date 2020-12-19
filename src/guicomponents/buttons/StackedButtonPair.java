import javax.swing.*;
import java.awt.*;

public class StackedButtonPair extends JPanel {

    public StackedButtonPair(JButton[] buttons, Color color){
        setBackground(color);
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        for(JButton b : buttons){
            b.setAlignmentX(Component.CENTER_ALIGNMENT);
            b.setAlignmentY(Component.CENTER_ALIGNMENT);
            add(b);
        }

    }

}

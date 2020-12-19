import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EndTrackButton extends JButton implements ActionListener {

    MainPanel game;

    public EndTrackButton(String text, MainPanel mainPanel){
        super(text);
        game = mainPanel;
        addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        game.endTracking();
    }
}

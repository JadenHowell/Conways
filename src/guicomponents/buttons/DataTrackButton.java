import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DataTrackButton extends JButton implements ActionListener {

    MainPanel game;

    public DataTrackButton(String text, MainPanel mainPanel){
        super(text);
        game = mainPanel;
        addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        game.startTracking();
    }
}

import buttons.PauseButton;
import buttons.PlayButton;

import javax.swing.JButton;
import javax.swing.JPanel;
import java.awt.*;

public class LowerPanel extends JPanel {

    JButton pauseButton, playButton;

    public LowerPanel(MainPanel mainPanel){
        setup(mainPanel);
    }

    private void setup(MainPanel mainPanel){
        setBackground(Color.orange);
        pauseButton = new PauseButton("Pause", mainPanel);
        playButton = new PlayButton("Play", mainPanel);
        add(playButton);
        add(pauseButton);
    }

}

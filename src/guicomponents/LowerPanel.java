import javax.swing.JButton;
import javax.swing.JPanel;
import java.awt.*;

public class LowerPanel extends JPanel {

    JButton pauseButton, playButton, clearButton;

    public LowerPanel(MainPanel mainPanel){
        setup(mainPanel);
    }

    private void setup(MainPanel mainPanel){
        setBackground(Color.orange);
        pauseButton = new PauseButton("Pause", mainPanel);
        playButton = new PlayButton("Play", mainPanel);
        clearButton = new ClearButton("Clear", mainPanel);
        add(playButton);
        add(pauseButton);
        add(clearButton);
    }

}

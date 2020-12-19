import javax.swing.JButton;
import javax.swing.JPanel;
import java.awt.*;

public class LowerPanel extends JPanel {

    JButton pauseButton, playButton, clearButton, randomButton, trackButton, endTrackButton,continueTrackButton;
    JPanel dataPair, flowPair, statePair;
    Color color = Color.orange;

    public LowerPanel(MainPanel mainPanel){
        setup(mainPanel);
    }

    private void setup(MainPanel mainPanel){
        setBackground(color);
        pauseButton = new PauseButton("Pause", mainPanel);
        playButton = new PlayButton("Play", mainPanel);
        clearButton = new ClearButton("Clear", mainPanel);
        randomButton = new RandomButton("Randomize", mainPanel);
        trackButton = new DataTrackButton("Start tracking", mainPanel);
        endTrackButton = new EndTrackButton("Stop tracking", mainPanel);
        continueTrackButton = new ContinueTrackButton("Continue tracking", mainPanel);

        JButton[] flows = new JButton[]{playButton, pauseButton};
        JButton[] data = new JButton[]{trackButton, endTrackButton, continueTrackButton};
        JButton[] state = new JButton[]{clearButton, randomButton};

        //TODO: Figure out how to center all the buttons both vertically and horizontally.

        flowPair = new StackedButtonPair(flows, color);
        dataPair = new StackedButtonPair(data, color);
        statePair = new StackedButtonPair(state, color);
        add(flowPair);
        add(dataPair);
        add(statePair);
    }

}

import javax.swing.JFrame;
import java.awt.*;

public class GUI {

    JFrame frame;
    Dimension screenSize;
    MainPanel mainPanel;
    LowerPanel lowerPanel;

    public GUI(){
        screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        frame = new CanvasFrame(screenSize);

        mainPanel = new MainPanel(screenSize);
        lowerPanel = new LowerPanel();

        frame.add(mainPanel);
        frame.add(lowerPanel);
    }

}

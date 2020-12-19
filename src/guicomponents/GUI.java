import javax.swing.*;
import java.awt.*;

public class GUI {

    JFrame frame;
    Dimension screenSize;
    MainPanel mainPanel;
    LowerPanel lowerPanel;

    public GUI(){
        screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        frame = new CanvasFrame("Conway's Game of Life", screenSize);
        frame.setLayout(new BorderLayout());

        mainPanel = new MainPanel(screenSize);
        frame.add(mainPanel, BorderLayout.CENTER);


        lowerPanel = new LowerPanel(mainPanel);
        frame.add(lowerPanel, BorderLayout.SOUTH);

        frame.setLocationRelativeTo(null); //This centers it in the screen for some reason
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

}

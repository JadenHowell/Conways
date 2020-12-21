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
        //frame.add(mainPanel, BorderLayout.CENTER);
        lowerPanel = new LowerPanel(mainPanel);
        //frame.add(lowerPanel, BorderLayout.SOUTH);

        //Using a splitPane allows for dynamically sized panels, without messing around with ugly layouts. Ew.
        JSplitPane splitPane = new JSplitPane();
        frame.getContentPane().add(splitPane);
        splitPane.setOrientation(JSplitPane.VERTICAL_SPLIT);
        splitPane.setDividerSize(5);
        splitPane.setDividerLocation((int)screenSize.getHeight()-200); //This and the following line make the bottom panel the correct size, and resize it well.
        splitPane.setResizeWeight(1.0);
        splitPane.setTopComponent(mainPanel);
        splitPane.setBottomComponent(lowerPanel);
        splitPane.setEnabled(false);


        frame.setLocationRelativeTo(null); //This centers it in the screen for some reason
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

}

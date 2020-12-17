import javax.swing.JFrame;
import java.awt.*;

public class CanvasFrame extends JFrame {

    public CanvasFrame(){
        setSize(1300, 800);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public CanvasFrame(Dimension screenSize){
        setSize((int)screenSize.getWidth(), (int)screenSize.getHeight());
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }


}

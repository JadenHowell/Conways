import javax.swing.*;
import java.awt.*;
import java.net.URL;

public class CanvasFrame extends JFrame {

    public CanvasFrame(){
        setSize(1300, 700);
        URL iconURL = getClass().getResource("res/conwayIcon.png");
        ImageIcon image = new ImageIcon(iconURL);
        setIconImage(image.getImage());
    }

    public CanvasFrame(String title, Dimension screenSize){
        super(title);
        setSize((int)screenSize.getWidth(), (int)screenSize.getHeight()-50);
        URL iconURL = getClass().getResource("res/conwayIcon.png");
        ImageIcon image = new ImageIcon(iconURL);
        setIconImage(image.getImage());
    }

}

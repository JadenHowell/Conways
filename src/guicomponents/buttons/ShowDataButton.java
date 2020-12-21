import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ShowDataButton extends JButton implements ActionListener {

    public ShowDataButton(String text){
        super(text);
        addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        DataTracker.getInstance().showData();
    }
}

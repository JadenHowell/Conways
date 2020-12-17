import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class MouseActivity implements MouseListener, MouseMotionListener {

    MainPanel panel;
    int size;

    public MouseActivity(MainPanel panel){
        this.panel = panel;
        size = panel.size;
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        int x = e.getX()/size; //we divide by size, because each cell is size large. This means the pixel we clicked on isn't exact, but we can find the cell that represents
        int y = e.getY()/size;

        if(x < panel.board.length && x >= 0 && y < panel.board[0].length && y >=0) {
            panel.board[x][y] = !panel.board[x][y]; //Switch the state of the cell dragged on
            panel.repaint();
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {
        int x = e.getX()/size;
        int y = e.getY()/size;

        if(x < panel.board.length && x >= 0 && y < panel.board[0].length && y >=0) {
            panel.board[x][y] = !panel.board[x][y]; //Switch the state of the cell dragged on
            panel.repaint();
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    @Override
    public void mouseMoved(MouseEvent e) {

    }
}

import com.sun.jdi.connect.Connector;

import javax.swing.JPanel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.Arrays;
import javax.swing.Timer;

public class MainPanel extends JPanel implements ActionListener {

    int rowWidth = 1300;
    int colHeight = 800;
    int size = 10; //This determines how large each cell is
    boolean[][] board;
    boolean justStarted = true;
    final static int FRAMERATE = 100; //1000ms = 1sec
    int iteration = 0;
    boolean isPaused = false, tracking = true;
    DataTracker tracker;
    MouseMotionListener mouse;

    private void setup(){
        setSize(rowWidth,colHeight);
        setLayout(null);
        setBackground(Color.black);
        board = new boolean[rowWidth /size][colHeight/size];
        tracker = DataTracker.getInstance();

        //These are to connect our mouseMotion/MouseListener to the panel, so we can react to mouse events
        mouse = new MouseActivity(this);
        addMouseListener((MouseListener) mouse);
        addMouseMotionListener(mouse);


        new Timer(FRAMERATE, this).start(); //This makes a timer that will call the ActionListener in 'this' every FRAMERATE ms
    }

    public MainPanel(){
        setup();
    }

    public MainPanel(Dimension screenSize){
        rowWidth = (int)screenSize.getWidth();
        colHeight = (int)screenSize.getHeight() - 150;  //This sets the height of the game. It extends slightly lower than the bottom bar.
        setup();
    }

    public void paint(Graphics g){
        super.paint(g);
        drawGrid(g);
        if(justStarted) {
            spawn();
        }
        paintCells(g);
    }

    private void drawGrid(Graphics g){
        g.setColor(Color.DARK_GRAY);
        for(int i = 0; i < board[0].length; i ++){
            g.drawLine(0,i*size, rowWidth, i*size); //horizontal line
        }
        for(int i = 0; i < board.length; i++){
            g.drawLine(i*size, 0, i*size, colHeight); //vertical line
        }
    }

    private void spawn(){
        randomize();
        justStarted = false;
    }

    private void paintCells(Graphics g){
        g.setColor(Color.cyan);
        for(int i = 0; i < board.length; i ++){
            for(int j = 0; j < board[i].length; j++){
                if(board[i][j]) {
                    g.fillRect(i * size, j * size, size, size);
                }
            }
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(!isPaused) {
            board = Conway.updateGrid(board);
            if(tracking){
                iteration++;
                if(iteration > 300){
                    DataGraph.baseTime++;  //This allows for the data tracking graph to have a dynamic x axis label
                }
                tracker.addDataPoint(board);
                //System.out.println("Tracked another point: " + tracker.chain.lastElement());
            }
            repaint();
        }
    }


    public void pause(){
        isPaused = true;
    }
    public void play(){ isPaused = false; }
    public void clear(){
        for(int i = 0; i < board.length; i ++){
            Arrays.fill(board[i], false);
        }
        repaint();
    }

    public void startTracking(){
        tracker.resetData();
        iteration = 0;
        DataGraph.baseTime = 0;
        tracking = true;
    }
    public void endTracking(){tracking = false;}
    public void continueTracking(){tracking = true;}
    public void randomize(){
        for(int i = 0; i < board.length; i ++){
            for(int j = 0; j < board[i].length; j++){
                if((int)(Math.random() * 100) % 8 == 0){ //This will randomly initialize about 1/8 to true to begin
                    board[i][j] = true;
                }else{
                    board[i][j] = false;
                }
            }
        }
    }

}

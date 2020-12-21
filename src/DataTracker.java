import java.util.Vector;

public class DataTracker {

    static Vector<Integer> chain;
    private static DataTracker instance;

    public static DataTracker getInstance(){
        if(instance == null){
            instance = new DataTracker();
        }
        return instance;
    }

    private DataTracker(){
        chain = new Vector<>();
    }

    private int countCells(boolean[][] grid){
        int num = 0;
        for(int i = 0; i < grid.length; i ++){
            for(int j = 0; j < grid[i].length; j ++){
                if(grid[i][j])
                    num++;
            }
        }
        return num;
    }

    public void addDataPoint(boolean[][] grid){
        chain.add(countCells(grid));
    }

    public Vector<Integer> getData(){ return chain; }

    public void resetData(){chain = new Vector<>(); }

    public void showData(){
        DataGraph graph = new DataGraph();
        graph.setVisible(true);
    }

}

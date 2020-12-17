
public class Conway {

    public Conway(){}

    static public boolean[][] updateGrid(boolean[][] grid){
        boolean[][] newGrid = new boolean[grid.length][grid[0].length];

        for(int i = 0; i < grid.length; i ++){
            for(int j = 0; j < grid[i].length; j ++){
                char result = updateCell(grid, i, j );
                if(result == 's'){
                    newGrid[i][j] = grid[i][j];
                }else if(result == 'l'){
                    newGrid[i][j] = true;
                }else{
                    newGrid[i][j] = false;
                }
            }
        }

        return newGrid;
    }

    //Returns what should happen to current cell. 's' = same, 'd' = die, 'l' = live
    static private char updateCell(boolean[][] grid, int i, int j){
        int neighbors = 0;
        boolean onLeft = (j == 0);
        boolean onTop = (i == 0);
        boolean onRight = (j == grid[0].length-1);
        boolean onBot = (i == grid.length-1);

        if(!onLeft && !onTop && grid[i-1][j-1])
            neighbors++;
        if(!onTop && grid[i-1][j])
            neighbors++;
        if(!onTop && !onRight && grid[i-1][j+1])
            neighbors++;
        if(!onLeft && grid[i][j-1])
            neighbors++;
        if(!onRight && grid[i][j+1])
            neighbors++;
        if(!onBot && !onLeft && grid[i+1][j-1])
            neighbors++;
        if(!onBot && grid[i+1][j])
            neighbors++;
        if(!onBot && !onRight && grid[i+1][j+1])
            neighbors++;

        if(neighbors == 3){
            return 'l';
        }
        else if(neighbors == 2){
            return 's';
        }
        return 'd';
    }

}

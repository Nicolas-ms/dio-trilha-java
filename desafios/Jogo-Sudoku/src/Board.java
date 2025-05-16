public class Board {
    private static final int GRID_SIZE = 9;
    private int[][] solution;
    private Cell[][] cells;
    
    public Board() {
        solution = new int[GRID_SIZE][GRID_SIZE];
        cells = new Cell[GRID_SIZE][GRID_SIZE];
        
        for (int row = 0; row < GRID_SIZE; row++) {
            for (int col = 0; col < GRID_SIZE; col++) {
                cells[row][col] = new Cell(row, col);
            }
        }
    }
    
    public Cell getCell(int row, int col) {
        return cells[row][col];
    }
    
    public void setSolution(int[][] solution) {
        this.solution = solution;
    }
    
    public int[][] getSolution() {
        return solution;
    }
    
    public void clear() {
        for (int row = 0; row < GRID_SIZE; row++) {
            for (int col = 0; col < GRID_SIZE; col++) {
                cells[row][col].clear();
                solution[row][col] = 0;
            }
        }
    }
    
    public boolean isComplete() {
        for (int row = 0; row < GRID_SIZE; row++) {
            for (int col = 0; col < GRID_SIZE; col++) {
                if (cells[row][col].getValue() == 0) {
                    return false;
                }
            }
        }
        return true;
    }
    
    public boolean isCorrect() {
        for (int row = 0; row < GRID_SIZE; row++) {
            for (int col = 0; col < GRID_SIZE; col++) {
                int value = cells[row][col].getValue();
                if (value != solution[row][col]) {
                    return false;
                }
            }
        }
        return true;
    }
    
    public void markErrors() {
        for (int row = 0; row < GRID_SIZE; row++) {
            for (int col = 0; col < GRID_SIZE; col++) {
                int value = cells[row][col].getValue();
                cells[row][col].markError(value != 0 && value != solution[row][col]);
            }
        }
    }
    
    public void showSolution() {
        for (int row = 0; row < GRID_SIZE; row++) {
            for (int col = 0; col < GRID_SIZE; col++) {
                cells[row][col].setValue(solution[row][col]);
            }
        }
    }
    
    public static int getSize() {
        return GRID_SIZE;
    }
} 
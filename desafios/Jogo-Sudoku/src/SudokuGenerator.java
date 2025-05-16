import java.util.Random;

public class SudokuGenerator {
    private static final Random random = new Random();
    
    public static void generatePuzzle(Board board, int cellsToRemove) {
        board.clear();
        int[][] solution = new int[Board.getSize()][Board.getSize()];
        generateSolution(solution, 0, 0);
        board.setSolution(solution);
        
        // Copy solution to initial board state
        for (int row = 0; row < Board.getSize(); row++) {
            for (int col = 0; col < Board.getSize(); col++) {
                board.getCell(row, col).setValue(solution[row][col]);
                board.getCell(row, col).setInitial(true);
            }
        }
        
        // Remove numbers to create the puzzle
        while (cellsToRemove > 0) {
            int row = random.nextInt(Board.getSize());
            int col = random.nextInt(Board.getSize());
            
            Cell cell = board.getCell(row, col);
            if (cell.isInitial()) {
                cell.setValue(0);
                cell.setInitial(false);
                cellsToRemove--;
            }
        }
    }
    
    private static boolean generateSolution(int[][] grid, int row, int col) {
        if (col >= Board.getSize()) {
            row++;
            col = 0;
        }
        
        if (row >= Board.getSize()) {
            return true;
        }
        
        int[] numbers = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        shuffleArray(numbers);
        
        for (int number : numbers) {
            if (isValid(grid, row, col, number)) {
                grid[row][col] = number;
                if (generateSolution(grid, row, col + 1)) {
                    return true;
                }
                grid[row][col] = 0;
            }
        }
        
        return false;
    }
    
    private static boolean isValid(int[][] grid, int row, int col, int number) {
        // Check row
        for (int x = 0; x < Board.getSize(); x++) {
            if (grid[row][x] == number) {
                return false;
            }
        }
        
        // Check column
        for (int x = 0; x < Board.getSize(); x++) {
            if (grid[x][col] == number) {
                return false;
            }
        }
        
        // Check 3x3 box
        int boxRow = row - row % 3;
        int boxCol = col - col % 3;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (grid[boxRow + i][boxCol + j] == number) {
                    return false;
                }
            }
        }
        
        return true;
    }
    
    private static void shuffleArray(int[] array) {
        for (int i = array.length - 1; i > 0; i--) {
            int j = random.nextInt(i + 1);
            int temp = array[i];
            array[i] = array[j];
            array[j] = temp;
        }
    }
} 
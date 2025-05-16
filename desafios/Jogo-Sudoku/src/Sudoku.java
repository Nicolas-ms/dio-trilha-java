import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;

public class Sudoku extends JFrame {
    private static final int GRID_SIZE = 9;
    private JTextField[][] cells = new JTextField[GRID_SIZE][GRID_SIZE];
    private int[][] solution = new int[GRID_SIZE][GRID_SIZE];
    private int[][] initial = new int[GRID_SIZE][GRID_SIZE];
    
    public Sudoku() {
        setTitle("Sudoku");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        
        // Create the game board panel
        JPanel boardPanel = new JPanel(new GridLayout(GRID_SIZE, GRID_SIZE));
        for (int row = 0; row < GRID_SIZE; row++) {
            for (int col = 0; col < GRID_SIZE; col++) {
                cells[row][col] = new JTextField();
                cells[row][col].setHorizontalAlignment(JTextField.CENTER);
                cells[row][col].setFont(new Font("Arial", Font.BOLD, 20));
                
                // Add borders to separate 3x3 boxes
                int top = (row % 3 == 0) ? 3 : 1;
                int left = (col % 3 == 0) ? 3 : 1;
                int bottom = (row % 3 == 2) ? 3 : 1;
                int right = (col % 3 == 2) ? 3 : 1;
                
                cells[row][col].setBorder(BorderFactory.createMatteBorder(top, left, bottom, right, Color.BLACK));
                boardPanel.add(cells[row][col]);
                
                final int currentRow = row;
                final int currentCol = col;
                cells[row][col].addKeyListener(new KeyAdapter() {
                    public void keyTyped(KeyEvent e) {
                        char input = e.getKeyChar();
                        if (!Character.isDigit(input) || input == '0' || 
                            cells[currentRow][currentCol].getText().length() > 0) {
                            e.consume();
                        }
                    }
                });
            }
        }
        
        add(boardPanel, BorderLayout.CENTER);
        
        // Create control panel
        JPanel controlPanel = new JPanel();
        JButton newGameButton = new JButton("Novo Jogo");
        JButton checkButton = new JButton("Verificar");
        JButton solveButton = new JButton("Resolver");
        
        newGameButton.addActionListener(e -> generateNewGame());
        checkButton.addActionListener(e -> checkSolution());
        solveButton.addActionListener(e -> showSolution());
        
        controlPanel.add(newGameButton);
        controlPanel.add(checkButton);
        controlPanel.add(solveButton);
        add(controlPanel, BorderLayout.SOUTH);
        
        setSize(500, 550);
        setLocationRelativeTo(null);
        generateNewGame();
    }
    
    private void generateNewGame() {
        // Clear the board first
        clearBoard();
        
        // Generate a solved board
        generateSolution(0, 0);
        
        // Copy solution to initial board
        for (int i = 0; i < GRID_SIZE; i++) {
            for (int j = 0; j < GRID_SIZE; j++) {
                initial[i][j] = solution[i][j];
            }
        }
        
        // Remove some numbers to create the puzzle
        Random random = new Random();
        int cellsToRemove = 40; // Adjust difficulty by changing this number
        
        while (cellsToRemove > 0) {
            int row = random.nextInt(GRID_SIZE);
            int col = random.nextInt(GRID_SIZE);
            
            if (initial[row][col] != 0) {
                initial[row][col] = 0;
                cellsToRemove--;
            }
        }
        
        // Display the initial board
        updateDisplay();
    }
    
    private void clearBoard() {
        for (int i = 0; i < GRID_SIZE; i++) {
            for (int j = 0; j < GRID_SIZE; j++) {
                cells[i][j].setText("");
                cells[i][j].setForeground(Color.BLACK);
                cells[i][j].setEditable(true);
                initial[i][j] = 0;
                solution[i][j] = 0;
            }
        }
    }
    
    private boolean generateSolution(int row, int col) {
        if (col >= GRID_SIZE) {
            row++;
            col = 0;
        }
        
        if (row >= GRID_SIZE) {
            return true;
        }
        
        Random random = new Random();
        int[] numbers = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        
        // Shuffle numbers
        for (int i = numbers.length - 1; i > 0; i--) {
            int j = random.nextInt(i + 1);
            int temp = numbers[i];
            numbers[i] = numbers[j];
            numbers[j] = temp;
        }
        
        for (int number : numbers) {
            if (isValid(row, col, number)) {
                solution[row][col] = number;
                if (generateSolution(row, col + 1)) {
                    return true;
                }
                solution[row][col] = 0;
            }
        }
        
        return false;
    }
    
    private boolean isValid(int row, int col, int number) {
        // Check row
        for (int x = 0; x < GRID_SIZE; x++) {
            if (solution[row][x] == number) {
                return false;
            }
        }
        
        // Check column
        for (int x = 0; x < GRID_SIZE; x++) {
            if (solution[x][col] == number) {
                return false;
            }
        }
        
        // Check 3x3 box
        int boxRow = row - row % 3;
        int boxCol = col - col % 3;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (solution[boxRow + i][boxCol + j] == number) {
                    return false;
                }
            }
        }
        
        return true;
    }
    
    private void updateDisplay() {
        for (int i = 0; i < GRID_SIZE; i++) {
            for (int j = 0; j < GRID_SIZE; j++) {
                if (initial[i][j] != 0) {
                    cells[i][j].setText(String.valueOf(initial[i][j]));
                    cells[i][j].setEditable(false);
                    cells[i][j].setBackground(new Color(240, 240, 240));
                } else {
                    cells[i][j].setText("");
                    cells[i][j].setEditable(true);
                    cells[i][j].setBackground(Color.WHITE);
                }
            }
        }
    }
    
    private void checkSolution() {
        boolean isComplete = true;
        boolean isCorrect = true;
        
        for (int i = 0; i < GRID_SIZE; i++) {
            for (int j = 0; j < GRID_SIZE; j++) {
                String value = cells[i][j].getText();
                if (value.isEmpty()) {
                    isComplete = false;
                    continue;
                }
                
                int num = Integer.parseInt(value);
                if (num != solution[i][j]) {
                    isCorrect = false;
                    cells[i][j].setForeground(Color.RED);
                } else {
                    cells[i][j].setForeground(Color.BLACK);
                }
            }
        }
        
        if (!isComplete) {
            JOptionPane.showMessageDialog(this, "O jogo ainda não está completo!");
        } else if (!isCorrect) {
            JOptionPane.showMessageDialog(this, "Há alguns erros na solução!");
        } else {
            JOptionPane.showMessageDialog(this, "Parabéns! Você completou o Sudoku corretamente!");
        }
    }
    
    private void showSolution() {
        for (int i = 0; i < GRID_SIZE; i++) {
            for (int j = 0; j < GRID_SIZE; j++) {
                cells[i][j].setText(String.valueOf(solution[i][j]));
            }
        }
    }
    
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new Sudoku().setVisible(true);
        });
    }
} 
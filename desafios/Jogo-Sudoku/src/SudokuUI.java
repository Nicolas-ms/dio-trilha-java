import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class SudokuUI extends JFrame {
    private Board board;
    
    public SudokuUI() {
        setTitle("Sudoku");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        
        board = new Board();
        
        // Create the game board panel
        JPanel boardPanel = new JPanel(new GridLayout(Board.getSize(), Board.getSize()));
        for (int row = 0; row < Board.getSize(); row++) {
            for (int col = 0; col < Board.getSize(); col++) {
                Cell cell = board.getCell(row, col);
                cell.addKeyListener(new CellKeyListener());
                boardPanel.add(cell);
            }
        }
        
        add(boardPanel, BorderLayout.CENTER);
        
        // Create control panel
        JPanel controlPanel = new JPanel();
        JButton newGameButton = new JButton("Novo Jogo");
        JButton checkButton = new JButton("Verificar");
        JButton solveButton = new JButton("Resolver");
        
        newGameButton.addActionListener(e -> startNewGame());
        checkButton.addActionListener(e -> checkSolution());
        solveButton.addActionListener(e -> showSolution());
        
        controlPanel.add(newGameButton);
        controlPanel.add(checkButton);
        controlPanel.add(solveButton);
        add(controlPanel, BorderLayout.SOUTH);
        
        setSize(500, 550);
        setLocationRelativeTo(null);
        startNewGame();
    }
    
    private void startNewGame() {
        SudokuGenerator.generatePuzzle(board, 40); // 40 células a menos para dificuldade média
    }
    
    private void checkSolution() {
        if (!board.isComplete()) {
            JOptionPane.showMessageDialog(this, "O jogo ainda não está completo!");
            return;
        }
        
        board.markErrors();
        
        if (board.isCorrect()) {
            JOptionPane.showMessageDialog(this, "Parabéns! Você conseguiu! clique \"jogar novamente\" para continuar jogando.");
        } else {
            JOptionPane.showMessageDialog(this, "Há alguns erros na solução!");
        }
    }
    
    private void showSolution() {
        board.showSolution();
    }
    
    private class CellKeyListener extends KeyAdapter {
        @Override
        public void keyTyped(KeyEvent e) {
            Cell cell = (Cell) e.getSource();
            if (cell.isInitial()) {
                e.consume();
                return;
            }
            
            char input = e.getKeyChar();
            if (!Character.isDigit(input) || input == '0' || 
                cell.getText().length() > 0) {
                e.consume();
                return;
            }
            
            cell.setValue(Character.getNumericValue(input));
        }
    }
    
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new SudokuUI().setVisible(true);
        });
    }
} 
import javax.swing.*;
import java.awt.*;

public class Cell extends JTextField {
    private int value;
    private boolean isInitial;
    private int row;
    private int col;
    
    public Cell(int row, int col) {
        this.row = row;
        this.col = col;
        this.value = 0;
        this.isInitial = false;
        
        setupUI();
    }
    
    private void setupUI() {
        setHorizontalAlignment(JTextField.CENTER);
        setFont(new Font("Arial", Font.BOLD, 20));
        
        // Add borders to separate 3x3 boxes
        int top = (row % 3 == 0) ? 3 : 1;
        int left = (col % 3 == 0) ? 3 : 1;
        int bottom = (row % 3 == 2) ? 3 : 1;
        int right = (col % 3 == 2) ? 3 : 1;
        
        setBorder(BorderFactory.createMatteBorder(top, left, bottom, right, Color.BLACK));
    }
    
    public void setValue(int value) {
        this.value = value;
        if (value == 0) {
            setText("");
        } else {
            setText(String.valueOf(value));
        }
    }
    
    public int getValue() {
        return value;
    }
    
    public void setInitial(boolean initial) {
        isInitial = initial;
        setEditable(!initial);
        setBackground(initial ? new Color(240, 240, 240) : Color.WHITE);
    }
    
    public boolean isInitial() {
        return isInitial;
    }
    
    public void markError(boolean isError) {
        setForeground(isError ? Color.RED : Color.BLACK);
    }
    
    public void clear() {
        setValue(0);
        setInitial(false);
        markError(false);
    }
} 
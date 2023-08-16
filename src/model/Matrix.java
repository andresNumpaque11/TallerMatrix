package model;

import java.util.ArrayList;

/**
 *
 * @author Andres Numpaque
 */
public class Matrix {
    
    private int rows;
    private int columns;
    private ArrayList numbers;

    public Matrix(int rows, int columns) {
        this.rows = rows;
        this.columns = columns;
        numbers = new ArrayList();
    }
    
    public  void add(int number){
        numbers.add(number);
    }
    
    public ArrayList transposeMatrix() {
        ArrayList transposed = new ArrayList<>();

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                transposed.add(numbers.get(j * columns + i));
            }
        }

        return transposed;
    }

    public int getColumns() {
        return columns;
    }

    public int getRows() {
        return rows;
    }

    public ArrayList getNumbers() {
        return numbers;
    }
    
    
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Matrix;

/**
 *
 * @author trinh
 */
public class GetMatrix {

    public static int[][] getMatrix(String mess, int column, int row) {
        int matrix[][] = new int[row][column];
        // loop until the last index in row
        for (int i = 0; i < row; i++) {
            // loop until the last index in column
            for (int j = 0; j < column; j++) {
                matrix[i][j] = GetInput.getInputMatrix(mess+"[" + (i + 1) + "][" + (j + 1) + "]:");
            }
        }
        return matrix;
    }
}

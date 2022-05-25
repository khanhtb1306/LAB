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
public class Display {

    //display menu
    public static void displayMenu() {
        System.out.println("=======Calculator program=======");
        System.out.println("1: Addition Matrix");
        System.out.println("2: Subtraction Matrix");
        System.out.println("3: Multiplication Matrix");
        System.out.println("4: Quit.");
    }

    //display result addition matrix
    public static void displayResultAdditionMatrix() {
        System.out.println("------- Addition -------");
        int row1 = GetInput.GetInputRowColumn("Enter Row Matrix 1:");
        int column1 = GetInput.GetInputRowColumn("Enter Column Matrix 1:");

        //create the first matrix
        int matrix1[][] = GetMatrix.getMatrix("Enter matrix1", column1, row1);
        
        int row2, column2;
        //loop checks the value and input of row
        while (true) {
            row2 = GetInput.GetInputRowColumn("Enter Row Matrix 2:");
            // Check if row1 value is equal to row2
            if (row2 == row1) {
                break;
            } else {
                System.out.println("row2 must equal row1!");
            }
        }
        //loop checks the value and input of column
        while (true) {
            column2 = GetInput.GetInputRowColumn("Enter Column Matrix 2:");
            // Check if column2 value is equal to column1
            if (column2 == column1) {
                break;
            } else {
                System.out.println("column2 must equal column1!");
            }
        }

        //create a second matrix
        int matrix2[][] = GetMatrix.getMatrix("Enter matrix2", column2, row2);

        //create a matrix that stores the result when adding
        int Result[][] = new int[row2][column2];

        // loop until the last index in row2
        for (int i = 0; i < row2; i++) {
            // loop until the last index in column2
            for (int j = 0; j < column2; j++) {
                // add the values of 2 matrix
                Result[i][j] = matrix1[i][j] + matrix2[i][j];
            }
        }
        System.out.println("----------Result----------");
        displayMatrix(matrix1, row1, column1);
        System.out.println("+");
        displayMatrix(matrix2, row2, column2);
        System.out.println("=");
        displayMatrix(Result, row2, column2);
    }

    //display result subtraction matrix
    public static void displayResultSubtractionMatrix() {
        System.out.println("------- Subtraction -------");
        int row1 = GetInput.GetInputRowColumn("Enter row matrix 1:");
        int column1 = GetInput.GetInputRowColumn("Enter Column Matrix 1:");

        //create the first matrix
        int matrix1[][] = GetMatrix.getMatrix("Enter matrix1", column1, row1);

        int row2, column2;
        //loop checks the value and input of row
        while (true) {
            //rompt users input number of row2 of matrixes 1
            row2 = GetInput.GetInputRowColumn("Enter Row Matrix 2:");
            // check if row2 value is equal to row1
            if (row2 == row1) {
                break;
            } else {
                System.out.println("row2 must equal row1!");
            }
        }
        
        //loop checks the value and input of column
        while (true) {
            column2 = GetInput.GetInputRowColumn("Enter Column Matrix 2:");
            // check if column2 value is equal to column1
            if (column2 == column1) {
                break;
            } else {
                System.out.println("column2 must equal column1!");
            }
        }

        //create a second matrix
        int matrix2[][] = GetMatrix.getMatrix("Enter matrix2", column2, row2);

        //create a matrix that stores the result when subtracting
        int Result[][] = new int[row2][column2];

        // loop until the last index in row2
        for (int i = 0; i < row2; i++) {
            // loop until the last index in column2
            for (int j = 0; j < column2; j++) {
                //subtract the values of 2 matrix
                Result[i][j] = matrix1[i][j] - matrix2[i][j];
            }
        }
        System.out.println("----------Result----------");
        displayMatrix(matrix1, row1, column1);
        System.out.println("-");
        displayMatrix(matrix2, row2, column2);
        System.out.println("=");
        displayMatrix(Result, row2, column2);
    }

    //display result multiplication matrix
    public static void displayResultMultiplicationMatrix() {
        System.out.println("------- Multiplication -------");
        int row1 = GetInput.GetInputRowColumn("Enter Row Matrix 1:");
        int column1 = GetInput.GetInputRowColumn("Enter Column Matrix 1:");

        //create the first matrix
        int matrix1[][] = GetMatrix.getMatrix("Enter matrix1", column1, row1);
        
        int row2;
        //loop checks the value and input of row
        while (true) {
            row2 = GetInput.GetInputRowColumn("Enter Row Matrix 2:");
            // check if row2 value is equal to column1
            if (row2 == column1) {
                break;
            } else {
                System.out.println("row2 must equal column1");
            }
        }
        int column2 = GetInput.GetInputRowColumn("Enter Column Matrix 2:");

        //create a second matrix
        int matrix2[][] = GetMatrix.getMatrix("Enter matrix2", column2, row2);

        //create a matrix that stores the result after multiplying
        int result[][] = new int[row1][column2];

        // loop until the last index in row1
        for (int i = 0; i < row1; i++) {
            // loop until the last index in column2
            for (int j = 0; j < column2; j++) {
                // loop until the last index in row2
                for (int k = 0; k < row2; k++) {
                    // multiply the values of 2 matrix
                    result[i][j] = result[i][j] + matrix1[i][k] * matrix2[k][j];
                }
            }
        }
        System.out.println("----------Result----------");
        displayMatrix(matrix1, row1, column1);
        System.out.println("*");
        displayMatrix(matrix2, row2, column2);
        System.out.println("=");
        displayMatrix(result, row1, column2);
    }

    //display matrix
    public static void displayMatrix(int matrix[][], int row, int column) {
        // loop until the last index in row
        for (int i = 0; i < row; i++) {
            // loop until the last index in column
            for (int j = 0; j < column; j++) {
                System.out.print("[" + matrix[i][j] + "]");
            }
            System.out.println("");
        }
    }
}

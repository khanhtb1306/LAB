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
public class Main {

    public static void main(String[] args) {
        while (true) {

            //step1: display menu
            Display.displayMenu();

            //step2: Input choice
            int choice = GetInput.getInputChoice();

            switch (choice) {
                case 1:
                    //Step3: display result addition matrix
                    Display.displayResultAdditionMatrix();
                    break;
                case 2:
                    //Step4: display result subtraction matrix
                    Display.displayResultSubtractionMatrix();
                    break;
                case 3:
                    //Step5: display result multiplication matrix
                    Display.displayResultMultiplicationMatrix();
                    break;
                case 4:
                    //Step6: exit program
                    System.exit(0);
                    break;
            }
        }
    }
}

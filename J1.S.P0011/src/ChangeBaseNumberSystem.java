/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author trinh
 */
public class ChangeBaseNumberSystem {

    public static void main(String[] args) {
        while (true) {
            //step 0: Input choice 
            int choice = Utility.getInputChoice("(0)Exit program, (1)Change base number system\nEnter your choice: ", 0, 1);
            switch (choice) {
                case 1:
                    //run progaram Change Base Number System
                    while (true) {
                        //Step 1: Enter inputbase
                        int inBase = inputInBase("Enter Base of Input: ");

                        //Step 2:Enter outputBase
                        int outBase = inputOutBase("Enter Base of Output: ", inBase);

                        //Step 3: Enter inputvalue 
                        String inputString = inputValue(inBase);

                        //step 4: convert all to dec
                        String decValue = convertAllToDec(inputString, inBase);

                        //step 5: convert dec to all
                        convertDecToAll(decValue, outBase);
                        break;
                    }
                    continue;
                case 0:
                    //exit program
                    System.exit(0);
            }
        }
    }

    public static int inputInBase(String msg) {
        int inBase = Integer.parseInt(Utility.getStringByRegex(msg, "Enter Base number system 2 or 10 or 16\n", "^(2|10|16)$"));
        return inBase;
    }

    public static int inputOutBase(String msg, int outBase) {
        //loop until user input correct
        while (true) {
            int inBase = Integer.parseInt(Utility.getStringByRegex(msg, "Enter Base number system 2 or 10 or 16\n", "^(2|10|16)$"));
            //check inbase and outbase are equal or not
            if (inBase == outBase) {
                System.err.println("Enter Base number system 2 or 10 or 16");
            } else {
                return inBase;
            }
        }
    }

    public static String inputValue(int inBase) {
        String inputString = "";
        switch (inBase) {
            case 2:
                inputString = Utility.getStringByRegex("Enter Bin: ", "Enter only 0 & 1\n", "^[01]+$");
                break;
            case 10:
                inputString = Utility.getStringByRegex("Enter Dec: ", "Enter 0-9\n", "^[0-9]+$");
                break;
            case 16:
                inputString = Utility.getStringByRegex("Enter Hex: ", "Enter 0-9, A, B, C, D, E, F\n", "^[0-9a-fA-F]+$");
                break;
        }
        return inputString;
    }

    public static String convertAllToDec(String inputString, int inBase) {
        String b = String.valueOf(inBase);
        String decValue = changeBase.AllToDec(inputString, b);
        return decValue;
    }

    public static void convertDecToAll(String decValue, int outBase) {
        String outB = String.valueOf(outBase);
        String outputString = changeBase.DecToAll(decValue, outB);
        System.out.println("Output: " + outputString);
        System.out.println("_______________________________________________________________________________________________");
    }

}

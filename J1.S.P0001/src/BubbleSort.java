/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author trinh
 */
public class BubbleSort {

    // //check user input number 
    public static int CheckInputInt() {
        int sizeArray;
        Scanner sc = new Scanner(System.in);
        //Check input of array in right form, if it's wrong, do it again! 
        while (true) {
            try {
                sizeArray = Integer.parseInt(sc.nextLine());
                // check condition for integer greater than 0
                if (sizeArray > 0 && sizeArray <= Integer.MAX_VALUE) {
                    return sizeArray;
                } else {
                    System.out.println("Out of range, Please enter a number greater than 0 ");
                }

            } catch (NumberFormatException e) {
                System.out.println("Invalid format, please enter integer");
            }
        }
    }

    // Input size integer of array
    private static int inputSizeIntOfArray() {
        System.out.println("Enter number of array: ");
        int sizeArray = CheckInputInt();
        return sizeArray;
    }

    //random value of array 
    public static void randomValueOfArray(int[] array) {

        Random random = new Random(); // creating random object
        int sizeArray = array.length;

        //run the element in the first array to the last element
        for (int i = 0; i < sizeArray; i++) {
            //perform a jump, return random value of an element in the array
            array[i] = random.nextInt(100);
        }
        System.out.print("Unsorted array: ");
    }

    // sort array by bubble sort 
    public static void sortArrayByBubbleSort(int[] array) {

        int sizeArray = array.length;
        System.out.println("");
        //run rom first element to the last elemnt of array
        for (int i = 0; i < sizeArray; i++) {
            System.out.println("");
            //run from first element to before the last element, j dependent i;
            for (int j = 0; j < sizeArray - i - 1; j++) {
                //Compares whether the current element is greater than the next adjacent element
                if (array[j] > array[j + 1]) {

                    //check algorithm
                    displayArray(array);
                    System.out.println("    " + array[j] + " > " + array[j + 1] + ", Swap");
                    
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;

                    //Compares whether the current element is less than the next adjacent element
                } else if (array[j] < array[j + 1]) {
                    displayArray(array);
                    System.out.println("    " + array[j] + " < " + array[j + 1] + ", Ok");

                    //Compares whether the current element is equal to the next adjacent element
                } else if (array[j] == array[j + 1]) {
                    displayArray(array);
                    System.out.println("    " + array[j] + " = " + array[j + 1] + ", Ok");
                }
            }
        }
        System.out.print("Sorted array: ");
    }

    //display all element of array
    public static void displayArray(int[] array) {

        int sizeArray = array.length;
        //run rom first element to the last elemnt of array
        for (int i = 0; i < sizeArray; i++) {
            if (i == 0) // check at the first position of array
            {
                System.out.print("[" + array[i] + ", ");
            } else if (i == sizeArray - 1)//check at the end of the array
            {
                System.out.print(array[i] + "]");
            } else // not at the first location or last array
            {
                System.out.print(array[i] + ", ");
            }
        }
    }

    public static void main(String[] args) {

        //Step1: Input size integer of array 
        int inputsizeInt = inputSizeIntOfArray();
        int[] array = new int[inputsizeInt];

        //Step2: Random value of array
        randomValueOfArray(array);

//        // test bubble sort algorithm
//        int[] array = {5, 1, 12, -5, 16};

        //Step3: Display array before sorting
        displayArray(array);

        //Step4: Sort array by bubble sort
        sortArrayByBubbleSort(array);

        //Step5: display array after sorting
        displayArray(array);
    }
}

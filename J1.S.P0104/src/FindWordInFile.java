/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.io.File;
import java.util.Scanner;

/**
 *
 * @author trinh
 */
public class FindWordInFile {

    public static void main(String[] args) {

        ArrayList<String> contentFIle = new ArrayList<>();

        //step1: Input file name
        inputFileName(contentFIle);

        //step2; Input string to search
        String strsearch = inputStringToSearch(contentFIle);

        //Step3: Find word in file
        findWordInFile(contentFIle, strsearch);
    }

    //input file name
    public static void inputFileName(ArrayList<String> ContentFIle) {
        //loop until user input correct
        while (true) {
            System.out.print("Please enter directory of file:  ");
            Scanner scanner = new Scanner(System.in);
            String fileName = scanner.nextLine();
            
            //check empty
            if (fileName.isEmpty()) {
                System.out.println("Not empty");
            } else {
                try {
                    File checkFile = new File(fileName);
                    //if user enters is folder name allow user to re-enter
                    if (checkFile.isDirectory()) {
                        System.out.println("Is Dicrectory, Please enter again\n");
                        continue;
                    }
                    scanner = new Scanner(checkFile);
                    while (scanner.hasNextLine())//check for existence of strings
                    {
                        String line = scanner.nextLine();
                        ContentFIle.add(line);
                    }
                } catch (FileNotFoundException e) {
                    System.out.println("File not found, please enter the correct file name\n");
                    continue;
                }
                break;
            }
        }
    }

    //input string to search
    public static String inputStringToSearch(ArrayList<String> contentFIle) {
        Scanner scanner = new Scanner(System.in);
        //loop until user input correct
        while (true) {
            System.out.print("Please enter string to search: ");
            String strSearch = scanner.nextLine();
            //check empty
            if (strSearch.isEmpty()) {
                System.out.println("Not empty");
                System.out.println("Enter again: ");
            } else {
                //run from start to finish arraylist
                for (String i : contentFIle) {
                    //check string or letter words that contain the input string
                    if (i.contains(strSearch)) {
                        return strSearch;
                    }
                }

                System.out.println("Word not found, please enter again");
                System.out.println("");
            }
        }
    }

    //find word in file
    public static void findWordInFile(ArrayList<String> contentFIle, String strSearch) {
        System.out.println("");
        System.out.println("Search results:");
        //run from beginning to end of arraylist
        for (String i : contentFIle) {
            //check string or letter words that contain the input string
            if (i.contains(strSearch)) {
                System.out.println("     " + i);
            }
        }
        System.out.println("     " + "...");
    }
}

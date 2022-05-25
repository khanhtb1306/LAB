/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package HandlesFiles;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

/**
 *
 * @author trinh
 */
public class HandlesFiles {

    public static void main(String[] args) {
        //loop until user want to exit
        while (true) {
            //Step1: display menu
            displayMenu();

            //Step2: Input choice
            int choice = Utility.InputChoice("Enter your choice: ", 1, 3);

            switch (choice) {
                case 1:
                    //Step3: find person info
                    findPersonInfo();
                    break;
                case 2:
                    //Step4: copy word from file to file
                    copyWordFromFileToFile();
                    break;
                case 3:
                    //Step5: exits program  
                    return;
            }
        }
    }

    public static void displayMenu() {
        System.out.println("========== File Processing ==========");
        System.out.println("1. Find person info.");
        System.out.println("2. Copy Text to new file.");
        System.out.println("3. Exit.");
    }

    public static void readFile(ArrayList<Person> ListPersons) {
        //loop until user input correct
        while (true) {
            String FileName = Utility.getInputString("Enter Path: ");
            try {
                File myObj = new File(FileName);
                //check is directory
                if (myObj.isDirectory()) {
                    System.out.println("Is Dicrectory, Please enter again\n");
                    continue;
                }
                Scanner myReader = new Scanner(myObj);
                //run to the end of file
                while (myReader.hasNextLine()) {
                    String[] data = myReader.nextLine().trim().split(";");
                    String Name = data[0];
                    String Address = data[1];
                    double Salary = Double.parseDouble(data[2].trim());
                    ListPersons.add(new Person(Name, Address, Salary));
                }
                myReader.close();
            } catch (IOException ex) {
                System.out.println("File not exist.");
                continue;
            }
            break;
        }
    }

    public static void findPersonInfo() {
        ArrayList<Person> ListPersons = new ArrayList<>();
        readFile(ListPersons);
        double Money = Utility.getSalary("Enter Money: ");
        ArrayList<Person> validPerson = new ArrayList<>();
        //run from the beginning to the end of the list
        for (Person per : ListPersons) {
            //check salary greater than 0
            if (per.getSalary() >= Money) {
                validPerson.add(per);
            }
        }
        //check empty
        if (validPerson.isEmpty()) {
            System.out.println("No person.");
        } else {
            System.out.println("------------- Result ----------");
            System.out.format("%-15s%-15s%s\n", "Name", "Address", "Money");
            //run from the beginning to the end of the list
            for (Person per : validPerson) {
                System.out.println(per);
            }
            System.out.println("\nMax: " + Collections.max(validPerson).getName());
            System.out.println("Min: " + Collections.min(validPerson).getName());
        }
    }

    public static void copyWordFromFileToFile() {
        System.out.println("-------------- Copy text --------------");
        String Source = Utility.getInputString("Enter Source: ");
        File source = new File(Source);
        if (source.isDirectory()) {
            System.out.println("is Directory");
            return;
        }
        String Destination = Utility.getInputString("Enter new file name: ");
        File fileCopy = new File(Destination);
        if (fileCopy.isDirectory()) {
            System.out.println("is Directory");
            return;
        }
        //check file exits or not
        if (fileCopy.exists()) {
            try {
                Scanner scanner = new Scanner(fileCopy);
                //check file has data or not
                if (!scanner.hasNext()) {
                    //check user continu
                    if (Utility.getInputYN("\"File exists, file is empty do you want to write content? (Y / N): ")) {
                        copyWordOneTimes(Source, Destination);
                    }
                } else {
                    if (Utility.getInputYN("\"The file has data, do you want to add more content? (Y / N): ")) {
                        copyWordOneTimes(Source, Destination);
                    }
                }
            } catch (FileNotFoundException ex) {
                System.out.println("can not read file");
            }
        } else {
//            if (Utility.getInputYN("\"File does not exist you want to create a new file and add data? (Y / N): ")) {
                copyWordOneTimes(Source, Destination);
//            }
        }
    }

    public static void copyWordOneTimes(String Source, String Destination) {
        ArrayList<String> List = new ArrayList<>();
        try {
            FileReader in = new FileReader(Source);
            FileWriter out = new FileWriter(Destination, true);
            Scanner myReader = new Scanner(in);
            //run from start to finish file
            while (myReader.hasNext()) {
                String data = myReader.next().replaceAll(";", " ");
                List.add(data + " ");
            }
            String content = "";
            //run from the beginning to the end of the list
            for (String elements : List) {
                content += elements;
            }

            ArrayList<String> myList = new ArrayList<>(Arrays.asList(content.split(" ")));
            Set<String> Listset = new LinkedHashSet<>(myList);

            String contentAfter = "";
            //run from the beginning to the end of the list
            for (String elements : Listset) {
                contentAfter += elements + " ";
            }
            out.write(contentAfter + "\n");
            in.close();
            out.close();
            System.out.println("Copy done...");
        } catch (IOException e) {
            System.out.println("File Source not exist.");
        }
    }

}

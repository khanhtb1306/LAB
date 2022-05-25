
import java.util.ArrayList;
import java.util.Collections;

public class Manager {

    // add some basic emp to listEmployees
    public Manager(ArrayList<Employee> listEmployees) {
        listEmployees.add(new Employee("HE12345", "Nguyen", "A", "0999999990", "A@gmail.com", "HN-VN", "13/06/2001", "Male", 2000, "FPT Ha Noi"));
        listEmployees.add(new Employee("HE67890", "Hoang", "B", "0888888880", "B@gmail.com", "HN-VN", "12/09/2001", "Male", 1000, "FPT Ha Noi"));
    }

    // menu
    public static void displayMenu() {
        System.out.println("------EMPLOYEE MANAGER--------");
        System.out.println("1. Add employees              |");
        System.out.println("2. Update employees           |");
        System.out.println("3. Remove employees           |");
        System.out.println("4. Search employees           |");
        System.out.println("5. Sort employees by salary   |");
        System.out.println("6. Exit                       |");
        System.out.println("------------------------------");
    }

    public static int askTheUseToChoice() {
        int choice = Utility.inputChoice("Enter your choice: ");
        return choice;
    }

    public static void addEmployees(ArrayList<Employee> listEmployees) {
        //input 
        String ID = Utility.getInputID(listEmployees, "Enter ID: ");
        String FirstName = Utility.getInputString("Enter first name: ");
        String LastName = Utility.getInputString("Enter last name: ");
        String Phone = Utility.getPhone("Enter phone: ");
        String Email = Utility.getEmail("Enter email: ");
        String Address = Utility.getInputString("Enter address: ");
        String DOB = Utility.getDate("Enter DOB: ");
        String Sex = Utility.getSex("Enter sex: ");
        double Salary = Utility.getSalary("Enter salary: ");
        String Agency = Utility.getInputString("Enter agency: ");

        Employee newEmployees = new Employee(ID, FirstName, LastName, Phone, Email, Address, DOB, Sex, Salary, Agency);
        System.out.println("The new employee is:");
        String Header = String.format("%-10s%-15s%-15s%-15s%-20s%-20s%-16s%-10s%-10s%s", "Id", "FirstName", "LastName", "Phone", "Email", "Address", "DOB", "Sex", "Salary", "Agency");
        System.out.println(Header + "\n" + newEmployees);
        listEmployees.add(new Employee(ID, FirstName, LastName, Phone, Email, Address, DOB, Sex, Salary, Agency));
    }

    public static void updateEmployees(ArrayList<Employee> listEmployees) {
        //check empty
        if (listEmployees.isEmpty()) {
            System.out.println("List Empty!!!");
            return;
        }
        String ID = Utility.getID(listEmployees, "Enter update ID: ");
        int positionID = getPosID(listEmployees, ID);
        Employee empOriginal = listEmployees.get(positionID);
        listEmployees.remove(positionID);

        // show employeess user will update
        String Header = String.format("%-10s%-15s%-15s%-15s%-20s%-20s%-16s%-10s%-10s%s", 
        "ID", "FirstName", "LastName", "Phone", "Email", "Address", "DOB", "Sex", "Salary", "Agency");
        System.out.println(Header + "\n" + empOriginal);

        // get update student (0)Update All, (1)Update Each.
        int choice = Utility.getInputChoice("\n(0)Update All, (1)Update Each.\nEnter your choice: ", 0, 1);
        
        Employee empUpdate;
        //check user choice 
        if (choice == 0) {
            // update all inf of employee
            empUpdate = updateAll(listEmployees, empOriginal);
        } else {
            // update each part of employee
            empUpdate = updateEach(listEmployees, empOriginal);
        }

         // check emp_original and emp_update similar or not
        if (!empOriginal.Compare(empUpdate)) {
            System.out.println("\nThe employee will update to:");
            //show employees user will update to
            System.out.println(Header + "\n" + empUpdate);
            // Ask the user if he wants to continue the operation
            if (Utility.getInputYN("Are you sure to update this employee (Y/N): ")) {
                listEmployees.add(empUpdate);
                System.out.println("The employee updated.");
            } else {
                listEmployees.add(empOriginal);
                System.out.println("Nothing change.");
            }

        } else {
            listEmployees.add(empOriginal);
            System.out.println("Nothing change.");
        }
    }
    
    //update each information of employees
    public static Employee updateEach(ArrayList<Employee> listEmployees, Employee emp) {    
        
        Employee empTemp = new Employee(emp);
        //loop until user want to exit the program
        while (true) {
            //input choice
            int choice = Utility.getInputChoice("\n(1)ID, (2)FirstName, "
                    + "(3)LastName, (4)Phone, (5)Email, (6)Address, (7)DOB, (8)Salary, (9)Agency, (10)DONE."
                    + "\nEnter the part want to update: ", 1, 10);
            switch (choice) {
                case 1:
                    //update ID
                    String ID = Utility.getInputID(listEmployees, "Enter ID: ");
                    empTemp.setId(ID);
                    break;
                case 2:
                    //update first name
                    String FirstName = Utility.getInputString("Enter first name: ");
                    empTemp.setFirstName(FirstName);
                    break;
                case 3:
                    //update last name
                    String LastName = Utility.getInputString("Enter last name: ");
                    empTemp.setLastName(LastName);
                    break;
                case 4:
                    //update phone
                    String Phone = Utility.getPhone("Enter phone: ");
                    empTemp.setPhone(Phone);
                    break;
                case 5:
                    //update email
                    String Email = Utility.getEmail("Enter email: ");
                    empTemp.setEmail(Email);
                    break;
                case 6:
                    //update address
                    String Address = Utility.getInputString("Enter address: ");
                    empTemp.setAddress(Address);
                    break;
                case 7:
                    //update DOB
                    String DOB = Utility.getDate("Enter DOB: ");
                    empTemp.setSex(DOB);
                    break;
                case 8:
                    //update salary
                    double Salary = Utility.getSalary("Enter salary: ");
                    empTemp.setSalary(Salary);
                    break;
                case 9:
                    //update agency
                    String Agency = Utility.getInputString("Enter agency: ");
                    empTemp.setAgency(Agency);
                    break;
                case 10:
                    //return update each
                    return empTemp;
            }
            //ask use want to cotinue update
            if (Utility.getInputYN("Do you want to update other components (Y/N): ")) {
                continue;
            }
            return empTemp;
        }
    }
    
    //update all information of each emloyeess
    public static Employee updateAll(ArrayList<Employee> listEmployees, Employee emp) {
        String ID = Utility.getInputID(listEmployees, "Enter ID:");
        String FirstName = Utility.getInputString("Enter first name: ");
        String LastName = Utility.getInputString("Enter last name: ");
        String Phone = Utility.getPhone("Enter phone: ");
        String Email = Utility.getEmail("Enter email: ");
        String Address = Utility.getInputString("Enter address: ");
        String DOB = Utility.getDate("Enter DOB: ");
        String Sex = Utility.getSex("Enter sex: ");
        double Salary = Utility.getSalary("Enter salary: ");
        String Agency = Utility.getInputString("Enter agency: ");

        if (!emp.Compare(new Employee(ID, FirstName, LastName, Phone, Email, Address, DOB, Sex, Salary, Agency))) {
            return new Employee(ID, FirstName, LastName, Phone, Email, Address, DOB, Sex, Salary, Agency);
        }
        return emp;
    }
    
    //revove employees
    public static void removeEmployees(ArrayList<Employee> listEmployees) {
        //check list empty or not
        if (listEmployees.isEmpty()) {
            System.out.println("List Empty!!!");
            return;
        }
        String ID = Utility.getID(listEmployees, "Enter remove ID: ");
        int positionID = getPosID(listEmployees, ID);
        String Header = String.format("%-10s%-15s%-15s%-15s%-20s%-20s%-16s%-10s%-10s%s", "Id", "FirstName", "LastName", "Phone", "Email", "Address", "DOB", "Sex", "Salary", "Agency");
        System.out.println("Employees you want remove: ");
        System.out.println(Header + "\n" + listEmployees.get(positionID));
        //Ask the user if he wants to do the next action
        if (Utility.getInputYN("Are you sure to remove this employee (Y/N): ")) {
            //remove employees of list
            listEmployees.remove(positionID);
            System.out.println("The employee removed");
            return;
        }
        System.out.println("Nothing remove.");
    }
    
    //search employees 
    public static void searchEmployees(ArrayList<Employee> listEmployees) {
        //check list empty
        if (listEmployees.isEmpty()) {
            System.out.println("List Empty!!!");
            return;
        }
        String name = Utility.getInputString("Enter search name: ");
        ArrayList<Employee> EmpsContainName = new ArrayList<>();
        // run from the beginning of the array to the end of the array
        for (Employee emp : listEmployees) {
            //check if a string or a word exists in the list
            if (isEmpContainName(emp, name)) {
                EmpsContainName.add(emp);
            }
        }
        //check name exist or not
        if (EmpsContainName.isEmpty()) {
            System.out.println("No employee have this name.");
        } else {
            String Header = String.format("%-10s%-15s%-15s%-15s%-20s%-20s%-16s%-10s%-10s%s", "Id", "FirstName", "LastName", "Phone", "Email", "Address", "DOB", "Sex", "Salary", "Agency");
            System.out.println(Header);
            // run from the beginning of the array to the end of the array
            for (Employee emp : EmpsContainName) {
                System.out.println(emp);
            }
        }
    }
    
    // sort employees
    public static void sortEmployeesBySlary(ArrayList<Employee> listEmployees) {
        //check empty
        if (listEmployees.isEmpty()) {
            System.out.println("List Empty!!!");
            return;
        }
        //sort list
        Collections.sort(listEmployees);
        String Header = String.format("%-10s%-15s%-15s%-15s%-20s%-20s%-16s%-10s%-10s%s", "Id", "FirstName", "LastName", "Phone", "Email", "Address", "DOB", "Sex", "Salary", "Agency");
        System.out.println(Header);
        // run from the beginning of the array to the end of the array
        for (Employee emp : listEmployees) {
            System.out.println(emp);
        }
    }
    
    
    public static int getPosID(ArrayList<Employee> list, String ID) {
        // run from the beginning of the array to the end of the array
        for (int i = 0; i < list.size(); i++) {
            //check at that location that ID exists and is not case sensitive
            if (list.get(i).getId().equalsIgnoreCase(ID)) {
                return i;
            }
        }
        return -1;
    }

    public static boolean isEmpContainName(Employee emp, String name) {
        String Fullname = emp.getFirstName() + " " + emp.getLastName();
        //check if the word, and string is in the 1 string or not 
        return Fullname.toUpperCase().contains(name.toUpperCase());
    }

}

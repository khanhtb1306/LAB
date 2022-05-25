
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

        ArrayList<Employee> listEmployees = new ArrayList<>();
        Manager Manager = new Manager(listEmployees);

        //Step1: Display Menu
        Manager.displayMenu();

        while (true) {
            //Step2: ask the use to choice
            int choice = Manager.askTheUseToChoice();
            switch (choice) {
                case 1:
                    //Step 3: add employees
                    Manager.addEmployees(listEmployees);
                    break;
                case 2:
                    //Step 4: update employees
                    Manager.updateEmployees(listEmployees);
                    break;
                case 3:
                    //Step 5: remove employess
                    Manager.removeEmployees(listEmployees);
                    break;
                case 4:
                    //Step 6: Search emoloyess
                    Manager.searchEmployees(listEmployees);
                    break;
                case 5:
                    //Step 7: Sort employees by salary
                    Manager.sortEmployeesBySlary(listEmployees);
                    break;
                case 6:
                    //Step 8: Exit program
                    System.exit(0);
                    break;
            }
        }
    }
}

package employeemanagement;

import java.util.Scanner;



/**
 *
 * @author erik__000
 */
public class EmployeeManagement {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        UI ui = new UI();
        boolean loop = true;
        while (loop) {
            loop = ui.mainMenu();
        }
    }
    
}

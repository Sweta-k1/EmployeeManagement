package employeemanagement;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author erik__000
 */
public class UI {

    private final Scanner sc = new Scanner(System.in);
    private final EmployeeList el = new EmployeeList();

    public boolean mainMenu() {

        System.out.println("What do you want to do?: ");
        System.out.println("1. Employee Management");
        System.out.println("2. Employee Statistics");
        System.out.println("0. Exit");

        String input = sc.nextLine();

        if (input.equals("1") || input.equalsIgnoreCase("m") || input.toLowerCase().contains("management")) {
            managementMenu();

        } else if (input.equals("2") || input.equalsIgnoreCase("s") || input.toLowerCase().contains("statistics")) {
            if (el.getList().isEmpty()) {
                System.out.println("There are no registered employees");
            }
            else {
                statisticMenu();
            }
            
        } else if (input.equals("0") || input.equalsIgnoreCase("e") || input.equalsIgnoreCase("exit")) {
            return false;
        } else {
            System.out.println("Invalid Input");
        }
        return true;
    }

    public void managementMenu() {
        boolean loop = true;
        while (loop) {
            System.out.println("\nEmployee Management");

            System.out.println("What do you want to do?");
            System.out.println("1. Register employee");
            System.out.println("2. Remove employee");
            System.out.println("3. Update employee information");
            System.out.println("4. Search for an employee");
            System.out.println("5. List employees in a department");
            System.out.println("6. List all employees");
            System.out.println("7. (Test) Fill");
            System.out.println("0. Return to main menu");

            String input = sc.nextLine();

            switch (input) {
                case "1":
                    registerEmployee();
                    break;

                case "2":
                    if (el.getList().isEmpty()) {
                        System.out.println("There are no registered employees");
                    } else {
                        removeEmployee();
                    }
                    break;

                case "3":
                    if (el.getList().isEmpty()) {
                        System.out.println("There are no registered employees");
                    } else {
                        updateEmployee();
                    }
                    break;

                case "4":
                    if (el.getList().isEmpty()) {
                        System.out.println("There are no registered employees");
                    } else {
                        searchEmployee();
                    }
                    break;

                case "5":
                    if (el.getList().isEmpty()) {
                        System.out.println("There are no registered employees");
                    } else {
                        listByDepartment();
                    }
                    break;

                case "6":
                    if (el.getList().isEmpty()) {
                        System.out.println("There are no registered employees");
                    } else {
                        System.out.println(EmployeeListFormatter.format(el.getList()));
                    }
                    break;
                case "7":
                    
                    el.addEmployee("Bob", "Dylan", LocalDate.parse("1981-05-17"), 5000, Gender.MALE, "Chief");
                    el.addEmployee("Åsa", "Svensson", LocalDate.parse("1955-02-18"), 7000, Gender.FEMALE, "Developer");
                    el.addEmployee("Erik", "Tchang", LocalDate.parse("1995-11-02"), 7000, Gender.MALE, "Developer");
                    el.addEmployee("Mark", "Hamill", LocalDate.parse("1962-09-27"), 4500, Gender.MALE, "Marketing");
                    el.addEmployee("Stephen", "Spielberg", LocalDate.parse("1975-10-02"), 3300, Gender.MALE, "Secretary");
                    el.addEmployee("Laura", "Wasing", LocalDate.parse("1989-01-17"), 6500, Gender.FEMALE, "Technician");
                    el.addEmployee("John", "Greencroft", LocalDate.parse("1981-05-17"), 1200, Gender.MALE, "DBAdmin");
                    el.addEmployee("Delilah", "Lama", LocalDate.parse("1945-03-05"), 7000, Gender.FEMALE, "Chief");
                    el.addEmployee("Donald", "Trump", LocalDate.parse("1985-10-06"), 500, Gender.MALE, "Secretary");
                    el.addEmployee("Stefan", "Löfven", LocalDate.parse("1985-05-11"), 2700, Gender.MALE, "DBAdmin");
                    
                    System.out.println("Test employees added");
                    
                    break;
                    
                    
                case "0":
                    loop = false;
                    break;
                default:
                    break;
            }
        }
    }

    public boolean registerEmployee() {
        boolean registerLoop = true;
        while (registerLoop) {

            System.out.println("Enter the first name of the employee:");
            String firstName = sc.nextLine();

            System.out.println("Enter the last name of the employee:");
            String lastName = sc.nextLine();

            LocalDate birthDate = LocalDate.parse("1999-01-01");
            boolean inputLoop = true;
            while (inputLoop) {
                try {
                    System.out.println("Enter the birthdate of the employee (yyyy-mm-dd):");
                    String ageInput = sc.nextLine();
                    birthDate = LocalDate.parse(ageInput);
                    inputLoop = false;
                } catch (java.time.format.DateTimeParseException e) {
                    System.out.println("Invalid format");
                }
            }
            double salary = 0;
            inputLoop = true;
            while (inputLoop) {
                try {
                    System.out.println("Enter the salary of the employee");
                    salary = sc.nextDouble();
                    sc.nextLine();
                    inputLoop = false;
                } catch (java.util.InputMismatchException e) {
                    System.out.println("Invalid input");
                    sc.nextLine();
                }
            }
            Gender genderType = Gender.UNKNOWN;
            inputLoop = true;
            while (inputLoop) {
                System.out.println("Enter the gender of the employee (Male, Female, Unknown)");
                String gender = sc.nextLine().toUpperCase();

                switch (gender) {
                    case "MALE":
                        genderType = Gender.MALE;
                        inputLoop = false;
                        break;
                    case "FEMALE":
                        genderType = Gender.FEMALE;
                        inputLoop = false;
                        break;
                    case "UNKNOWN":
                        genderType = Gender.UNKNOWN;
                        inputLoop = false;
                        break;
                    default:
                        System.out.println("Invalid input");
                        break;
                }
            }
            inputLoop = true;
            while (inputLoop) {
                System.out.println("Enter the department of the employee (CHIEF(1), DBADMIN(2), DEVELOPER(3), MARKETING(4), SECRETARY(5), TECHNICIAN(6), WEBDESIGNER(7)):");
                String department = sc.nextLine().toUpperCase();
                inputLoop = el.addEmployee(firstName, lastName, birthDate, salary, genderType, department);
            }
                System.out.println("Employee registered");
            

            boolean repeatLoop = true;
            while (repeatLoop) {
                System.out.println("Do you want to try to add another employee? (y/n)");
                String input = sc.nextLine();
                if (input.equalsIgnoreCase("n") || input.equalsIgnoreCase("no") || input.equals("2")) {
                    return false;
                } else if (input.equalsIgnoreCase("y") || input.equalsIgnoreCase("yes") || input.equals("1")) {
                    repeatLoop = false;
                } else {
                    System.out.println("Invalid input");
                }
            }
        }
        return true;
    }

    public boolean removeEmployee() {
        while (true) {
            try {
                System.out.print("Enter the employee ID of the employee you want to remove:");
                int idInput = sc.nextInt();
                sc.nextLine();

                if (el.findEmployee(idInput) == null) {
                    System.out.println("Employee does not exist");
                } else {
                    el.deleteEmployee(idInput);
                    System.out.println("Employee removed");
                }
            } catch (java.util.InputMismatchException e) {
                sc.nextLine();
                System.out.println("Invalid input");
            } catch (java.lang.NullPointerException e) {
                System.out.println("Employee does not exist");
            }
            if (el.getList().isEmpty()) {
                return false;
            }
            
            boolean repeatLoop = true;
            while (repeatLoop) {
                System.out.println("Do you want to try to remove another employee? (y/n)");
                String input = sc.nextLine();
                if (input.equalsIgnoreCase("n") || input.equalsIgnoreCase("no")) {
                    return false;
                } else if (input.equalsIgnoreCase("y") || input.equalsIgnoreCase("yes")) {
                    repeatLoop = false;
                } else {
                    System.out.println("Invalid input");
                }
            }
        }
    }

    public boolean updateEmployee() {
        boolean loop = true;
        int idInput = 0;
        while (loop) {
            try {
                System.out.println("Enter the ID of the employee that you want to update?");
                idInput = sc.nextInt();
                sc.nextLine();
                loop = false;

                if (el.findEmployee(idInput) == null) {
                    System.out.println("Employee does not exist");
                    return false;
                }
            } catch (java.util.InputMismatchException e) {
                sc.nextLine();
                System.out.println("invalid input");
            }
        }
            loop = true;
            while (loop) {
                int updatedIndex = el.getList().indexOf(el.findEmployee(idInput));

                System.out.println("What information do you want to update?");
                System.out.println("1. Name");
                System.out.println("2. Department");
                System.out.println("3. Salary");
                System.out.println("0. Return to main menu");

                String input = sc.nextLine();

                if (input.equals("1") || input.equalsIgnoreCase("n") || input.equalsIgnoreCase("name")) {
                    System.out.print("Enter the updated first name: ");
                    input = sc.nextLine();
                    el.getList().get(updatedIndex).setFirstName(input);

                    System.out.print("Enter the updated last name: ");
                    input = sc.nextLine();
                    el.getList().get(updatedIndex).setLastName(input);

                    System.out.println("Name updated");

                } else if (input.equals("2") || input.equalsIgnoreCase("d") || input.equalsIgnoreCase("department")) {
                    
                    boolean departmentLoop = true;
                    while (departmentLoop) {
                        System.out.println("Enter the new department (CHIEF(1), DBADMIN(2), DEVELOPER(3), MARKETING(4), SECRETARY(5), TECHNICIAN(6), WEBDESIGNER(7)):");
                        String department = sc.nextLine().toUpperCase();
                        if (department.equalsIgnoreCase(el.getList().get(updatedIndex).getDepartment())) {
                            System.out.println("The employee is already in the " + department + " department");
                            departmentLoop = false;
                        }
                        else {
                            departmentLoop = el.updateDepartment(updatedIndex, department);
                        }
                    }
                    
                } else if (input.equals("3") || input.equalsIgnoreCase("s") || input.equalsIgnoreCase("salary")) {
                    
                    boolean salaryLoop = true;
                    while (salaryLoop) {
                        try {
                            System.out.print("Enter the new salary: ");
                            double salaryInput = sc.nextDouble();
                            sc.nextLine();
                            el.getList().get(updatedIndex).setSalary(salaryInput);
                            salaryLoop = false;
                        }
                        catch (java.util.InputMismatchException e) {
                            System.out.println("Invalid input");
                            sc.nextLine();
                        }
                    }
                    System.out.println("Salary updated");

                } else if (input.equals("0") || input.equalsIgnoreCase("r") || input.equalsIgnoreCase("return")) {
                    return false;
                }
                else {
                    System.out.println("Invalid input");
                }
            }
        return true;
    }

    public boolean searchEmployee() {
        boolean loop = true;
        while (loop) {
            System.out.println("Do you want to search by ID(1) or Name(2)?");
            String input = sc.nextLine();
            if (input.equalsIgnoreCase("id") || input.equalsIgnoreCase("i") || input.equals("1")) {
                System.out.println("Enter the ID of the employee");
                int id = sc.nextInt();
                sc.nextLine();
                if (el.findEmployee(id) == null) {
                    System.out.println("Employee not found");
                } else {
                    Employee foundEmployee = el.findEmployee(id);
                    System.out.println("Employee details:");
                    System.out.println(foundEmployee);
                }
            } else if (input.equalsIgnoreCase("name") || input.equalsIgnoreCase("n") || input.equals("2")) {
                System.out.println("Enter the name of the employee");
                input = sc.nextLine();
                if (el.findEmployee(input) == null) {
                    System.out.println("Employee not found");
                } else {
                    Employee foundEmployee = el.findEmployee(input);
                    System.out.println("Employee details:");
                    System.out.println(foundEmployee);
                }
            } else {
                System.out.println("Invalid input");
            }
            boolean repeatLoop = true;

            while (repeatLoop) {
                System.out.println("Do you want to search again? (y/n)");
                input = sc.nextLine();
                if (input.equalsIgnoreCase("n") || input.equalsIgnoreCase("no")) {
                    return false;
                } else if (input.equalsIgnoreCase("y") || input.equalsIgnoreCase("yes")) {
                    repeatLoop = false;
                } else {
                    System.out.println("Invalid input");
                }
            }

        }
        return true;
    }

    public boolean listByDepartment() {
        System.out.println("Which department do you want the employeelist of?");
        System.out.print("(CHIEF(1), DBADMIN(2), DEVELOPER(3), MARKETING(4), SECRETARY(5), TECHNICIAN(6), WEBDESIGNER(7): ");
        String department = sc.nextLine();
        switch (department) {
            case "1":
                department = "chief";
                break;
            case "2":
                department = "dbadmin";
                break;
            case "3":
                department = "developer";
                break;
            case "4":
                department = "marketing";
                break;
            case "5":
                department = "secretary";
                break;
            case "6":
                department = "technician";
                break;
            case "7":
                department = "webdesigner";
                break;
            default:
                break;
        }
        
        if (el.getDepartmentList(department).isEmpty()) {
            System.out.println("There are no registered employees in the entered department");
            return false;
        }
        System.out.println(EmployeeListFormatter.format(el.getDepartmentList(department)));
        return false;
    }
    
    
    public void statisticMenu() {
        boolean loop = true;
        while (loop) {
            System.out.println("\nEmployee Statistics");
            System.out.println("What do you want to do?");
            System.out.println("1. Salary statistics");
            System.out.println("2. Gender distribution");
            System.out.println("0. Return to main menu");
            String input = sc.nextLine();
            switch (input) {
                case "1":
                    boolean salaryLoop = true;
                    while (salaryLoop) {
                        salaryLoop = false;
                    System.out.println("What salary statistics do you want to see?");
                    System.out.println("1. Average base Salary");
                    System.out.println("2. Highest/Lowest base Salary");
                    System.out.println("3. Bonus Average");
                    System.out.println("4. Highest/Lowest Bonus");
                    System.out.println("5. Average total Salary");
                    System.out.println("6. Highest/Lowest total Salary");
                    System.out.println("7. All");
                    String salaryInput = sc.nextLine();
                    
                    switch (salaryInput) {
                        case "1":
                            averageBase();
                            break;
                        case "2":
                            highLowBase();
                            break;
                        case "3":
                            averageBonus();
                            break;
                        case "4":
                            highLowBonus();
                            break;
                        case "5":
                            averageTotal();
                            break;
                        case "6":
                            highLowTotal();
                            break;
                        case "7":
                            averageBase();
                            highLowBase();
                            averageBonus();
                            highLowBonus();
                            averageTotal();
                            highLowTotal();
                            break;
                        default:
                            System.out.println("Invalid input");
                            salaryLoop = true;
                            break;
                        }
                    }
                    break;

                case "2":
                    boolean genderLoop = true;
                    while (genderLoop) {
                        System.out.println("What gender statistics do you want to see?");
                        System.out.println("1. Distribution in the entire company");
                        System.out.println("2. Distribution within a specific department");
                        String genderInput = sc.nextLine();
                        
                        switch (genderInput) {
                            case "1":
                                genderDistribution();
                                genderLoop = false;
                                break;
                            case "2":
                                System.out.println("What department do you want to see?");
                                System.out.println("(Chief, DBAdmin, Developer, Secretary, Technician, Web Designer)");
                                String departmentInput = sc.nextLine().toUpperCase().trim();
                                if (el.getDepartmentList(departmentInput).isEmpty()) {
                                    System.out.println("There are no employees in the entered department");
                                }
                                else {
                                    genderDistribution(departmentInput);
                                }
                                genderLoop = false;
                                break;
                            default:
                                System.out.println("Invalid input");
                                break;
                        }
                    }
                    break;

                case "0":
                    loop = false;
                    break;
                default:
                    System.out.println("Invalid input");
                    break;
            }
        }
    }
    
    public void averageBase() {
        double total = 0;
        for (Employee e : el.getList()) {
            total += e.getSalary();
        }
        System.out.println("The average base salary is: " + total/el.getList().size());
    }
    
    public void highLowBase() {
        double min = 0;
        double max = 0;
        for (Employee e : el.getList()) {
            if (min > e.getSalary() || min == 0) {
                min = e.getSalary();
            }
            if (max < e.getSalary()) {
                max = e.getSalary();
            }
        }
        System.out.println("The lowest base salary is: " + min);
        System.out.println("The highest base salary is: " + max);
    }
    
    public void averageBonus() {
        double total = 0;
        for (Employee e : el.getList()) {
            total += e.bonus();
        }
        System.out.println("The average bonus is: " + total/el.getList().size());
    }
    
    public void highLowBonus() {
        double min = 0;
        double max = 0;
        for (Employee e : el.getList()) {
            if (min > e.bonus() || min == 0) {
                min = e.bonus();
            }
            if (max < e.bonus()) {
                max = e.bonus();
            }
        }
        System.out.println("The lowest bonus is: " + min);
        System.out.println("The highest bonus is: " + max);
    }
    
    public void averageTotal() {
        double total = 0;
        for (Employee e : el.getList()) {
            total += e.bonus();
            total += e.getSalary();
        }
        System.out.println("The average salary is: " + total/el.getList().size());
    }
    
    public void highLowTotal() {
        double min = 0;
        double max = 0;
        for (Employee e : el.getList()) {
            if (min > (e.bonus()+ e.getSalary()) || min == 0) {
                min = (e.bonus()+ e.getSalary());
            }
            if (max < (e.bonus()+ e.getSalary())) {
                max = (e.bonus()+ e.getSalary());
            }
        }
        System.out.println("The lowest salary is: " + min);
        System.out.println("The highest salary is: " + max);
    }
    
    public void genderDistribution() {
        double males = 0;
        double females = 0;
        for (Employee e : el.getList()) {
            if (e.getGender().equals(Gender.MALE)) {
                males++;
            }
            else if (e.getGender().equals(Gender.FEMALE)) {
                females++;
            }
        }
        System.out.println(((males/el.getList().size())*100) + "% are male, and " + ((females/el.getList().size())*100) + "% are female");
    }
    public void genderDistribution(String department) {
        double males = 0;
        double females = 0;
        ArrayList<Employee> depList= el.getDepartmentList(department);
        for (Employee e : depList) {
            if (e.getGender().equals(Gender.MALE)) {
                males++;
            }
            else if (e.getGender().equals(Gender.FEMALE)) {
                females++;
            }
        }
        System.out.println(((males/depList.size())*100) + "% are male, and " + ((females/depList.size())*100) + "% are female");
    }
}

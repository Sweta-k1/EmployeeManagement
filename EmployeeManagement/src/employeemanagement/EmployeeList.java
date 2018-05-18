package employeemanagement;

import java.time.LocalDate;
import java.util.ArrayList;

/**
 *
 * @author erik__000
 */
public class EmployeeList {
    private final ArrayList<Employee> list = new ArrayList<>();
    
    public boolean addEmployee(String firstName, String lastName, LocalDate birthDate, double salary, Gender gender, String department) {
        
        if (department.equals("1") || department.equalsIgnoreCase("chief")) {
            list.add(new Chief(firstName, lastName, birthDate, salary, gender));
        }
        else if(department.equals("2") || department.equalsIgnoreCase("dbadmin")) {
            list.add(new DBAdmin(firstName, lastName, birthDate, salary, gender));
        }
        else if(department.equals("3") || department.equalsIgnoreCase("developer")) {
            list.add(new Developer(firstName, lastName, birthDate, salary, gender));
        }
        else if(department.equals("4") || department.equalsIgnoreCase("marketing")) {
            list.add(new Marketing(firstName, lastName, birthDate, salary, gender));
        }
        else if(department.equals("5") || department.equalsIgnoreCase("secretary")) {
            list.add(new Secretary(firstName, lastName, birthDate, salary, gender));
        }
        else if(department.equals("6") || department.equalsIgnoreCase("technician")) {
            list.add(new Technician(firstName, lastName, birthDate, salary, gender));
        }
        else if(department.equals("7") || department.equalsIgnoreCase("webdesigner")) {
            list.add(new WebDesigner(firstName, lastName, birthDate, salary, gender));
        }
        else  {
            System.out.println("Invalid department");
                return true;
        }
        
        return false;
    }
    
    public void deleteEmployee(int index) {
        list.remove(findEmployee(index));
    }
    
    public Employee findEmployee(String name) {
        for (Employee e : list) {
            if (name.equals(e.getFirstName()) || name.equals(e.getLastName()) || name.equals(e.getFirstName() + " " + e.getLastName())) {
                return e;
            }
            
        }
        return null;
    }
    
    public Employee findEmployee(int number) {
        if (list.isEmpty()) {
            return null;
        }
        for (Employee e : list) {
            if (number == e.getEmployeeID()) {
                return e;
            }
        }
        return null;
    }
    
    public void showEmployeeList() {
        for (Employee e : list) {
            System.out.println(e);
        }
    }

    public ArrayList<Employee> getList() {
        return list;
    }
    
    public void showDepartmentList(String department) {
        
        for (Employee e : list) {
            if (department.equalsIgnoreCase(e.getDepartment())) {
                System.out.println(e);
            }
        }
        System.out.println("");
    } 
    
    public ArrayList<Employee> getDepartmentList(String department) {
        
        ArrayList<Employee> departmentList = new ArrayList<>();
        
        for (Employee e : list) {
            if (department.equalsIgnoreCase(e.getDepartment())) {
                departmentList.add(e);
            }
        }
        return departmentList;
    } 
    
    public boolean updateDepartment(int index, String department) {
        
        switch (department){
            case "CHIEF":
                Chief newChief = new Chief(list.get(index).getFirstName(), list.get(index).getLastName(), list.get(index).getBirthDate(), list.get(index).getSalary(), list.get(index).getGender(), list.get(index).getEmployeeID());
                list.remove(index);
                list.add(index, newChief);
                break;
            
            case "DBADMIN":
                DBAdmin newAdmin = new DBAdmin(list.get(index).getFirstName(), list.get(index).getLastName(), list.get(index).getBirthDate(), list.get(index).getSalary(), list.get(index).getGender(), list.get(index).getEmployeeID());
                list.remove(index);
                list.add(index, newAdmin);
                break;
            
            case "DEVELOPER":
                System.out.println(list.get(index).getFirstName());
                Developer newDeveloper = new Developer(list.get(index).getFirstName(), list.get(index).getLastName(), list.get(index).getBirthDate(), list.get(index).getSalary(), list.get(index).getGender(), list.get(index).getEmployeeID());
                list.remove(index);
                list.add(index, newDeveloper);
                break;
            
            case "MARKETING":
                Marketing newMarketer = new Marketing(list.get(index).getFirstName(), list.get(index).getLastName(), list.get(index).getBirthDate(), list.get(index).getSalary(), list.get(index).getGender(), list.get(index).getEmployeeID());
                list.remove(index);
                list.add(index, newMarketer);
                break;
            
            case "SECRETARY":
                Secretary newSecretary = new Secretary(list.get(index).getFirstName(), list.get(index).getLastName(), list.get(index).getBirthDate(), list.get(index).getSalary(), list.get(index).getGender(), list.get(index).getEmployeeID());
                list.remove(index);
                list.add(index, newSecretary);
                break;
            
            case "TECHNICIAN":
                Technician newTechnician = new Technician(list.get(index).getFirstName(), list.get(index).getLastName(), list.get(index).getBirthDate(), list.get(index).getSalary(), list.get(index).getGender(), list.get(index).getEmployeeID());
                list.remove(index);
                list.add(index, newTechnician);
                break;
            
            case "WEBDESIGNER":
                WebDesigner newDesigner = new WebDesigner(list.get(index).getFirstName(), list.get(index).getLastName(), list.get(index).getBirthDate(), list.get(index).getSalary(), list.get(index).getGender(), list.get(index).getEmployeeID());
                list.remove(index);
                list.add(index, newDesigner);
                break;
            default:
                System.out.println("Invalid department");
                return true;
        }
        System.out.println("Department updated");
        return false;
    }
    
}

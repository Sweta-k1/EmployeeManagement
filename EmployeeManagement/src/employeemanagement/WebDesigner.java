package employeemanagement;

import java.time.LocalDate;

/**
 *
 * @author User
 */
public class WebDesigner extends Employee {

    int numberOfPages;
    
    public WebDesigner(String firstName, String lastName, LocalDate birthDate, Double salary, Gender gender) {
        super(firstName, lastName, birthDate, salary, gender);
        super.setDepartment("WebDesigner");
    }
    public WebDesigner(String firstName, String lastName, LocalDate birthDate, Double salary, Gender gender, int id) {
        super(firstName, lastName, birthDate, salary, gender, id);
        super.setDepartment("WebDesigner");
    }

    public int getNumberOfPages() {
        return numberOfPages;
    }

    public void setNumberOfPages(int numberOfPages) {
        this.numberOfPages = numberOfPages;
    }
    
    @Override
    public double bonus() {
        double bonus;
        bonus = bonusBase + (numberOfPages*15);
        return bonus;
    }
    @Override
    public String toString() {
        return "Employee ID:" + getEmployeeID() + " " + getFirstName() + " " + getLastName() + ", Web Designer";
    }
}

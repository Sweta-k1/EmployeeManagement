package employeemanagement;

import java.time.LocalDate;

/**
 *
 * @author User
 */
public class Chief extends Employee {
    
    public Chief(String firstName, String lastName, LocalDate birthDate, Double salary, Gender gender) {
        super(firstName, lastName, birthDate, salary, gender);
        super.setDepartment("Chief");
    }
    
    public Chief(String firstName, String lastName, LocalDate birthDate, Double salary, Gender gender, int id) {
        super(firstName, lastName, birthDate, salary, gender, id);
        super.setDepartment("Chief");
    }
    
    @Override
    public double bonus() {
        double bonus;
        bonus = bonusBase + (getEmployeeNumber()*50);
        return bonus;
    }
    
    @Override
    public String toString() {
        return "Employee ID:" + getEmployeeID() + " " + getFirstName() + " " + getLastName() + ", Chief";
    }
}

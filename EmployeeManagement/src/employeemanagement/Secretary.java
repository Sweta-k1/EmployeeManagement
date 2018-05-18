package employeemanagement;

import java.time.LocalDate;

/**
 *
 * @author User
 */
public class Secretary extends Employee {
    
    int age = LocalDate.now().getYear()-super.birthDate.getYear();

    public Secretary(String firstName, String lastName, LocalDate birthDate, Double salary, Gender gender) {
        super(firstName, lastName, birthDate, salary, gender);
        super.setDepartment("Secretary");
    }
    public Secretary(String firstName, String lastName, LocalDate birthDate, Double salary, Gender gender, int id) {
        super(firstName, lastName, birthDate, salary, gender, id);
        super.setDepartment("Secretary");
    }
    
    @Override
    public double bonus() {
        double bonus;
        bonus = bonusBase + (age*12);
        return bonus;
    }
    @Override
    public String toString() {
        return "Employee ID:" + getEmployeeID() + " " + getFirstName() + " " + getLastName() + ", Secretary";
    }
}

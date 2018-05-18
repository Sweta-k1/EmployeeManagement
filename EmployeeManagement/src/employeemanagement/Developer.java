package employeemanagement;

import java.time.LocalDate;

/**
 *
 * @author User
 */
public class Developer extends Employee{

    int linesOfCode;

    
    public Developer(String firstName, String lastName, LocalDate birthDate, Double salary, Gender gender) {
        super(firstName, lastName, birthDate, salary, gender);
        super.setDepartment("Developer");
    }
    public Developer(String firstName, String lastName, LocalDate birthDate, Double salary, Gender gender, int id) {
        super(firstName, lastName, birthDate, salary, gender, id);
        super.setDepartment("Developer");
    }

    public int getLinesOfCode() {
        return linesOfCode;
    }

    public void setLinesOfCode(int linesOfCode) {
        this.linesOfCode = linesOfCode;
    }
    
    @Override
    public double bonus() {
        double bonus = 0;
        bonus = bonusBase+linesOfCode;
        return bonus;
    }
    @Override
    public String toString() {
        return "Employee ID:" + getEmployeeID() + " " + getFirstName() + " " + getLastName() + ", Developer";
    }
}

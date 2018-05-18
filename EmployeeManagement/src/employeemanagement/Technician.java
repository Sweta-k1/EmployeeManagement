package employeemanagement;

import java.time.LocalDate;

/**
 *
 * @author User
 */
public class Technician extends Employee{

    int numberOfBugs;
    
    public Technician(String firstName, String lastName, LocalDate birthDate, Double salary, Gender gender) {
        super(firstName, lastName, birthDate, salary, gender);
        super.setDepartment("Technician");
    }
    public Technician(String firstName, String lastName, LocalDate birthDate, Double salary, Gender gender, int id) {
        super(firstName, lastName, birthDate, salary, gender, id);
        super.setDepartment("Technician");
    }
    
    @Override
    public double bonus() {
        double bonus = bonusBase - (numberOfBugs*2);
        if (bonus<0) {
            return 0;
        }
        return bonus;
    }

    public int getNumberOfBugs() {
        return numberOfBugs;
    }

    public void setNumberOfBugs(int numberOfBugs) {
        this.numberOfBugs = numberOfBugs;
    }
    @Override
    public String toString() {
        return "Employee ID:" + getEmployeeID() + " " + getFirstName() + " " + getLastName() + ", Technician";
    }
    
}

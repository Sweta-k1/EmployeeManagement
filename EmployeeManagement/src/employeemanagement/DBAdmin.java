package employeemanagement;

import java.time.LocalDate;

/**
 *
 * @author User
 */
public class DBAdmin extends Employee {
    
    int serverCrashes;

    public DBAdmin(String firstName, String lastName, LocalDate birthDate, Double salary, Gender gender) {
        super(firstName, lastName, birthDate, salary, gender);
        super.setDepartment("DBAdmin");
    }
    public DBAdmin(String firstName, String lastName, LocalDate birthDate, Double salary, Gender gender, int id) {
        super(firstName, lastName, birthDate, salary, gender, id);
        super.setDepartment("DBAdmin");
    }
    
    @Override
    public double bonus() {
        double bonus = bonusBase - (serverCrashes*25);
        if (bonus<0) {
            return 0;
        }
        return bonus;
    }
    
    public void serverCrash() {
        serverCrashes++;
    }
    @Override
    public String toString() {
        return "Employee ID:" + getEmployeeID() + " " + getFirstName() + " " + getLastName() + ", DBAdmin";
    }
}

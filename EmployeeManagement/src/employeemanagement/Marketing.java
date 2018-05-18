package employeemanagement;

import java.time.LocalDate;

/**
 *
 * @author User
 */
public class Marketing extends Employee {
    
    int sales;
        
    public Marketing(String firstName, String lastName, LocalDate birthDate, Double salary, Gender gender) {
        super(firstName, lastName, birthDate, salary, gender);
        super.setDepartment("Marketing");
    }
    public Marketing(String firstName, String lastName, LocalDate birthDate, Double salary, Gender gender, int id) {
        super(firstName, lastName, birthDate, salary, gender, id);
        super.setDepartment("Marketing");
    }

    public int getSales() {
        return sales;
    }

    public void setSales(int sales) {
        this.sales = sales;
    }
    
    @Override
    public double bonus() {
        double bonus = 0;
        bonus = bonusBase+(sales*100);
        return bonus;
    }
    @Override
    public String toString() {
        return "Employee ID:" + getEmployeeID() + " " + getFirstName() + " " + getLastName() + ", Marketing";
    }
}

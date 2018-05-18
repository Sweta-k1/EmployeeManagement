package employeemanagement;

import java.time.LocalDate;
import static java.time.temporal.ChronoUnit.YEARS;

/**
 *
 * @author erik__000
 */
public class Employee {
    private String firstName;
    private String lastName;
    private Double salary;
    private Gender gender;
    protected LocalDate birthDate;
    private long age;
    private int employeeID;
    private static int employeeNumber = 1;
    protected final double bonusBase;
    private String department;

    public Employee(String firstName, String lastName, LocalDate birthDate, Double salary, Gender gender) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDate = birthDate;
        this.salary = salary;
        this.gender = gender;
        employeeID = employeeNumber;
        employeeNumber++;
        bonusBase = 5000;
        department =  "No Department";
        this.age = age(birthDate);
    }
    public Employee(String firstName, String lastName, LocalDate birthDate, Double salary, Gender gender, int id) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDate = birthDate;
        this.salary = salary;
        this.gender = gender;
        this.employeeID = id;
        bonusBase = 5000;
        department =  "No Department";
        this.age = age(birthDate);
    }
    
    public void setDepartment(String department) {
        this.department = department;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthdate(LocalDate birthdate) {
        this.birthDate = birthdate;
    }
    
    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }
    
    public int getEmployeeNumber() {
        return employeeNumber;
    }
    
    public int getEmployeeID() {
        return employeeID;
    }

    public String getDepartment() {
        return department;
    }
    
    public double bonus() {
        return 0;
    }
    
    private long age(LocalDate birthDate) {
        LocalDate now = LocalDate.now();
        long calcAge = YEARS.between(birthDate, now);
        return calcAge;
    }

    public long getAge() {
        return age;
    }
    
    @Override
    public String toString() {
        return "Employee{" + "employeeID=" + employeeID + ", firstName=" + firstName + ", lastName=" + lastName + ", salary=" + salary + ", department=" + department + ", age=" + age + '}'+"\n";
    }
}

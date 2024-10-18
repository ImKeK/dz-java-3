import java.time.LocalDate;
import java.util.Arrays;

enum Gender {
    MALE, FEMALE
}

enum Holiday {
    NONE, NEW_YEAR, MARCH_8, FEBRUARY_23
}

class Employee {
    private String name;
    private double salary;
    private Gender gender;

    public Employee(String name, double salary, Gender gender) {
        this.name = name;
        this.salary = salary;
        this.gender = gender;
    }

    public String getName() {
        return name;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "Employee{name='" + name + "', salary=" + salary + ", gender=" + gender + "}";
    }
}

class Customer {
    private String name;
    private Gender gender;

    public Customer(String name, Gender gender) {
        this.name = name;
        this.gender = gender;
    }

    public String getName() {
        return name;
    }

    public Gender getGender() {
        return gender;
    }
}

public class Main {
    public static void main(String[] args) {
        Employee[] employees = new Employee[3];
        employees[0] = new Employee("Alice", 50000, Gender.FEMALE);
        employees[1] = new Employee("Bob", 60000, Gender.MALE);
        employees[2] = new Employee("Charlie", 80000, Gender.MALE);

        congratulateEmployees(employees);
    }

    public static void congratulateEmployees(Employee[] employees) {
        LocalDate today = LocalDate.now();

        Holiday holiday = determineHoliday(today);

        for (Employee employee : employees) {
            switch (holiday) {
                case NEW_YEAR:
                    System.out.println("С Новым Годом, " + employee.getName() + "!");
                    break;
                case MARCH_8:
                    if (employee.getGender() == Gender.FEMALE) {
                        System.out.println("С 8 Марта, " + employee.getName() + "!");
                    }
                    break;
                case FEBRUARY_23:
                    if (employee.getGender() == Gender.MALE) {
                        System.out.println("С 23 Февраля, " + employee.getName() + "!");
                    }
                    break;
                default:
                    break;
            }
        }
    }

    public static Holiday determineHoliday(LocalDate date) {
        if (date.getMonthValue() == 1 && date.getDayOfMonth() == 1) { // Новый Год
            return Holiday.NEW_YEAR;
        } else if (date.getMonthValue() == 3 && date.getDayOfMonth() == 8) { // 8 Марта
            return Holiday.MARCH_8;
        } else if (date.getMonthValue() == 2 && date.getDayOfMonth() == 23) { // 23 Февраля
            return Holiday.FEBRUARY_23;
        }
        return Holiday.NONE; // Нет праздника
    }
}
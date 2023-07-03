import java.util.Scanner;

public class MidYearBonusCalculator {

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    // Prompt for the sale performance in percentage.
    System.out.print("Enter the sale performance in percentage: ");
    double salePerformance = scanner.nextDouble();

    // Read the employee data from the file.
    Employee[] employees = new Employee[0];
    try (Scanner employeeDataFileScanner = new Scanner("employee_data.txt")) {
      while (employeeDataFileScanner.hasNextLine()) {
        String[] employeeData = employeeDataFileScanner.nextLine().split(",");
        employees.add(new Employee(employeeData[0], employeeData[1], Float.parseFloat(employeeData[2])));
      }
    }

    // Calculate the mid-year bonus for each employee.
    for (Employee employee : employees) {
      if (salePerformance >= 100) {
        employee.setBonus(employee.getSalary() * salePerformance / 200);
      } else {
        employee.setBonus(0.0);
      }
    }

    // Print the employee ID, employee name, and bonus.
    for (Employee employee : employees) {
      System.out.println("Employee ID: " + employee.getId() + " Employee Name: " + employee.getName() + " Bonus: $" + employee.getBonus());
    }
  }
}

class Employee {
  private String id;
  private String name;
  private float salary;
  private float bonus;

  public Employee(String id, String name, float salary) {
    this.id = id;
    this.name = name;
    this.salary = salary;
    this.bonus = 0.0;
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public float getSalary() {
    return salary;
  }

  public void setSalary(float salary) {
    this.salary = salary;
  }

  public float getBonus() {
    return bonus;
  }

  public void setBonus(float bonus) {
    this.bonus = bonus;
  }
}

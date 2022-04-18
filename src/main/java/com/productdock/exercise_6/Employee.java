package com.productdock.exercise_6;

public class Employee {

  private float salary;
  private float bonusPercentage;
  private EmployeeType employeeType;

  public Employee(float salary, float bonusPercentage, EmployeeType employeeType) {
    this.salary = salary;
    this.bonusPercentage = bonusPercentage;
    this.employeeType = employeeType;
  }

  public float calculateSalary() {
    return switch (employeeType) {
      case Worker -> salary;
      case Supervisor -> salary + (bonusPercentage * 0.5F);
      case Manager -> salary + (bonusPercentage * 0.7F);
    };
  }

  public float calculateYearBonus() {
    return switch (employeeType) {
      case Worker -> 0;
      case Supervisor -> salary + salary * 0.7F;
      case Manager -> salary + salary * 1.1F;
    };
  }

}

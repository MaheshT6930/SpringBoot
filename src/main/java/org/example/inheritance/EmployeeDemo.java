package org.example.inheritance;

public class EmployeeDemo {

    public static void main(String[] args) {
        EmployeeDetails fullTimeEmployee = new FullTimeEmployee(
                1, "SACHIN", "TENDULKAR", "20-20, EAST, MUMBAI", 9999.99, 2000);
        fullTimeEmployee.employeeBasicDetails();

        EmployeeDetails partTimeEmployee = new PartTimeEmployee(
                2, "MS", "DHONI", "50-50, SOUTH, CHENNAI", 150, 90);
        partTimeEmployee.employeeBasicDetails();
    }
}

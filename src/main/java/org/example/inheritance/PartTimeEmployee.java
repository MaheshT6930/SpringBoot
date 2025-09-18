package org.example.inheritance;

public class PartTimeEmployee extends  EmployeeDetails{
    private double amountPerHours;
    private int hoursWorked;


    public PartTimeEmployee(int id, String lastName,String firstName, String address, double amountPerHours, int hoursWorked) {
        super(id, lastName, firstName, address);
        this.amountPerHours = amountPerHours;
        this.hoursWorked = hoursWorked;
    }
    public double computeSalary(){
        return amountPerHours*hoursWorked;
    }

    @Override
    public void employeeBasicDetails() {
        super.employeeBasicDetails();
        System.out.println("Part_time Employee Salary : " + computeSalary());
    }
}

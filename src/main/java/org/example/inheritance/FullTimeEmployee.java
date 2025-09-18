package org.example.inheritance;

public class FullTimeEmployee extends   EmployeeDetails{

    private double basic;
    private double bonus;


    public FullTimeEmployee(int id, String lastName,String firstName, String address, double basic, double bonus) {
        super(id, lastName, firstName, address);
        this.basic = basic;
        this.bonus = bonus;
    }

    public double computeSalary(){
        return bonus+basic;
    }

    @Override
    public void employeeBasicDetails() {
        super.employeeBasicDetails();
        System.out.println("Full-time Employee Salary: " + computeSalary());
    }
}

package org.example.inheritance;

public class PartTimeEmployee implements EmployeeDetails{

    private int id;
    private String firstName;
    private String lastName;
    private String address;
    private double amountPerHours;
    private int hoursWorked;

    public PartTimeEmployee() {}

    public PartTimeEmployee(int id, String firstName, String lastName, String address,
                            double amountPerHours, int hoursWorked) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.amountPerHours = amountPerHours;
        this.hoursWorked = hoursWorked;
    }

    @Override
    public String getFullName() {
        return firstName + " " + lastName;
    }

    @Override
    public double computeSal() {
        return amountPerHours * hoursWorked;
    }

    @Override
    public void showDetails() {
        System.out.println("Id : " + id);
        System.out.println("Full Name : " + getFullName());
        System.out.println("Address : " + address);
        System.out.println("Gross Salary : " + computeSal());
    }
}

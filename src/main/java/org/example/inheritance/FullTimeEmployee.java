package org.example.inheritance;

public class FullTimeEmployee implements  EmployeeDetails{

    private int id;
    private String firstName;
    private String lastName;
    private String address;
    private double basic;
    private double bonus;

    public FullTimeEmployee() {}

    public FullTimeEmployee(int id, String firstName, String lastName, String address,
                            double basic, double bonus) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.basic = basic;
        this.bonus = bonus;
    }

    @Override
    public String getFullName() {
        return firstName + " " + lastName;
    }

    @Override
    public double computeSal() {
        return basic + bonus;
    }

    @Override
    public void showDetails() {
        System.out.println("Id : " + id);
        System.out.println("Full Name : " + getFullName());
        System.out.println("Address : " + address);
        System.out.println("Gross Salary : " + computeSal());
    }
}

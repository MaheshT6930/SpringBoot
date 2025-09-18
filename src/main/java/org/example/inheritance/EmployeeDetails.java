package org.example.inheritance;


abstract class EmployeeDetails {
    int id;
    String lastName;

    String firstName;

    String address;

    public EmployeeDetails(int id, String lastName,String firstName, String address) {
        this.id = id;
        this.lastName = lastName;
        this.firstName = firstName;
        this.address  = address;

    }

   public abstract double computeSalary();

    public void employeeBasicDetails() {
        System.out.println("Employee_Id: " + id);
        System.out.println("Employee_Name: " + firstName + " " + lastName);
        System.out.println("Employee_Address:  " + address);
    }
}
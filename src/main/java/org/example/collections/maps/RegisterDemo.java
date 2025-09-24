package org.example.collections.maps;

import java.util.Scanner;

public class RegisterDemo {
    public static void main(String[] args) {
        RegisterInfo registerInfo = new RegisterInfo();

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n------- Menu -------");
            System.out.println("1. Add a contact");
            System.out.println("2. Delete a contact");
            System.out.println("3. Search for a contact");
            System.out.println("4. Display all contacts");
            System.out.print("Enter choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            if (choice == 1) {
                System.out.print("Enter name: ");
                String name = scanner.nextLine();
                System.out.print("Enter number: ");
                String number = scanner.nextLine();
                System.out.println(registerInfo.addEmployee(name, number));
            } else if (choice == 2) {
                System.out.print("Enter name to delete: ");
                String name = scanner.nextLine();
                System.out.println(registerInfo.deleteEmployee(name));
            } else if (choice == 3) {
                System.out.print("Enter name to search: ");
                String name = scanner.nextLine();
                System.out.println(registerInfo.searchEmployee(name));
            } else if (choice == 4) {
                registerInfo.dispayEmployeeInfo();

            } else {
                System.out.println("Exit");
            }
        }
    }


}



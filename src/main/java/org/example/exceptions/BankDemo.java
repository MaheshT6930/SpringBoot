package org.example.exceptions;

public class BankDemo {
    public static void main(String[] args) {
        BankAccount account1 = new BankAccount("123456789", "Ria", 5000);

        account1.display();

        account1.deposit(2000);
        account1.display();

        account1.withdraw(5500);
        account1.display();

        account1.withdraw(2000);
        account1.display();

        account1.withdraw(-500);
        account1.display();
    }

}

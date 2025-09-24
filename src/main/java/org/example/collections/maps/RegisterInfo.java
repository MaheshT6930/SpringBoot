package org.example.collections.maps;

import java.util.HashMap;
import java.util.Map;

public class RegisterInfo {

    Map<String, String> register = new HashMap<>();

    public String addEmployee(String name, String number) {
        register.put(name, number);
        return "Employee added";
    }


    public String deleteEmployee(String name) {
        if (register.containsKey(name)) {
            register.remove(name);
            return "employee deleted";
        } else {
            return "employee not found";
        }
    }

    public String searchEmployee(String name) {
        if (register.containsKey(name)) {
            return "employee exists in the register: " + register.get(name);
        } else {
            return " employee not found ";
        }
    }

    public void dispayEmployeeInfo() {
        if (register.isEmpty()) {
            System.out.println("No records found");
        } else {
            for (Map.Entry<String, String> myRegister : register.entrySet()) {
                System.out.println(myRegister.getKey() + "  " + myRegister.getValue());
            }
        }
    }
}

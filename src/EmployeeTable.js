import React, { useState } from 'react';
import './EmployeeTable.css'; 

export default function EmployeeTable() {

  const [employeesList, setEmployee] = useState([
    { EmployeeId: 101, EmpName: "Mahesh", Email: "mahesh@example.com", Password: "pass101", Address: "Hyderabad" },
    { EmployeeId: 102, EmpName: "Rahul", Email: "rahul@example.com", Password: "pass102", Address: "Bangalore" },
    { EmployeeId: 103, EmpName: "Sneha", Email: "sneha@example.com", Password: "pass103", Address: "Chennai" },
    { EmployeeId: 104, EmpName: "Arjun", Email: "arjun@example.com", Password: "pass104", Address: "Mumbai" },
    { EmployeeId: 105, EmpName: "Kiran", Email: "kiran@example.com", Password: "pass105", Address: "Delhi" }
  ]);

  return (
    <div className="table-container">
      <h2>Employee Details</h2>
      <table>
        <thead>
          <tr>
            <th>Employee ID</th>
            <th>Name</th>
            <th>Email</th>
            <th>Password</th>
            <th>Address</th>
          </tr>
        </thead>
        <tbody>
          {employeesList.map((emp, index) => (
            <tr key={index}>
              <td>{emp.EmployeeId}</td>
              <td>{emp.EmpName}</td>
              <td>{emp.Email}</td>
              <td>{emp.Password}</td>
              <td>{emp.Address}</td>
            </tr>
          ))}
        </tbody>
      </table>
    </div>
  );
}

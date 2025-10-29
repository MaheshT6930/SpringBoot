import React, { useState, useEffect } from 'react';
import axios from 'axios';
import './EmployeeTable.css'; 

export default function EmployeeTable() {
  const [employeeList, setEmployee] = useState([]);
  const [editingEmployee, setEditingEmployee] = useState(null); // store employee being edited
  const [updatedData, setUpdatedData] = useState({ name: "", emailId: "", password: "", address: "" });

  // Fetch all employees on load
  useEffect(() => {
    axios.get('http://localhost:8082/getAllUsers')
      .then(res => {
        setEmployee(res.data);
      })
      .catch(err => {
        console.error('Error fetching employees', err);
      });
  }, []);

  // Delete employee
  const deleteEmployee = (id) => {
    axios.delete(`http://localhost:8082/delete/${id}`)
      .then(() => {
        alert('Employee deleted successfully.');
        setEmployee(employeeList.filter(employee => employee.id !== id));
      })
      .catch(err => {
        console.error('Error deleting employee', err);
      });
  };

  // Start editing an employee
  const startEditing = (employee) => {
    setEditingEmployee(employee.id);
    setUpdatedData({
      name: employee.name,
      emailId: employee.emailId,
      password: employee.password,
      address: employee.address
    });
  };

  // Handle input changes while editing
  const handleChange = (e) => {
    setUpdatedData({ ...updatedData, [e.target.name]: e.target.value });
  };

  // Save updated employee data (PUT request)
  const saveUpdate = (id) => {
    axios.put(`http://localhost:8082/update/${id}`, updatedData)
      .then(() => {
        alert('Employee updated successfully.');
        setEmployee(employeeList.map(emp => emp.id === id ? { ...emp, ...updatedData } : emp));
        setEditingEmployee(null); // close editing mode
      })
      .catch(err => {
        console.error('Error updating employee', err);
      });
  };

  // Cancel editing
  const cancelEdit = () => {
    alert('cancel editing..');
    setEditingEmployee(null);
  };

  return (
    <div className='container mt-4'>
      <h2>Employee List</h2>
      <table className='table table-bordered table-striped table-centered'>
        <thead>
          <tr>
            <th>User Id</th>
            <th>User Name</th>
            <th>User EmailId</th>
            <th>User Password</th>
            <th>User Address</th>
            <th>Actions</th>
          </tr>
        </thead>
        <tbody>
          {employeeList.map((employee) => (
            <tr key={employee.id}>
              <td>{employee.id}</td>

              {editingEmployee === employee.id ? (
                <>
                  <td><input type="text" name="name" value={updatedData.name} onChange={handleChange} /></td>
                  <td><input type="text" name="emailId" value={updatedData.emailId} onChange={handleChange} /></td>
                  <td><input type="text" name="password" value={updatedData.password} onChange={handleChange} /></td>
                  <td><input type="text" name="address" value={updatedData.address} onChange={handleChange} /></td>
                  <td>
                    <button className="btn btn-success me-2" onClick={() => saveUpdate(employee.id)}>Save</button>
                    <button className="btn btn-secondary" onClick={cancelEdit}>Cancel</button>
                  </td>
                </>
              ) : (
                <>
                  <td>{employee.name}</td>
                  <td>{employee.emailId}</td>
                  <td>{employee.password}</td>
                  <td>{employee.address}</td>
                  <td>
                    <button className="btn btn-warning me-2" onClick={() => startEditing(employee)}>Edit</button>
                    <button className="btn btn-danger" onClick={() => deleteEmployee(employee.id)}>Delete</button>
                  </td>
                </>
              )}
            </tr>
          ))}
        </tbody>
      </table>
    </div>
  );
}

import React from 'react';
import Paper from '@mui/material/Paper';
import Button from '@mui/material/Button';
import DeleteIcon from '@mui/icons-material/Delete';
import EditIcon from '@mui/icons-material/Edit';

function EmployeeList({ employees, handleDeleteClick, handleEditClick, paperStyle }) {
  return (
    <Paper elevation={3} style={paperStyle}>
      <table>
        <thead>
          <tr>
            <th>Name</th>
            <th>ID</th>
            <th>Phone Number</th>
            <th>Department</th>
            <th>Currently Working</th>
            <th>Action</th>
          </tr>
        </thead>
        <tbody>
          {employees.map((employee) => (
            <tr key={employee.id}>
              <td>{employee.name}</td>
              <td>{employee.id}</td>
              <td>{employee.phoneNumber}</td>
              <td>{employee.department}</td>
              <td>{employee.isCurrentlyWorking ? 'Yes' : 'No'}</td>
              <td>
                <Button
                  variant="contained"
                  color="secondary"
                  startIcon={<DeleteIcon />}
                  onClick={() => handleDeleteClick(employee.id)}
                >
                  Delete
                </Button>
                <Button
                  variant="contained"
                  color="primary"
                  startIcon={<EditIcon />}
                  style={{ marginLeft: '10px' }}
                  onClick={() => handleEditClick(employee)}
                >
                  Edit
                </Button>
              </td>
            </tr>
          ))}
        </tbody>
      </table>
    </Paper>
  );
}

export default EmployeeList;

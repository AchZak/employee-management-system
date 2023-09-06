import * as React from 'react';
import Container from '@mui/material/Container';
import Paper from '@mui/material/Paper';
import EmployeeForm from './EmployeeForm'; // Import the EmployeeForm component
import EmployeeList from './EmployeeList'; // Import the EmployeeList component
import EditEmployeeModal from './EditEmployeeModal'; // Import the EditEmployeeModal component

export default function Employee() {
  const paperStyle = {
    padding: 20,
    width: 800,
    margin: '20px auto',
  };

  const [name, setName] = React.useState('');
  const [phoneNumber, setPhoneNumber] = React.useState('');
  const [department, setDepartment] = React.useState('');
  const [isCurrentlyWorking, setIsCurrentlyWorking] = React.useState(true);
  const [employees, setEmployees] = React.useState([]);
  const [openEditModal, setOpenEditModal] = React.useState(false);

  // Edit employee fields
  const [editName, setEditName] = React.useState('');
  const [editPhoneNumber, setEditPhoneNumber] = React.useState('');
  const [editDepartment, setEditDepartment] = React.useState('');
  const [editCurrentlyWorking, setEditCurrentlyWorking] = React.useState(true);

  // State to track the currently edited employee
  const [editingEmployeeId, setEditingEmployeeId] = React.useState(null);

  const handleAddClick = (e) => {
    e.preventDefault();
    const employee = { name, phoneNumber, department, isCurrentlyWorking };

    fetch("http://localhost:8080/api/v1/employees", {
      method: "POST",
      headers: { "Content-Type": "application/json" },
      body: JSON.stringify(employee),
    })
      .then(() => {
        console.log("New employee added");
        setName('');
        setPhoneNumber('');
        setDepartment('');
        setIsCurrentlyWorking(true);
        fetchEmployees();
      });
  };

  const fetchEmployees = () => {
    fetch("http://localhost:8080/api/v1/employees")
      .then((res) => res.json())
      .then((result) => {
        setEmployees(result);
      });
  };

  React.useEffect(() => {
    fetchEmployees();
  }, []);

  const handleDeleteClick = (id) => {
    fetch(`http://localhost:8080/api/v1/employees/${id}`, {
      method: "DELETE",
    })
      .then(() => {
        console.log("Employee deleted");
        fetchEmployees();
      });
  };

  const handleEditClick = (employee) => {
    // Set the currently edited employee
    setEditingEmployeeId(employee.id);
    setEditName(employee.name);
    setEditPhoneNumber(employee.phoneNumber);
    setEditDepartment(employee.department);
    setEditCurrentlyWorking(employee.isCurrentlyWorking);
    // Open the edit modal
    setOpenEditModal(true);
  };

  const handleUpdateClick = () => {
    const updatedEmployee = {
      id: editingEmployeeId,
      name: editName,
      phoneNumber: editPhoneNumber,
      department: editDepartment,
      isCurrentlyWorking: editCurrentlyWorking,
    };

    fetch(`http://localhost:8080/api/v1/employees/${editingEmployeeId}`, {
      method: "PUT",
      headers: { "Content-Type": "application/json" },
      body: JSON.stringify(updatedEmployee),
    })
      .then(() => {
        console.log("Employee updated");
        setOpenEditModal(false);
        setEditingEmployeeId(null);
        fetchEmployees();
      });
  };

  const handleEditModalClose = () => {
    setOpenEditModal(false);
    setEditingEmployeeId(null);
  };

  return (
    <Container>
      <Paper elevation={3} style={paperStyle}>
        <EmployeeForm
          name={name}
          phoneNumber={phoneNumber}
          department={department}
          isCurrentlyWorking={isCurrentlyWorking}
          setName={setName}
          setPhoneNumber={setPhoneNumber}
          setDepartment={setDepartment}
          setIsCurrentlyWorking={setIsCurrentlyWorking}
          handleAddClick={handleAddClick}
        />
      </Paper>
      <Paper elevation={3} style={paperStyle}>
        <EmployeeList
          employees={employees}
          handleDeleteClick={handleDeleteClick}
          handleEditClick={handleEditClick}
        />
      </Paper>
      <EditEmployeeModal
        open={openEditModal}
        handleClose={handleEditModalClose}
        editName={editName}
        setEditName={setEditName}
        editPhoneNumber={editPhoneNumber}
        setEditPhoneNumber={setEditPhoneNumber}
        editDepartment={editDepartment}
        setEditDepartment={setEditDepartment}
        editCurrentlyWorking={editCurrentlyWorking}
        setEditCurrentlyWorking={setEditCurrentlyWorking}
        handleUpdateClick={handleUpdateClick}
      />
    </Container>
  );
}

// EmployeeForm.js

import React from 'react';
import TextField from '@mui/material/TextField';
import Button from '@mui/material/Button';
import FormControlLabel from '@mui/material/FormControlLabel';
import Checkbox from '@mui/material/Checkbox';

export default function EmployeeForm({
  name,
  phoneNumber,
  department,
  isCurrentlyWorking,
  setName,
  setPhoneNumber,
  setDepartment,
  setIsCurrentlyWorking,
  handleAddClick,
}) {
  return (
    <form noValidate autoComplete="off">
      <div>
        <TextField
          id="outlined-basic"
          label="Name"
          variant="outlined"
          value={name}
          onChange={(e) => setName(e.target.value)}
        />
      </div>
      <div>
        <TextField
          id="outlined-basic"
          label="Phone Number"
          variant="outlined"
          value={phoneNumber}
          onChange={(e) => setPhoneNumber(e.target.value)}
        />
      </div>
      <div>
        <TextField
          id="outlined-basic"
          label="Department"
          variant="outlined"
          value={department}
          onChange={(e) => setDepartment(e.target.value)}
        />
      </div>
      <div>
        <FormControlLabel
          control={
            <Checkbox
              checked={isCurrentlyWorking}
              onChange={() => setIsCurrentlyWorking(!isCurrentlyWorking)}
            />
          }
          label="Currently Working"
        />
      </div>
      <div>
        <Button
          variant="contained"
          color="secondary"
          style={{ marginTop: '10px' }}
          onClick={handleAddClick}
        >
          Add Employee
        </Button>
      </div>
    </form>
  );
}

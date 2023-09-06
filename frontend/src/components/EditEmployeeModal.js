import React from 'react';
import Modal from '@mui/material/Modal';
import TextField from '@mui/material/TextField';
import Button from '@mui/material/Button';
import Checkbox from '@mui/material/Checkbox';
import FormControlLabel from '@mui/material/FormControlLabel';

const modalStyle = {
  position: 'absolute',
  top: '50%',
  left: '50%',
  transform: 'translate(-50%, -50%)',
  width: 400,
  bgcolor: 'background.paper',
  boxShadow: 24,
  p: 4,
};

function EditEmployeeModal({
  open,
  handleClose,
  editName,
  setEditName,
  editPhoneNumber,
  setEditPhoneNumber,
  editDepartment,
  setEditDepartment,
  editCurrentlyWorking,
  setEditCurrentlyWorking,
  handleUpdateClick,
}) {
  return (
    <Modal
      open={open}
      onClose={handleClose}
      aria-labelledby="edit-employee-modal"
      aria-describedby="edit-employee-form"
    >
      <div style={modalStyle}>
        <h2>Edit Employee</h2>
        <div>
          <TextField
            id="edit-name"
            label="Name"
            variant="outlined"
            value={editName}
            onChange={(e) => setEditName(e.target.value)}
          />
        </div>
        <div>
          <TextField
            id="edit-phoneNumber"
            label="Phone Number"
            variant="outlined"
            value={editPhoneNumber}
            onChange={(e) => setEditPhoneNumber(e.target.value)}
          />
        </div>
        <div>
          <TextField
            id="edit-department"
            label="Department"
            variant="outlined"
            value={editDepartment}
            onChange={(e) => setEditDepartment(e.target.value)}
          />
        </div>
        <div>
          <FormControlLabel
            control={
              <Checkbox
                checked={editCurrentlyWorking}
                onChange={() => setEditCurrentlyWorking(!editCurrentlyWorking)}
              />
            }
            label="Currently Working"
          />
        </div>
        <div>
          <Button
            variant="contained"
            color="primary"
            style={{ marginTop: '10px' }}
            onClick={handleUpdateClick}
          >
            Save
          </Button>
        </div>
      </div>
    </Modal>
  );
}
export default EditEmployeeModal;

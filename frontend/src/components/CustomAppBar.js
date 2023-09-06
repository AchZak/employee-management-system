import React from 'react';
import AppBar from '@mui/material/AppBar';
import Toolbar from '@mui/material/Toolbar';
import Typography from '@mui/material/Typography';
import { styled } from '@mui/material/styles';

const StyledAppBar = styled(AppBar)(({ theme }) => ({
  background: '#2E3B55',
  display: 'flex',
  justifyContent: 'center',
}));

const StyledTypography = styled(Typography)(({ theme }) => ({
  flexGrow: 1,
  textAlign: 'center',
  fontWeight: 'bold',
}));

function CustomAppBar() {
  return (
    <StyledAppBar position="static">
      <Toolbar>
        <StyledTypography variant="h6">
          Employee Management System
        </StyledTypography>
      </Toolbar>
    </StyledAppBar>
  );
}

export default CustomAppBar;

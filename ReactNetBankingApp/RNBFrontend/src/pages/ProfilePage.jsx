import React from 'react'
import { useRef, useEffect } from 'react';
import { useDispatch, useSelector } from 'react-redux';
import { useNavigate, useParams } from 'react-router-dom';
import { logging_out } from '../reduxContainer/AppAction';

function ProfilePage() {
  
  const customer = useSelector((state) => state.customer);
  const navigate = useNavigate()
  const dispatch = useDispatch()
  const handleLogout = () => {
    if (!window.confirm("Are you sure you want to log out?")) {
      return;
    }
    localStorage.clear();
    dispatch(logging_out())
    console.log("User logged out");
    navigate('/')
  };

  return (
    <div>
      {customer ? (
        <div>
          <h1>Hello, {customer.name}!</h1>
          <p>Your ID is: {customer.id}</p>
        </div>
      ) : (
        <p>Customer not found.</p>
      )}
      <button onClick={handleLogout}>Log Out</button>
    </div>
  )
}

export default ProfilePage

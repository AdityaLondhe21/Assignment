import React from 'react'
import { useState } from 'react';
import { useSelector } from 'react-redux';

function BalancePage() {

  const customer = useSelector((state) => state.customer);
  const [password, setPassword] = useState('');
  const [showBalance, setShowBalance] = useState(false);

  const handlePasswordSubmit = () => {
    if (password === customer.password) {
      setShowBalance(true);
    } else {
      alert('Incorrect password');
    }
  };
  return (
    <div>
      <h1>Welcome, {customer.name}</h1>
      {!showBalance ? (
        <div>
          <p>Please enter your password to view your balance:</p>
          <input
            type="password"
            value={password}
            onChange={(e) => setPassword(e.target.value)}
          />
          <button onClick={handlePasswordSubmit}>Submit</button>
        </div>
      ) : (
        <div>
          <h2>Your Balance: Rs {customer.balance}</h2>
        </div>
      )}
    </div>
  )
}

export default BalancePage

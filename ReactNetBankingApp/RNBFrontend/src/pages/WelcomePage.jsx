import React from 'react'
import { useSelector } from 'react-redux';
import { Link } from 'react-router-dom';

function WelcomePage() {
  const customer = useSelector(state=>state.customer)
  return (
    <div>
      <h1>Welcome!</h1>
      <div>
        <Link to={`/balance`}>
          <button>Balance Enquiry</button>
        </Link>
        <Link to={`/statement`}>
          <button>Mini Statement</button>
        </Link>
        <Link to={`/transfer`}>
          <button>Transfer/Pay</button>
        </Link>
      </div>
    </div>
  );
}

export default WelcomePage

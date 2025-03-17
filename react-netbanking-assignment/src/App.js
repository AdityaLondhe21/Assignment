import DepositCalculator from './DepositCalculator';
import LoanCalculator from './LoanCalculator';
import { useState } from 'react';
import './styles.css';

function App() {
  const [serviceType, setServiceType] = useState('LoanCalculator');
  
  const changeServiceType = (e) => {
    setServiceType(e.target.value);
  };

  return (
    <div className='App'>
      <h1>Net Banking Services</h1>
      <div>
        <input 
          type="radio" 
          value="LoanCalculator" 
          checked={serviceType === 'LoanCalculator'} 
          onChange={changeServiceType} 
          aria-label="Loan Calculator"
        /> Loan Calculator
        <input 
          type="radio" 
          value="DepositCalculator" 
          checked={serviceType === 'DepositCalculator'} 
          onChange={changeServiceType} 
          aria-label="Deposit Calculator"
        /> Deposit Calculator
      </div>
      <br />
      <div className='service-container'>
        {serviceType === 'LoanCalculator' ? <LoanCalculator /> : <DepositCalculator />}
      </div>
    </div>
  );
}

export default App;
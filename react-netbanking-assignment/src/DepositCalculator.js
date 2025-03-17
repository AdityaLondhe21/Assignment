import React from 'react'
import { useState } from 'react'
const DepositCalculator = () => {
    const [depositAmount, setDepositAmount] = useState(0)
    const [tenure, setTenure] = useState(0)
    const [result, setResult] = useState(0)

    const changeDepositAmount=(e)=>{
        setDepositAmount(e.target.value)
    }
    const changeTenure=(e)=>{
        setTenure(e.target.value)
    }
    const calculateDeposit=()=>{
        if(tenure<=0){
            alert("Deposit Tenure must be greater than 0")
            return;
        }
        if(depositAmount<=0){
            alert("Deposit Amount must be greater than 0")
            return;
        }
        const interestRate = 0.07;
        const maturityAmount = depositAmount * Math.pow((1 + interestRate), tenure);
        setResult(maturityAmount)
    }
    return (
    <div className='service'>
        <h1>Calculate Deposit</h1>
        <div class="service-form">
            <label for="deposit-amount">Deposit Amount:</label>
            <input type="number" id="deposit-amount" value={depositAmount} onChange={changeDepositAmount} placeholder="Enter deposit amount" />
            <label for='number'>Interest Rate</label>
            <input disabled value={7}/>
            <label for="deposit-tenure">Deposit Tenure (years):</label>
            <input type="number" id="deposit-tenure" value={tenure} onChange={changeTenure} placeholder="Enter deposit tenure" />
            <button onClick={calculateDeposit}>Calculate</button>
        </div>
        {result!==0?
        <div id="result">
            <p>Maturity Amount: Rs{result.toFixed(2)}/-</p>
        </div>:<></>
        }  
    </div>
    )
}

export default DepositCalculator

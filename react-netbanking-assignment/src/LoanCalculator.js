import React from 'react'
import { useState } from 'react'

const LoanCalculator = () => {
    const [name, setName] = useState("Guest")
    const [loanType, setLoanType] = useState({type:'Home',interestRate:9,maxTenure:30,minAmount:500000,maxAmount:10000000})
    const [result, setResult] = useState({emi:0,totalPayment:0,totalInterest:0})
    const [tenure, setTenure] = useState(0)
    const [loanAmount, setLoanAmount] = useState(0)

    const changeLoanType=(e)=>{
        if(e.target.value==='Home'){
            setLoanType({type:'Home',interestRate:9,maxTenure:30,minAmount:500000,maxAmount:10000000})
        }
        else if(e.target.value==='Car'){
            setLoanType({type:'Car',interestRate:11,maxTenure:7,minAmount:100000,maxAmount:1500000})
        }
        else if(e.target.value==='Personal'){
            setLoanType({type:'Personal',interestRate:15,maxTenure:5,minAmount:10000,maxAmount:500000})
        }
    }
    const changeTenure=(e)=>{
        setTenure(e.target.value)
    }
    const changeLoanAmount=(e)=>{
        setLoanAmount(e.target.value)
    }
    const calculateLoan=()=>{
        if(tenure>loanType.maxTenure || tenure<=0){
            alert(`Tenure must be in between 1 and ${loanType.maxTenure}`)
            return;
        }
        if(loanAmount<loanType.minAmount || loanAmount>loanType.maxAmount){
            alert(`Loan Amount must be in range ${loanType.minAmount} to ${loanType.maxAmount}`)
            return;
        }
        const interestRate = loanType.interestRate / 12 / 100;
        const emi = (loanAmount * interestRate * Math.pow(1 + interestRate, tenure * 12)) / (Math.pow(1 + interestRate, tenure * 12) - 1);
        const totalPayment = emi * tenure * 12;
        const totalInterest = totalPayment - loanAmount;

        setResult({
            emi: emi,
            totalPayment: totalPayment,
            totalInterest: totalInterest
        });
    }
    return (
    <div className='service'>
        <h1>Calculate Loan</h1>
        <form class="service-form">
            <label for="applicant-name">Applicant Name:</label>
            <input type="text" id="applicant-name" value={name} placeholder="Enter applicant name" onChange={(e)=>setName(e.target.value)} />
            <label for="loan-type">Loan Type:</label>
            <select id="loan-type" onChange={changeLoanType}>
                <option value="Home">Home Loan</option>
                <option value="Car">Car Loan</option>
                <option value="Personal">Personal Loan</option>
            </select>
            <label for="interest-rate">Interest Rate </label>
            <input type='number' disabled id='interest-rate' value={loanType.interestRate}/>
            <label for="loan-tenure">Loan Tenure (years):</label>
            <input type="number" id="loan-tenure" value={tenure} onChange={changeTenure} placeholder="Enter loan tenure (years)" />
            <label for="loan-amount">Loan Amount:</label>
            <input type="number" id="loan-amount" value={loanAmount} onChange={changeLoanAmount} placeholder="Enter loan amount" />
            <button type='button' onClick={calculateLoan}>Calculate</button>
        </form>
        { result.emi!==0? <div id="result">
            <h2>Hello! {name}</h2>
            <p>Monthly EMI: Rs{result.emi.toFixed(2)}</p>
            <p>Total Payment: Rs{result.totalPayment.toFixed(2)}</p>
            <p>Total Interest: Rs{result.totalInterest.toFixed(2)}</p>
        </div>:<></>
        }
    </div>
    )
}

export default LoanCalculator

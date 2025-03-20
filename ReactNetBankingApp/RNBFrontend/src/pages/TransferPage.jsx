import React, { useState } from 'react'
import { useDispatch, useSelector } from 'react-redux';
import { adding_transaction} from '../reduxContainer/AppAction';
import {  addTransactionInDB } from '../dbOperations/dbOperations';

function TransferPage() {

  const customer = useSelector(state=>state.customer)
  const customers = useSelector(state=>state.customers)

  const dispatch = useDispatch()

  const handleTransfer = (event) => {
    event.preventDefault();
    const transferDetails = {
      tran_id: crypto.randomUUID(),
      sender_id: customer.id,
      receiver_id: event.target.toAccount.value,
      amount: parseInt(event.target.amount.value)
    };
    console.log(transferDetails)
    if(transferDetails.amount>customer.balance){
      alert("Insufficient balance to complete the transfer.");
      return;
    }

    dispatch(adding_transaction(transferDetails))
    addTransactionInDB(transferDetails)

    console.log("Transfer initiated:", transferDetails);

    alert(`Transfer of Rs${transferDetails.amount} from ${customer.name} to ${customers.find((c)=>c.id===transferDetails.receiver_id).name} successful!`);
  };
  return (
    <div>
      <h1>Transfer Funds</h1>
      <form onSubmit={handleTransfer}>
        <div>
          <label htmlFor="toAccount">To Account:</label>
          <select id="toAccount" name="toAccount" required>
            <option value="" disabled selected>Select a customer</option>
            {customers
              .filter((cust) => cust.id !== customer.id)
              .map((cust) => (
                <option key={cust.id} value={cust.id}>
                  {cust.name}
                </option>
              ))}
          </select>
        </div>
        <div>
          <label htmlFor="amount">Amount:</label>
          <input type="number" id="amount" name="amount" step="0.01" required />
        </div>
        <button type="submit">Transfer</button>
      </form>
    </div>
  )
}

export default TransferPage

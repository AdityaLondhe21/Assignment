import React, { useEffect, useState } from 'react';
import { useSelector } from 'react-redux';
import { getTransactionsOfCustomer } from '../dbOperations/dbOperations';

function StatementPage() {
  const customer = useSelector((state) => state.customer);
  const customers = useSelector((state) => state.customers);

  const [userTransactions, setUserTransactions] = useState([]);

  useEffect(() => {
    const getCustomerNameById = (id) => {
      const customer = customers.find((c) => c.id === id);
      return customer ? customer.name : 'Unknown';
    };

    const fetchTransactions = async () => {
      try {
        const transactions = await getTransactionsOfCustomer(customer.id);

        if (Array.isArray(transactions)) {
          setUserTransactions(transactions.map((t) => ({
            id: t.tran_id,
            sender: getCustomerNameById(t.sender_id),
            receiver: getCustomerNameById(t.receiver_id),
            amount:t.amount
          })));
        } else {
          console.error('Transactions is not an array:', transactions);
        }
      } catch (error) {
        console.error('Error fetching transactions:', error);
      }
    };

    fetchTransactions();

  }, [customer.id, customers]);

  return (
    <div>
      {userTransactions.length !== 0 ? (
        <table>
          <thead>
            <tr>
              <th>ID</th>
              <th>Sender</th>
              <th>Receiver</th>
              <th>Amount</th>
            </tr>
          </thead>
          <tbody>
            {userTransactions.map((transaction) => (
              <tr key={transaction.id}>
                <td>{transaction.id}</td>
                <td>{transaction.sender}</td>
                <td>{transaction.receiver}</td>
                <td>{transaction.amount}</td>
              </tr>
            ))}
          </tbody>
        </table>
      ) : (
        <>No Transactions</>
      )}
    </div>
  );
}

export default StatementPage;
import { batch } from "react-redux";

export async function addCustomerInDB(customer) {
    const response = await fetch('http://localhost:8080/customer', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(customer)
    });
    const data = await response.text();
    return data;
}
export async function updateBalanceInDB(customer) {
    const response = await fetch('http://localhost:8080/customer/balance', {
        method: 'PATCH',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(customer)
    });
    const data = await response.text();
    return data;
}
export async function getCustomerByID(id) {
    const response = await fetch(`http://localhost:8080/customer/${id}`, {
        method: 'GET',
        headers: {
            'Content-Type': 'application/json'
        }
    });
    const data = await response.json();
    console.log(data)
    return data;
}
export async function addTransactionInDB(transaction) {
    const response = await fetch('http://localhost:8080/transactions', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(transaction)
    });
    const data = await response.text();

    const sender = await getCustomerByID(transaction.sender_id);
    const receiver = await getCustomerByID(transaction.receiver_id);
    
    await updateBalanceInDB({ ...sender, balance: sender.balance - transaction.amount });
    await updateBalanceInDB({ ...receiver, balance: receiver.balance + transaction.amount });

    return data;
}
export async function getTransactionsOfCustomer(id) {
    const response = await fetch(`http://localhost:8080/transactions/${id}`, {
        method: 'GET',
        headers: {
            'Content-Type': 'application/json'
        }
    });
    const data = await response.json();
    return data;
}
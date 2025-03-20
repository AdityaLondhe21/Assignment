import React from 'react';
import { useDispatch } from 'react-redux';
import { Link, useNavigate } from 'react-router-dom';
import { registering_customer } from '../reduxContainer/AppAction';
import { addCustomerInDB, getCustomerByID } from '../dbOperations/dbOperations';

function RegisterPage() {
    const dispatch = useDispatch();
    const navigate = useNavigate();

    const handleSubmit = async (event) => {
        event.preventDefault();
        const formData = event.target;
        if (formData.password.value !== formData.confirmPassword.value) {
            alert("Passwords do not match!");
            return;
        }
        const customer = await getCustomerByID(formData.id.value);
        console.log(customer);
        if (customer) {
            alert("User with this ID already exists");
            return;
        }
        const userData = {
            id: formData.id.value,
            name: formData.name.value,
            balance: formData.balance.value,
            password: formData.password.value,
        };
        console.log("User Data:", userData);
        dispatch(registering_customer(userData));
        await addCustomerInDB(userData);
        navigate('/welcome');
    };

    return (
        <div>
            <form onSubmit={handleSubmit}>
                <div>
                    <label htmlFor="id">User ID:</label>
                    <input type="text" id="id" name="id" required />
                </div>
                <div>
                    <label htmlFor="name">Name:</label>
                    <input type="text" id="name" name="name" required />
                </div>
                <div>
                    <label htmlFor="balance">Balance:</label>
                    <input type="number" id="balance" name="balance" required />
                </div>
                <div>
                    <label htmlFor="password">Password:</label>
                    <input type="password" id="password" name="password" required />
                </div>
                <div>
                    <label htmlFor="confirmPassword">Confirm Password:</label>
                   <input type="password" id="confirmPassword" name='confirmPassword' required />
                </div>
                <button type="submit">Register</button>
            </form>
            <p>Already have an account? <Link to={"/login"}>Login here</Link></p>
        </div>
    );
}

export default RegisterPage;
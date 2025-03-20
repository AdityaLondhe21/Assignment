import React from 'react'
import { useDispatch, useSelector } from 'react-redux'
import { authorise_customer } from '../reduxContainer/AppAction';
import {Link, useNavigate} from 'react-router-dom'

function LoginPage() {
    const customers = useSelector(state=>state.customers)
    const navigate  = useNavigate()
    const dispatch = useDispatch()

    function loginCustomer(e){
        e.preventDefault();
        const id = e.target.elements.id.value;
        const password = e.target.elements.password.value
        console.log(id+" "+password)
        const customer = customers.find((c)=>c.id===id && c.password===password)
        console.log(customer)
        if(!customer) {
            alert("Incorrect ID or Passeord")
            return
        }
        dispatch(authorise_customer(customer))
        localStorage.setItem('customer', JSON.stringify(customer)); 
        navigate('/welcome')
    }
return (
    <div>
        <form onSubmit={loginCustomer}>
            <div>
                <label for="id">Customer ID:</label>
                <input type="text" id="id" name="id" required />
            </div>
            <div>
                <label for="password">Password:</label>
                <input type="password" id="password" name="password" required />
            </div>
            <button type="submit">Login</button>
        </form>
        <p>Don't have an account? <Link to={"/register"}>Register here</Link></p>
    </div>
)
}

export default LoginPage

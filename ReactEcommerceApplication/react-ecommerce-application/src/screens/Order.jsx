import axios from 'axios';
import React, { useEffect,useState } from 'react'
import Header from '../components/Header';
import Footer from '../components/Footer';
import { useSelector } from 'react-redux';

function Order() {
    const cart = useSelector(state=>state.cart)

    return (
    <div className='container'>
        <Header/>
        <h1>Cart Items</h1>
        {cart.length!==0?
        <ul>
        {cart.map(item => (
            <li key={item.id}>
            {item.name} - Quantity: {item.quantity}
            </li>
        ))}
        </ul>:<>Cart is Empty</>
        }   
        <Footer/>
    </div>
    );
}

export default Order

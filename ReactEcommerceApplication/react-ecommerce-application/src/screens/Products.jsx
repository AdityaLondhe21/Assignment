import React, { useContext, useEffect,useState } from 'react'

import Product from './Product';
import Header from '../components/Header';
import Footer from '../components/Footer'
import { useSelector } from 'react-redux';

function Products() {
    // const obj = useContext(appContext)
    const products = useSelector(state=>state.products)
    // const vendors = useSelector(state=>state.vendors)
    return (
    <div className='container'>
        <Header/>
        <h1>Products</h1>
        <ul>
        {products? products.map(product => (
            <li key={product.id}>
                <Product product={product} vendorId={product.vendorId}/>
            </li>
        )):<></>}
        </ul>
        <Footer/>
    </div>
    );
}

export default Products

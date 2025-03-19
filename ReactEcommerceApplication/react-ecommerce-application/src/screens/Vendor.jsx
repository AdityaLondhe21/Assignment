import React, { useContext, useEffect, useState } from 'react'
import { Link, useParams } from 'react-router-dom'
import Product from './Product';
import Header from '../components/Header';
import Footer from '../components/Footer';
import axios from 'axios';
import { useDispatch, useSelector } from 'react-redux';
import { addProductInDB } from '../dbOperations/dbOperations';
import { adding_product } from '../reduxContainer/AppAction';

function Vendor() {
    const [addProductFlag, setAddProductFlag] = useState(false)
    
    const { id } = useParams();
    const [vendor, setVendor] = useState({})
    const [products, setProducts] = useState([])

    const vendors = useSelector(state=>state.vendors)
    const vendorProducts = useSelector(state=>state.products)
    const dispatch = useDispatch()

    useEffect(()=>{
      setVendor(vendors.find(v=>v.id===id))
      setProducts(vendorProducts.filter(p=>p.vendorId===id))
    },[])

    function addProduct(e){
      e.preventDefault();
      const newProduct = {
        id: crypto.randomUUID(),
        name: e.target.name.value,
        price: parseFloat(e.target.price.value),
        quantity: parseInt(e.target.quantity.value, 10),
        vendorId: id,
      };
      setProducts([...products, newProduct]);
      dispatch(adding_product(newProduct))
      addProductInDB(newProduct)
      setAddProductFlag(false);
    }
    
  
  return (
    <div className='container'>
        <Header/>
        <h1>{vendor.name}</h1>
        <p>ID: {vendor.id}</p>
        <p>Address: {vendor.address}</p>
        <hr />
        {addProductFlag ? (
          <form onSubmit={addProduct}>
            <div>
              <label>Product Name:</label>
              <input type="text" name="name" required />
            </div>
            <div>
              <label>Price:</label>
              <input type="number" name="price" required />
            </div>
            <div>
              <label>Quantity:</label>
              <input type="number" name="quantity" required />
            </div>
            <button type="submit">Add Product</button>
            <button type="button" onClick={() => setAddProductFlag(false)}>
              Cancel
            </button>
          </form>
        ) : (
          <button onClick={() => setAddProductFlag(true)}>Add Product</button>
        )}
        <h2>Products : </h2>
        {products.length!==0?
        <ul>
          {products.map(product => (
            <li key={product.id}><Product product={product} vendorId={id}/></li>
          ))}
        </ul>:<>No products available</>
        }
        <Footer/>
    </div>
  )
}

export default Vendor

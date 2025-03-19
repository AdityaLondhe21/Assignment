import axios from 'axios'
import React, { useState,useEffect, useContext } from 'react'
import { useSelector } from 'react-redux'
import { Link, useParams } from 'react-router-dom'

function Product(props) {
    const product = props.product
    const vendorId = props.vendorId
    const [vendor, setVendor] = useState({})
    const vendors = useSelector(state=>state.vendors)

    useEffect(() => {
      setVendor(vendors.find(v=>v.id===vendorId))
    }, [])
    
  return (
    <div className="container">
      <div className='product-details'>
        <h2>{product.name}</h2>
        <p>Rs {product.price}/-</p>
        <p>Number of units : {product.quantity}</p>
      </div>
      {vendor? <>Vendor :<Link to={`/vendors/${vendor.id}`}>{vendor.name}</Link></>:<></>}
    </div>
  )
}

export default Product

import React, { useEffect, useState } from 'react'
import Header from '../components/Header'
import Footer from '../components/Footer'
import { useDispatch, useSelector } from 'react-redux'
import { Link } from 'react-router-dom'
import { deleting_product, updating_product } from '../reduxContainer/AppAction'
import { deleteProductFromDB, updateProductInDB } from '../dbOperations/dbOperations'

function Inventory() {

  const vendors = useSelector(state=>state.vendors)
  const products = useSelector(state=>state.products)

  const [editFlag, setEditFlag] = useState(false)
  const [addFlag, setAddFlag] = useState(false)

  const [updatedProduct,setUpdatedProduct] = useState({})
  const dispatch = useDispatch()

  function handleEditProduct(product){
    setUpdatedProduct(product)
    setEditFlag(product.id);
  }

  function saveChanges(e, attribute) {
    setUpdatedProduct({
      ...updatedProduct,
      [attribute]: e.target.value
    });
  }

  function updateProduct() {
    dispatch(updating_product(updatedProduct))
    updateProductInDB(updatedProduct)
    setEditFlag(false);
  }

  function handleDeleteProduct(productId) {
    const confirmDelete = window.confirm("Are you sure you want to delete this product?");
    if (confirmDelete) {
      const updatedProducts = products.filter(product => product.id !== productId);
      dispatch(deleting_product(productId));      
      deleteProductFromDB(productId);
    }
  }

  function addProduct(e){
    e.preventDefault();
    const newProduct = {
      id: Date.now(),
      name: e.target.name.value,
      price: parseFloat(e.target.price.value),
      quantity: parseInt(e.target.quantity.value, 10),
      vendorId: parseInt(e.target.vendorId.value, 10)
    };
    dispatch(updating_product(newProduct));
    updateProductInDB(newProduct);
    e.target.reset();
  }
  return (
    <div className='container'>
      <Header/>
      <div className='inventory'>
        <h2>Products and Vendors</h2>
        {/* <button onClick={setAddFlag(true)}>Add Product</button>
        <div className='add-product-form'>
          <h3>Add New Product</h3>
          <form onSubmit={addProduct}>
            <div>
              <label htmlFor='name'>Product Name:</label>
              <input type='text' id='name' name='name' required />
            </div>
            <div>
              <label htmlFor='price'>Price:</label>
              <input type='number' id='price' name='price' step='0.01' required />
            </div>
            <div>
              <label htmlFor='quantity'>Quantity:</label>
              <input type='number' id='quantity' name='quantity' required />
            </div>
            <div>
              <label htmlFor='vendorId'>Vendor:</label>
              <select id='vendorId' name='vendorId' required>
                <option value=''>Select Vendor</option>
                {vendors.map((vendor) => (
                  <option key={vendor.id} value={vendor.id}>{vendor.name}</option>
                ))}
              </select>
            </div>
            <button type='submit'>Add Product</button>
            <button onClick={setAddFlag(false)}>Cancle</button>
          </form>
        </div> */}
        <table className='inventory-table'>
          <thead>
            <tr>
              <th>Product Name</th>
              <th>Price</th>
              <th>Vendor Name</th>
              <th>Quantity</th>
            </tr>
          </thead>
          <tbody>
            {products.map((product) => {
              const vendor = vendors.find((v) => v.id === product.vendorId);
                return (
                <tr key={product.id}>
                  <td>{editFlag === product.id ? <input type='text' value={updatedProduct.name} id='name' name='name' onChange={(e) => saveChanges(e, 'name')} ></input> : product.name}</td>
                  <td>{editFlag === product.id ? <input type='number' value={updatedProduct.price} id='price' name='price' onChange={(e) => saveChanges(e, 'price')}></input> : product.price}</td>
                  <td>{vendor ? <Link to={`/vendors/${vendor.id}`}>{vendor.name}</Link> : 'Unknown Vendor'}</td>
                  <td>{editFlag === product.id ? <input type='number' value={updatedProduct.quantity} id='quantity' name='quantity' onChange={(e) => saveChanges(e, 'quantity')}></input> : product.quantity}</td>
                  <td>
                  {editFlag !== product.id ?
                  <button onClick={() => handleEditProduct(product)}>Edit</button>
                  : <>
                  <button onClick={() => updateProduct()}>Save</button>
                  <button onClick={()=> setEditFlag(false)}>Cancel</button>
                  </>
                  }
                  <button onClick={() => handleDeleteProduct(product.id)}>Delete</button>
                  </td>
                </tr>
                );
            })}
          </tbody>
        </table>
      </div>
      <Footer/>
    </div>
  )
}

export default Inventory

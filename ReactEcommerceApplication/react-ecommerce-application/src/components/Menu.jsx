import React from 'react'
import { Link } from 'react-router-dom'

const Menu = () => {
  return (
    <div className='links'>
      <Link to={'/products'}>Products</Link>
      <Link to={'/vendors'}>Vendors</Link>
      <Link to={'/cart'}>Cart</Link>
      <Link to={'/inventory'}>Inventory</Link>
    </div>
  )
}

export default Menu

import React from 'react'
import Menu from './Menu'
import { useSelector } from 'react-redux'
import { Link } from 'react-router-dom'

const Header = () => {

  const customer = useSelector(state=>state.customer)

  return (
    <>
    <div className='header'>
      <h1>Our Bank</h1>
      <Menu/>
      {customer? <Link to={`/profile`}><h4>{customer.name}</h4></Link>:<h4>Guest</h4>}
    </div>
    <hr />
    </>
  )
}

export default Header

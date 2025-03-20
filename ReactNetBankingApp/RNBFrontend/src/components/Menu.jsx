import React from 'react'
import { Link } from 'react-router-dom'

const Menu = () => {
  return (
    <div className='links'>
      <Link to={'/'}>Home</Link>
      <Link to={'/about'}>About Us</Link>
      <Link to={'/services'}>Services</Link>
      <Link to={'/netbanking'}>NetBanking</Link>
      <Link to={'/contact'}>Contact Us</Link>
    </div>
  )
}

export default Menu

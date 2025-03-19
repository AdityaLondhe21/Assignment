import { useEffect, useState } from 'react'
import { Routes,Route } from 'react-router-dom'
import Products from './screens/Products'
import Vendors from './screens/Vendors'
import Order from './screens/Order'
import Vendor from './screens/Vendor'
import Home from './screens/Home'
import { Provider } from 'react-redux';
import store from './reduxContainer/store'
import Inventory from './screens/Inventory'

function App() {
  return (
    <>
      <Provider store={store}>
      <Routes>
        <Route path='/' element={<Home/>}/>
        <Route path="/products" element={<Products/>} />
        <Route path="/vendors" element={<Vendors/>} />
        <Route path="/vendors/:id" element={<Vendor/>}/>
        <Route path="/inventory" element={<Inventory/>}/>
        <Route path="/cart" element={<Order/>} />
      </Routes>
      </Provider>
    </>
  )
}

export default App

import React, { useContext } from 'react'
import { Link } from 'react-router-dom';
import Header from '../components/Header';
import Footer from '../components/Footer';
import { useEffect,useState } from 'react';
import { useDispatch, useSelector } from 'react-redux';
import { add_vendor } from '../reduxContainer/ActionTypes';
import { addVendorInDB } from '../dbOperations/dbOperations';
import { adding_vendor } from '../reduxContainer/AppAction';

function Vendors() {
    const [addVendorFlag, setAddVendorFlag] = useState(false)

    const vendors = useSelector(state=>state.vendors)
    const dispatch = useDispatch()

    function addVendor(e){
        e.preventDefault();
        const name = e.target.name.value;
        const address = e.target.address.value;
        const id = crypto.randomUUID();
        dispatch(adding_vendor({id,name,address}))
        addVendorInDB({id,name,address})
        setAddVendorFlag(false);
    }

    return (
    <div className='container'>
        <Header/>
        <h1>Vendors</h1>
        <hr />
        {addVendorFlag ? (
            <form onSubmit={addVendor}>
                <div>
                    <label>Name:</label>
                    <input type="text" name="name" required />
                </div>
                <div>
                    <label>Address:</label>
                    <input type="text" name="address" required />
                </div>
                <button type="submit">Add Vendor</button>
                <button type="button" onClick={() => setAddVendorFlag(false)}>Cancel</button>
            </form>
        ) : (
            <button onClick={() => setAddVendorFlag(true)}>Add Vendor</button>
        )}
        <ul>
        {vendors? vendors.map(vendor => (
            <li key={vendor.vendorId}>
            {vendor.name} - <Link to={`/vendors/${vendor.id}`}>Details</Link>
            </li>
        )):<></>}
        </ul>
        <Footer/>
    </div>
    );
}

export default Vendors

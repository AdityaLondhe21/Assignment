import React, { useEffect } from 'react'
import { useSelector } from 'react-redux'
import { useNavigate } from 'react-router-dom'

function NetBankingPage() {
    const customer = useSelector(state=>state.customer)

    const navigate = useNavigate()

    useEffect(()=>{
        if(!customer){
            navigate('/login')
        }else{
          navigate('/welcome')
        }
    },[])

  return (
    <div>
      
    </div>
  )
}

export default NetBankingPage

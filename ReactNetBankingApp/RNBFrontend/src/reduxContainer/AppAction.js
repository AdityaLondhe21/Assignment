import { add_transaction, login_customer, logout_customer, register_customer, show_transactions, update_balance } from "./ActionTypes"

export const registering_customer=(customer)=>{
    return {
        type:register_customer,
        payload: customer
    }
}
export const authorise_customer=(customer)=>{
    return {
        type:login_customer,
        payload: customer
    }
}
export const logging_out=()=>{
    return {
        type:logout_customer,
        payload:"Logged out successfully"
    }
}
export const updating_balance=(customer)=>{
    return {
        type:update_balance,
        payload:customer
    }
}
export const adding_transaction=(transaction)=>{
    return {
        type:add_transaction,
        payload:transaction
    }
}
export const display_transactions=(id)=>{
    return{
        type:show_transactions,
        payload:id
    }
}


import { add_transaction, login_customer, logout_customer, register_customer, update_balance } from "./ActionTypes";

const fetchInitialState = async () => {
    try {
        const [customersResponse, transactionsResponse] = await Promise.all([
            fetch("http://localhost:8080/customer"),
            fetch("http://localhost:8080/transactions"),
        ]);

        const [customers, transactions] = await Promise.all([
            customersResponse.json(),
            transactionsResponse.json()
        ]);
        const storedCustomer = JSON.parse(localStorage.getItem("customer"));
        return {
            customers,
            transactions,
            customer: storedCustomer || undefined
        };
    } catch (error) {
        console.error("Error fetching initial state:", error);
        return {
            customers: [],
            transactions: [],
            customer: undefined
        };
    }
};

const initialState = await fetchInitialState();


const AppReducer=(state = initialState,action)=>{
    console.log("Action : "+action.type)

    switch(action.type)
    {
        case register_customer: 
            return {
            ...state,
            customers:[...state.customers,action.payload],
            customer:action.payload
            };
        case add_transaction: 
            return {
            ...state,
            customers: state.customers.map(customer => {
                if (customer.id === action.payload.sender_id) {
                    return { ...customer, balance: customer.balance - action.payload.amount };
                } else if (customer.id === action.payload.receiver_id) {
                    return { ...customer, balance: customer.balance + action.payload.amount };
                }
                return customer;
            }),
            transactions: [...state.transactions, action.payload],
            customer: { ...state.customer, balance: state.customer.balance - action.payload.amount }
            };
        case login_customer:
            return{
            ...state,
            customer:action.payload
            };
        case logout_customer:
            return{
                ...state,
                customer:undefined
            }
        case update_balance: 
            return {
            ...state,
            customers: state.customers.map(customer => 
                customer.id === action.payload.id ? { ...customer, ...action.payload } : customer
            ),
            customer:action.payload
            };
        default: return state
    }
}

export default AppReducer;
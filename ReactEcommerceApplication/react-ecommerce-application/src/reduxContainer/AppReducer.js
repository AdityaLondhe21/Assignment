import {add_to_cart,add_product,add_vendor,update_cart,update_product,update_vendor,delete_product,delete_vendor,remove_from_cart} from "./ActionTypes";

const fetchInitialState = async () => {
    try {
        const [productsResponse, vendorsResponse, cartResponse] = await Promise.all([
            fetch("http://localhost:3000/products"),
            fetch("http://localhost:3000/vendors"),
            fetch("http://localhost:3000/cart")
        ]);

        const [products, vendors, cart] = await Promise.all([
            productsResponse.json(),
            vendorsResponse.json(),
            cartResponse.json()
        ]);

        return {
            products,
            vendors,
            cart
        };
    } catch (error) {
        console.error("Error fetching initial state:", error);
        return {
            products: [],
            vendors: [],
            cart: []
        };
    }
};

const initialState = await fetchInitialState();


const AppReducer=(state = initialState,action)=>{
    console.log("Action : "+action.type)

    switch(action.type)
    {
        case add_product: 
            return {
            ...state,
            products:[...state.products,action.payload]
            };
        case add_to_cart: 
            return {
            ...state,
            cart: [...state.cart, action.payload]
            };
        case add_vendor: 
            return {
            ...state,
            vendors: [...state.vendors, action.payload]
            };
        case delete_product: 
            return {
            ...state,
            products: state.products.filter(product => product.id !== action.payload)
            };
        case delete_vendor: 
            return {
            ...state,
            vendors: state.vendors.filter(vendor => vendor.id !== action.payload)
            };
        case remove_from_cart: 
            return {
            ...state,
            cart: state.cart.filter(item => item.id !== action.payload)
            };
        case update_cart: 
            return {
            ...state,
            cart: state.cart.map(item => 
                item.id === action.payload.id ? { ...item, ...action.payload } : item
            )
            };
        case update_product: 
            return {
            ...state,
            products: state.products.map(product => 
                product.id === action.payload.id ? { ...product, ...action.payload } : product
            )
            };
        case update_vendor: 
            return {
            ...state,
            vendors: state.vendors.map(vendor => 
                vendor.id === action.payload.id ? { ...vendor, ...action.payload } : vendor
            )
            };
        
        default: return state
    }
}

export default AppReducer;
import { add_product, add_to_cart, add_vendor, delete_product, delete_vendor, remove_from_cart, update_cart, update_product, update_vendor } from "./ActionTypes"


export const adding_product=(product)=>{
    return {
        type:add_product,
        payload: product
    }
}

export const deleting_product=(productID)=>{
    return {
        type:delete_product,
        payload: productID
    }
}
export const updating_product=(product)=>{
    return {
        type:update_product,
        payload: product
    }
}
export const adding_vendor=(vendor)=>{
    return {
        type:add_vendor,
        payload: vendor
    }
}
export const deleting_vendor=(vendorID)=>{
    return {
        type:delete_vendor,
        payload: vendorID
    }
}
export const updating_vendor=(vendor)=>{
    return {
        type:update_vendor,
        payload: vendor
    }
}
export const adding_to_cart=(data)=>{
    return {
        type:add_to_cart,
        payload: data
    }
}
export const removing_from_cart=(data)=>{
    return {
        type:remove_from_cart,
        payload: data
    }
}
export const updating_cart=(data)=>{
    return {
        type:update_cart,
        payload: data
    }
}

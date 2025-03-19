export function addVendorInDB(vendor){
    return fetch('http://localhost:3000/vendors', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json',
        },
        body: JSON.stringify(vendor),
        })
        .then(response => {
            if (!response.ok) {
                throw new Error('Failed to add vendor');
            }
            return response.json();
        })
        .catch(error => {
            console.error('Error adding vendor:', error);
            throw error;
        });
}
export function addProductInDB(product) {
    return fetch('http://localhost:3000/products', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json',
        },
        body: JSON.stringify(product),
        })
        .then(response => {
            if (!response.ok) {
                throw new Error('Failed to add product');
            }
            return response.json();
        })
        .catch(error => {
            console.error('Error adding product:', error);
            throw error;
        });
}
export function updateProductInDB(product){
    return fetch(`http://localhost:3000/products/${product.id}`, {
        method: 'PATCH',
        headers: {
            'Content-Type': 'application/json',
        },
        body: JSON.stringify(product),
    })
        .then(response => {
            if (!response.ok) {
                throw new Error('Failed to update product');
            }
            return response.json();
        })
        .catch(error => {
            console.error('Error updating product:', error);
            throw error;
        });
}

export function deleteProductFromDB(productId){
    return fetch(`http://localhost:3000/products/${productId}`, {
        method: 'DELETE',
        headers: {
            'Content-Type': 'application/json',
        },
    })
        .then(response => {
            if (!response.ok) {
                throw new Error('Failed to delete product');
            }
            return response.json();
        })
        .catch(error => {
            console.error('Error deleting product:', error);
            throw error;
        });
}
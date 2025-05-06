export type ProductDto = {
    id: number
    name: string
    category: string
    image: string
    price: number
}

export const products:ProductDto[] = [
    {id: 1, name : "White T Shirt", category : "T Shirt", price: 25000, image : "product1.jpg"},
    {id: 2, name : "Printed Shirt", category : "T Shirt", price: 35000, image : "product2.jpg"},
    {id: 3, name : "Black Shirt", category : "T Shirt", price: 25000, image : "product3.jpg"},
    {id: 4, name : "Red Shirt", category : "T Shirt", price: 25000, image : "product4.jpg"}
]
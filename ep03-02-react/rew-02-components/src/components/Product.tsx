import type { ProductDto } from "../dataset/products";

export function Product({dto} : {dto:ProductDto}) {
    return (
        <div className="card">
            {/* Image */}
            <img className="product-image card-img-top" src={`/products/${dto.image}`} alt="Product Image" />

            <div className="card-body">
                {/* Product Name */}
                <h5 className="card-title">{dto.name}</h5>

                <div className="d-flex justify-content-between">
                    {/* Category */}
                    <span>{dto.category}</span>
                    {/* Price */}
                    <span>{dto.price.toLocaleString()} MMK</span>
                </div>

            </div>
        </div>
    )
}
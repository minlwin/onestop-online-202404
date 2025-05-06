import { List } from "lucide-react";
import PageTitle from "../components/PageTitle";
import { Product } from "../components/Product";
import { products } from "../dataset/products"

export default function ProductList() {

    const list = products;

    return (
        <section>
            <PageTitle title="Product List" icon={<List />} />

            <div className="mt-4 row row-cols-4">
                {list.map(product => (
                    <div key={product.id} className="col">
                        <Product dto={product} />
                    </div>
                ))}
            </div>
        </section>
    )
}
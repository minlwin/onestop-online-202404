import { Button } from "@/components/ui/button"
import { Card, CardContent, CardTitle } from "@/components/ui/card"
import { Send } from "lucide-react"
import Link from "next/link"
import SearchForm from "./_component/search-form"

type Product = {id: number, name : string}
type SearchParam = {[key:string] : string | string [] | undefined}

export default async function Page1({searchParams} : {searchParams : Promise<SearchParam>}) {

    const {keyword} = await searchParams

    const list:Product[] = Array.from({length : 12})
        .map((_, index) => ({id: index + 1, name: `Product ${index + 1}`}))
        .filter(item => {
            if(keyword) {
                return item.id.toString() == keyword
            }
            return true
        })

    return (
        <>
            <h1>Page 1 : List View</h1>

            <section>
                <SearchForm keyword={keyword} />
            </section>

            <section className="grid grid-cols-3 gap-4 mt-4">
                {list.map(item => 
                    <ProductItem key={item.id} product={item} />
                )}
            </section>
        </>
    )
}

function ProductItem({product} : {product: Product}) {

    return (
        <Card>
            <CardContent className="flex items-center justify-between">
                <CardTitle>{product.name}</CardTitle>
                <Button asChild>
                    <Link href={`/page1/${product.id}`}>
                        <Send /> Show Details
                    </Link>
                </Button>
            </CardContent>
        </Card>
    )
}
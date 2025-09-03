import type { Route } from "./+types/details"

export const handle  = {
    title : "Details"
}

export async function loader({params} : Route.LoaderArgs) {
    console.log(params)

    return {
        orderId : params.id,
        orderAt : 'Septermber 2, 2025',
        title : "Some Title",
        items : [],
        totalAmount : 350000
    }
}

export default function Details({loaderData} : Route.ComponentProps) {
    return (
        <pre>{JSON.stringify(loaderData, null, 2)}</pre>
    )
}
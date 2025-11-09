import { Division } from "@/lib/type"

export default async function ServerSideFetching() {

    const response = await fetch("http://localhost:8080/divisions")
    const result:Division [] = await response.json()

    return (
        <>
            <h1>Server Side Fetching</h1>

            <pre>{JSON.stringify(result, null, 2)}</pre>
        </>
    )
}
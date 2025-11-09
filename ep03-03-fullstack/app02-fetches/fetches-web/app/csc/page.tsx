'use client'

import { Division } from "@/lib/type"
import { useEffect, useState } from "react"

export default function ClientSideFeatching() {

    const [list, setList] = useState<Division[]>([])

    useEffect(() => {
        async function load() {
            const response = await fetch("http://localhost:8080/divisions")
            const result:Division [] = await response.json()
            setList(result)
        }

        load()
    }, [setList])

    return (
        <>
            <h1>Client Side Fetchs</h1>

            <pre>{JSON.stringify(list, null, 2)}</pre>
        </>
    )
}
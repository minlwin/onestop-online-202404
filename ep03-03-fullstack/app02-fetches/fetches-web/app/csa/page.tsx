'use client'

import { Division } from "@/lib/type"
import { useEffect, useState } from "react"

import * as divisionClient from '@/lib/actions/division-client'

export default function ClientSiteServerAction() {

    const [list, setList] = useState<Division[]>([])

    useEffect(() => {
        async function load() {
            const result = await divisionClient.getAll()
            setList(result)
        }

        load()
    }, [setList])

    return (
        <>
            <h1>Client Side Server Action</h1>

            <pre>{JSON.stringify(list, null, 2)}</pre>
        </>


    )
}
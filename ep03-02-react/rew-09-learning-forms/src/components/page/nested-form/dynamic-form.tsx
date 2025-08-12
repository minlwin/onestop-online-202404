import { useFormResult } from "@/lib/context/form-result-context"
import { useEffect } from "react"

export default function DynamicForm() {

    const {setResult} = useFormResult()
    useEffect(() => setResult(), [setResult])

    return (
        <></>
    )
}
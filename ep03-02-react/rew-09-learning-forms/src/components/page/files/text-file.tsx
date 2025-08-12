import { Button } from "@/components/ui/button"
import { Card, CardContent, CardHeader, CardTitle } from "@/components/ui/card"
import { Table, TableBody, TableCell, TableHead, TableHeader, TableRow } from "@/components/ui/table"
import { useFormResult } from "@/lib/context/form-result-context"
import { zodResolver } from "@hookform/resolvers/zod"
import { FolderOpen, Save, Trash2 } from "lucide-react"
import { useEffect, useRef, useState, type ChangeEvent } from "react"
import { useForm } from "react-hook-form"
import z from "zod"

const FormSchema = z.object({
    file : z.file()
})

type FormType = z.infer<typeof FormSchema>

export default function TextFile() {

    const fileInputRef = useRef<HTMLInputElement | null>(null)
    const {setResult} = useFormResult()
    useEffect(() => setResult(), [setResult])

    const {handleSubmit, reset, setValue, watch,formState : {
        isValid
    }} = useForm<FormType>({
        resolver: zodResolver(FormSchema),
        defaultValues : {
            file: undefined
        }
    })

    const file = watch('file')

    const saveAction = (form: FormType) => setResult(JSON.stringify({file : form.file.name}, null, 2))
    const clearAction = () => {
        reset()
        setResult()
    }

    const onFileSelect = (e : ChangeEvent<HTMLInputElement>) => {
        const file = e.target.files?.[0]

        if(file) {
            setValue("file", file, {shouldValidate : true})
        }
    }

    return (
        <form onSubmit={handleSubmit(saveAction)}>
            <input onChange={onFileSelect} ref={fileInputRef} type="file" className="hidden" />

            <section className="mb-3">
                <FileViewr file={file} />
            </section>

            <div>
                <Button onClick={() => fileInputRef.current?.click()} type="button">
                    <FolderOpen /> Select File
                </Button>

                <Button disabled={!isValid} onClick={clearAction} type="button" className="ms-2">
                    <Trash2 /> Clear
                </Button>

                <Button disabled={!isValid} type="submit" className="ms-2">
                    <Save /> Save Form
                </Button>
            </div>
        </form>
    )
}

function FileViewr({file} : {file? : File}) {

    const [data, setData] = useState<string[][]>()

    useEffect(() => {

        if(file) {
            const reader = new FileReader

            reader.onload = () => {
                const result = reader.result

                if(result && typeof result === 'string') {
                    const array = result.split("\n").map(line => line.split("\t"))
                    setData(array)
                }
            }

            reader.readAsText(file)
        } else {
            setData(undefined)
        }

    }, [file, setData])

    return (
        <Card>
            <CardHeader>
                <CardTitle>Text File Content</CardTitle>
            </CardHeader>
            <CardContent>
                {data ? 
                    <TableView data={data} /> : 
                    <span>Please select file ...</span>
                }
            </CardContent>
        </Card>
    )
}

function TableView({data} : {data : string[][]}) {
    const header = data[0]
    const body = data.slice(1)

    return (
        <Table>
            <TableHeader>
                <TableRow>
                    {header.map((a, i) => 
                        <TableHead key={i}>{a}</TableHead>
                    )}
                </TableRow>
            </TableHeader>
            <TableBody>
                {body.map((row, index) => 
                    <TableRow key={`row-${index}`}>
                        {row.map((cell, cellIndex) => 
                            <TableCell key={`cell-${index}-${cellIndex}`}>{cell}</TableCell>
                        )}
                    </TableRow>
                )}
            </TableBody>
        </Table>
    )
}
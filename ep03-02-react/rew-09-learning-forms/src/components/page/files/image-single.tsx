import { Button } from "@/components/ui/button"
import { Card, CardContent, CardHeader, CardTitle } from "@/components/ui/card"
import { useFormResult } from "@/lib/context/form-result-context"
import { zodResolver } from "@hookform/resolvers/zod"
import { FolderOpen, Trash2, Save } from "lucide-react"
import { useEffect, useRef, type ChangeEvent } from "react"
import { useForm } from "react-hook-form"
import z from "zod"

const FormSchema = z.object({
    file : z.file()
})

type FormType = z.infer<typeof FormSchema>

export default function ImageSingle() {

    const {setResult} = useFormResult()
    useEffect(() => setResult(), [setResult])

    const fileInputRef = useRef<HTMLInputElement | null>(null)

    const {reset, handleSubmit, setValue, watch,formState : {
        isValid
    }} = useForm<FormType>({
        resolver : zodResolver(FormSchema),
        defaultValues: {file : undefined}
    })

    const imageFile = watch('file')

    const clearAction = () => {
        reset()
        setResult()
    }

    const saveAction = (form: FormType) => setResult(JSON.stringify({file : form.file.name}, null, 2))

    const changeFile = (e : ChangeEvent<HTMLInputElement>) => {
        const file = e.target.files?.[0]
        if(file) {
            setValue('file', file, {shouldValidate : true})
        }
    }


    return (
        <form onSubmit={handleSubmit(saveAction)}>
            
            <section className="mb-4">
                <ImageViewer file={imageFile} />
            </section>

            <input onChange={changeFile} ref={fileInputRef} type="file" className="hidden" />

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

function ImageViewer({file} : {file?: File}) {
    return (
        <Card>
            <CardHeader>
                <CardTitle>Imate Viewer</CardTitle>
            </CardHeader>
            <CardContent>
                {file ? 
                    <img src={URL.createObjectURL(file)} /> : 
                    <span>Select File ...</span>
                }
            </CardContent>
        </Card>
    )
}
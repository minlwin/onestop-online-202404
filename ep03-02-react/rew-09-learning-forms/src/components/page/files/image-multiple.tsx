import { Button } from "@/components/ui/button"
import { Card, CardContent, CardHeader, CardTitle } from "@/components/ui/card"
import { useFormResult } from "@/lib/context/form-result-context"
import { zodResolver } from "@hookform/resolvers/zod"
import { FolderOpen, Save, Trash2 } from "lucide-react"
import { useEffect, useRef, type ChangeEvent } from "react"
import { useForm } from "react-hook-form"
import z from "zod"

const FormSchema = z.object({
    file : z.array(z.file()).nonempty()
})

type FormType = z.infer<typeof FormSchema>


export default function ImageMultiple() {

    const {setResult} = useFormResult()
    useEffect(() => setResult(), [setResult])

    const fileInputRef = useRef<HTMLInputElement | null>(null)

    const {reset, handleSubmit, setValue, watch,formState : {
        isValid
    }} = useForm<FormType>({
        resolver : zodResolver(FormSchema),
        defaultValues: {file : undefined}
    })

    const files = watch('file')

    const clearAction = () => {
        reset()
        setResult()
    }

    const saveAction = (form: FormType) => setResult(JSON.stringify({file : form.file.map(a => a.name)}, null, 2))

    const changeFile = (e : ChangeEvent<HTMLInputElement>) => {
        const fileList = e.target.files

        if(fileList) {
            const files = Array.from(fileList)
            setValue('file', files, {shouldValidate : true})
        }
    }
    return (
        <form onSubmit={handleSubmit(saveAction)}>

            <section className="mb-4">
                <ImageViewer files={files} />
            </section>

            <input onChange={changeFile} ref={fileInputRef} type="file" multiple className="hidden" />

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

function ImageViewer({files} : {files? : File[]}) {
    return (
        <Card>
            <CardHeader>
                <CardTitle>Images</CardTitle>
            </CardHeader>
            <CardContent>
                {files && files.length ? 
                    <div className="grid grid-cols-2 gap-4">
                        {files.map((file, index) => 
                            <img src={URL.createObjectURL(file)} key={index} />
                        )}
                    </div> : 
                    <span>Select Image Files</span>
                }
            </CardContent>
        </Card>
    )
}
import CustomInput from "@/components/custom/custom-input"
import CustomSelect from "@/components/custom/custom-select"
import { Button } from "@/components/ui/button"
import { Form } from "@/components/ui/form"
import { Label } from "@/components/ui/label"
import { useFormResult } from "@/lib/context/form-result-context"
import { zodResolver } from "@hookform/resolvers/zod"
import { Minus, Plus, Save, Trash } from "lucide-react"
import { useEffect } from "react"
import { useFieldArray, useForm } from "react-hook-form"
import z from "zod"

const FormSchema = z.object({
    name : z.string().nonempty("Please enter product name."),
    category : z.string().nonempty("Please select category."),
    size: z.array(z.object({
        value : z.string()
    }))
})

type FormType = z.infer<typeof FormSchema>

export default function FormArray() {

    const {setResult} = useFormResult()
    useEffect(() => setResult(), [setResult])

    const form = useForm<FormType>({
        resolver: zodResolver(FormSchema),
        defaultValues: {
            name : "",
            category: "",
            size: [{value : ""}]
        }
    })

    const {fields, append, remove} = useFieldArray({
        control: form.control,
        name: "size"
    });

    const saveAction = (form: FormType) => {
        const result = {
            ...form,
            size: form.size.map(a => a.value)
        }
        setResult(JSON.stringify(result, null, 2))
    }

    const clearAction = () => {
        form.reset()
        setResult()
    }

    const addSize = () => append({value : ""})

    const removeSize = (index: number) => {
        const length = fields.length
        remove(index)

        if(length == 1) {
            append({value : ""})
        }
    }

    return (
        <Form {...form}>
            <form onSubmit={form.handleSubmit(saveAction)}>

                <CustomInput control={form.control} path="name" label="Product Name" className="mb-3" />

                <CustomSelect control={form.control} path="category" label="Category" widthClass="w-full" className="mb-3" 
                    options={["Foods", "Drinks", "Fashion"].map(a => ({id : a, value : a}))} />

                <Label className="mb-2">Size</Label>
                {fields.map((item, index) => 
                    <div key={item.id} className="flex gap-2 mb-3">
                        <CustomInput control={form.control} path={`size.${index}.value`} 
                            className="flex-1"  />

                        <Button onClick={() => removeSize(index)} type="button">
                            <Minus />
                        </Button>
                    </div>
                )}

                <div className="flex gap-2">
                    <Button onClick={clearAction} type="button" variant={'outline'}>
                        <Trash /> Clear
                    </Button>

                    <Button onClick={addSize} type="button" variant={'outline'}>
                        <Plus /> Add Size
                    </Button>

                    <Button type="submit">
                        <Save /> Save
                    </Button>
                </div>

            </form>
        </Form>
    )
}
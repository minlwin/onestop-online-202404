import FormActions from "@/components/app/form-actions"
import CustomDatePicker from "@/components/custom/custom-date-picker"
import CustomInput from "@/components/custom/custom-input"
import CustomTextarea from "@/components/custom/custom-textarea"
import { Button } from "@/components/ui/button"
import { Card, CardContent } from "@/components/ui/card"
import { Form, FormItem, FormLabel } from "@/components/ui/form"
import { useFormResult } from "@/lib/context/form-result-context"
import { zodResolver } from "@hookform/resolvers/zod"
import { Minus, Plus } from "lucide-react"
import { useEffect } from "react"
import { useFieldArray, useForm } from "react-hook-form"
import z from "zod"

const FormSchema = z.object({
    issueAt : z.date("Please enter issue date."),
    particular : z.string().nonempty("Please enter particular."),
    items : z.array(z.object({
        itemName : z.string().nonempty("Please enter item name."),
        unitPrice : z.number(),
        quantity: z.number()
    }))
})

type FormType = z.infer<typeof FormSchema>

export default function DynamicForm() {

    const {setResult} = useFormResult()
    useEffect(() => setResult(), [setResult])

    const form = useForm<FormType>({
        resolver: zodResolver(FormSchema),
        defaultValues: {
            issueAt: undefined,
            particular: '',
            items: [{
                itemName: "",
                unitPrice: 0,
                quantity: 0
            }]
        }
    })

    const {fields, append, remove} = useFieldArray({
        control: form.control,
        name: 'items'
    })

    const saveAction = (form:FormType) => setResult(JSON.stringify(form, null, 2))
    const clearAction = () => {
        form.reset()
        setResult()
    }

    const addItem = () => append({itemName : "", unitPrice : 0, quantity : 0})
    const removeItem = (index:number) => {
        remove(index)

        if(form.watch('items').length == 0) {
            addItem()
        }
    }

    const totalArray = form.watch('items').map(a => a.unitPrice * a.quantity)

    return (
        <Form {...form}>
            <form onSubmit={form.handleSubmit(saveAction)}>

                <CustomDatePicker control={form.control} path="issueAt"
                    label="Issue Date" className="mb-3" widthClassName="w-1/2" />

                <CustomTextarea control={form.control} path="particular"
                    label="Particular" className="mb-3" placeholder="Enter Particular Message" />

                <section className="mb-3">
                {fields.map((field, index) => 
                    <Card key={field.id} className="mb-3">
                        <CardContent>
                            <CustomInput control={form.control} path={`items.${index}.itemName`} 
                                label="Item Name" className="mb-2" />

                            <div className="grid grid-cols-3 gap-4 mb-3">
                                <CustomInput type="number" control={form.control} path={`items.${index}.unitPrice`} label="Unit Price" />
                                <CustomInput type="number" control={form.control} path={`items.${index}.quantity`} label="Quantity" />
                                <FormItem>
                                    <FormLabel>Total</FormLabel>
                                    <span className="border rounded-md text-sm px-2 py-2">{totalArray[index]}</span>
                                </FormItem>
                            </div>  

                            <div>
                                <Button onClick={() => removeItem(index)} type="button">
                                    <Minus /> Delete
                                </Button> 
                                {index == fields.length - 1 && 
                                    <Button onClick={addItem} type="button" className="ms-2">
                                        <Plus /> Add Item
                                    </Button>     
                                }    
                            </div>  
                        </CardContent>
                    </Card>
                )}    
                </section>

                <FormActions clear={clearAction} />
            </form>
        </Form>
    )
}
import FormActions from "@/components/app/form-actions"
import CustomDatePicker from "@/components/custom/custom-date-picker"
import { Form } from "@/components/ui/form"
import { useFormResult } from "@/lib/context/form-result-context"
import { zodResolver } from "@hookform/resolvers/zod"
import { add } from "date-fns"
import { useEffect } from "react"
import { useForm } from "react-hook-form"
import z from "zod"

const FormSchema = z.object({
    date : z.date("Please enter due date.")
})

type FormType = z.infer<typeof FormSchema>

export default function UiDatePicker() {

    const {setResult} = useFormResult()
    useEffect(() => setResult(), [setResult])

    const form = useForm<FormType>({
        resolver : zodResolver(FormSchema),
        defaultValues : {
            date : undefined
        }
    })

    const saveAction = (form: FormType) => {
        setResult(JSON.stringify(form, null, 2))
    }

    const clear = () => {
        form.reset()
        setResult()
    }

    return (
        <Form {...form}>
            <form onSubmit={form.handleSubmit(saveAction)}>

                <CustomDatePicker 
                    control={form.control} 
                    path={"date"} label="Due Date" className="mb-4" 
                    minDate={add(new Date, {months : -1})}
                    maxDate={add(new Date, {months: 1})}/>

                <FormActions clear={clear} />
            </form>
        </Form>
    )
}
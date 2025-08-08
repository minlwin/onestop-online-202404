import FormActions from "@/components/app/form-actions"
import CustomCheckSingle from "@/components/custom/custom-check-single"
import CustomDatePicker from "@/components/custom/custom-date-picker"
import CustomInput from "@/components/custom/custom-input"
import CustomSelect from "@/components/custom/custom-select"
import { Form } from "@/components/ui/form"
import { useFormResult } from "@/lib/context/form-result-context"
import { zodResolver } from "@hookform/resolvers/zod"
import { useEffect } from "react"
import { useForm } from "react-hook-form"
import z from "zod"

const FormSchema = z.object({
    cousreName : z.string().nonempty("Please enter course name"),
    level : z.string().nonempty("Please select level"),
    startDate: z.date("Please select start date"),
    endDate: z.date("Please select end date"),
    publishNow: z.boolean()
})

type FormType = z.infer<typeof FormSchema>

const LEVELS = ["Basic", "Intermediate", "Advance", "All In One"]

export default function UsingAll() {

    const {setResult} = useFormResult()
    useEffect(() => setResult(), [setResult])

    const form = useForm<FormType>({
        resolver: zodResolver(FormSchema),
        defaultValues: {
            cousreName : '',
            level: '',
            startDate: undefined,
            endDate: undefined,
            publishNow: false
        }
    })

    const saveAction = (form: FormType) => setResult(JSON.stringify(form, null, 2))
    const clear = () => {
        form.reset()
        setResult()
    }

    return (
        <Form {...form}>
            <form onSubmit={form.handleSubmit(saveAction)}>

                <CustomInput control={form.control} path="cousreName" 
                    label="Course Name" className="mb-3" />

                <CustomSelect control={form.control} path="level" 
                    label="Course Level" className="mb-3" widthClass="w-2/3"
                    options={LEVELS.map(a => ({id : a, value : a}))}  />  

                <div className="flex mb-3 gap-4">
                    <CustomDatePicker control={form.control} path="startDate" 
                        label="Start Date" />
                    <CustomDatePicker control={form.control} path="endDate" 
                        label="End Date"  />
                </div>

                <CustomCheckSingle constorl={form.control} path="publishNow" 
                    label="Publish Now" className="mb-4" />

                <FormActions clear={clear} />
            </form>
        </Form>
    )
}
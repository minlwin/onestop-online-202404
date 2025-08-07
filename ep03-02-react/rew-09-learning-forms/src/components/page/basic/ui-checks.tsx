import FormActions from "@/components/app/form-actions"
import CustomCheckMultiple from "@/components/custom/custom-check-multiple"
import CustomCheckSingle from "@/components/custom/custom-check-single"
import CustomInput from "@/components/custom/custom-input"
import { Form } from "@/components/ui/form"
import { useFormResult } from "@/lib/context/form-result-context"
import type { Option } from "@/lib/types"
import { zodResolver } from "@hookform/resolvers/zod"
import { useEffect } from "react"
import { useForm } from "react-hook-form"
import z from "zod"

const FormSchema = z.object({
    name: z.string().nonempty("Please enter name."),
    subjects: z.array(z.string()).nonempty("Please select subject."),
    accept : z.boolean()
})

type FormType = z.infer<typeof FormSchema>

const SUBJECTS:Option[] = [
    {id : "1", value : "Java Basic"},
    {id : "2", value : "Spring Framework"},
    {id : "3", value : "TypeScript"},
    {id : "4", value : "React"},
]

export default function UiChecks() {

    const {setResult} = useFormResult()
    useEffect(() => setResult(), [setResult])

    const form = useForm<FormType>({
        resolver : zodResolver(FormSchema),
        defaultValues: {
            name : "",
            subjects: [],
            accept: false
        }
    })

    const saveAction = (form: FormType) => {
        setResult(JSON.stringify(form, null, 2))
    }

    const clear = () => {
        setResult()
        form.reset()
    }

    return (
        <Form {...form} >
            <form onSubmit={form.handleSubmit(saveAction)}>
                <CustomInput control={form.control} path="name" label="Name" className="mb-3" />
                
                <CustomCheckMultiple control={form.control} path="subjects"
                    options={SUBJECTS}
                    label="Subjects" className="mb-3" />

                <CustomCheckSingle constorl={form.control} path="accept" label="Accept" className="mb-3" />

                <FormActions clear={clear} />
            </form>
        </Form>
    )
}
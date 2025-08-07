import FormActions from "@/components/app/form-actions";
import CustomRadioGroup from "@/components/custom/custom-radio-group";
import { Form } from "@/components/ui/form";
import { useFormResult } from "@/lib/context/form-result-context";
import type { Option } from "@/lib/types";
import { zodResolver } from "@hookform/resolvers/zod";
import { useEffect } from "react";
import { useForm } from "react-hook-form";
import z from "zod";

const SUBJECTS:Option[] = [
    {id : "1", value : "Java Basic"},
    {id : "2", value : "Spring Framework"},
    {id : "3", value : "TypeScript"},
    {id : "4", value : "React"},
]

const FormSchema = z.object({
    subject : z.string().nonempty("Please select subject.")
})

type FormType = z.infer<typeof FormSchema>

export default function UiRadios() {
    const {setResult} = useFormResult()
    useEffect(() => setResult(), [setResult])

    const form = useForm<FormType>({
        resolver : zodResolver(FormSchema),
        defaultValues: {
            subject : ""
        }
    })

    const clear = () => {
        form.reset()
        setResult()
    }

    const saveAction = (form: FormType) => {
        setResult(JSON.stringify(form, null, 2))
    }

    return (
        <Form {...form}>
            <form onSubmit={form.handleSubmit(saveAction)}>
                <CustomRadioGroup control={form.control} path="subject" label="Subject" className="mb-3" options={SUBJECTS} />
                <FormActions clear={clear} />
            </form>
        </Form>
    )
}

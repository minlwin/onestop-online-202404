import FormActions from "@/components/app/form-actions";
import CustomSelect from "@/components/custom/custom-select";
import { Form } from "@/components/ui/form";
import { SUBJECTS } from "@/lib/consts";
import { useFormResult } from "@/lib/context/form-result-context";
import { zodResolver } from "@hookform/resolvers/zod";
import { useEffect } from "react";
import { useForm } from "react-hook-form";
import z from "zod";

const FormSchema = z.object({
    subject : z.string().nonempty("Please select subject.")
})

type FormType = z.infer<typeof FormSchema>

export default function UiSelect() {

    const {setResult} = useFormResult()
    useEffect(() => setResult(), [setResult])

    const form = useForm<FormType>({
        resolver :zodResolver(FormSchema),
        defaultValues: {
            subject : ""
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

                <CustomSelect className="mb-4" widthClass="w-1/2"
                    control={form.control} 
                    path="subject" 
                    options={SUBJECTS} />

                <FormActions clear={clear} />
            </form>
        </Form>
    )
}
import FormActions from "@/components/app/form-actions"
import CustomInput from "@/components/custom/custom-input"
import { Form } from "@/components/ui/form"
import { useFormResult } from "@/lib/context/form-result-context"
import { zodResolver } from "@hookform/resolvers/zod"
import { useEffect } from "react"
import { useForm } from "react-hook-form"
import z from "zod"

const FormSchema = z.object({
    name : z.string().nonempty("Please enter name."),
    contact: z.object({
        phone: z.string().nonempty("Please enter phone number."),
        email: z.string().nonempty("Please enter email address."),
        address: z.string().nonempty("Please enter address.")
    })
})

type FormType = z.infer<typeof FormSchema>

export default function FormGroup() {

    const {setResult} = useFormResult()
    useEffect(() => setResult(), [setResult])

    const form = useForm<FormType>({
        resolver: zodResolver(FormSchema),
        defaultValues: {
            name: "",
            contact: {
                phone: "",
                email: "",
                address: ""
            }
        }
    })

    const saveAction = (form: FormType) => setResult(JSON.stringify(form, null, 2))
    const clearAction = () => {
        form.reset()
        setResult()
    }

    return (
        <Form {...form}>
            <form onSubmit={form.handleSubmit(saveAction)}>
                
                <CustomInput control={form.control} path="name" label="Name" className="mb-3" />
                <CustomInput control={form.control} path="contact.phone" label="Phone" type="tel" className="mb-3" />
                <CustomInput control={form.control} path="contact.email" label="Email" type="email" className="mb-3" />
                <CustomInput control={form.control} path="contact.address" label="Address" className="mb-3" />

                <FormActions clear={clearAction} />
            </form>
        </Form>
    )
}
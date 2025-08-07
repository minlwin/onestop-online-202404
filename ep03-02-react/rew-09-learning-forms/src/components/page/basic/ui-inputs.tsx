import { Form } from "@/components/ui/form";
import { useForm } from "react-hook-form";
import * as z from "zod";
import { zodResolver } from "@hookform/resolvers/zod"
import { useFormResult } from "@/lib/context/form-result-context";
import FormActions from "@/components/app/form-actions";
import CustomInput from "@/components/custom/custom-input";
import { useEffect } from "react";

const InputFormSchema = z.object({
    text : z.string()
        .nonempty("Please enter text input."),
    password : z.string()
        .nonempty("Please enter password.")
        .min(6, "Password must be 6 to 8 characters.")
        .max(8, "Password must be 6 to 8 characters."),
    email : z.string()
        .nonempty("Please enter email.")
        .regex(z.regexes.email, "Invalid email format."),
    phone : z.string()
        .nonempty("Please enter phone number.")
        .regex(z.regexes.number, "Phone number must be digits.") 
})

type InputFormType = z.infer<typeof InputFormSchema>

export default function UiInputs() {

    const {setResult} = useFormResult()

    useEffect(() => setResult(), [setResult])

    const form = useForm<InputFormType>({
        resolver : zodResolver(InputFormSchema),
        defaultValues: {
            text: "",
            password: "",
            email : "",
            phone : ""
        }
    })

    const onSave = (form : InputFormType) => {
        setResult(JSON.stringify(form, null, 2))
    }

    const clear = () => {
        form.reset()
        setResult()
    }

    return (
        <Form {...form}>
            <form onSubmit={form.handleSubmit(onSave)} >
                <CustomInput control={form.control} path="text" label="Text Input" className="mb-3" />
                <CustomInput control={form.control} path="password" type="password" label="Password Input" className="mb-3" />
                <CustomInput control={form.control} path="email" type="email" label="Email Input" className="mb-3" />
                <CustomInput control={form.control} path="phone" type="tel" label="Phone Input" className="mb-3" />
           
                <FormActions clear={clear} />
            </form>
        </Form>
    )
}


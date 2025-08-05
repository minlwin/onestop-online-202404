import { Form } from "@/components/ui/form";
import { useForm } from "react-hook-form";
import * as z from "zod";
import { zodResolver } from "@hookform/resolvers/zod"
import CustomFormInput from "@/components/custom/custom-form-input";
import { Button } from "@/components/ui/button";
import { Save, Trash2 } from "lucide-react";
import { useFormResult } from "@/lib/context/form-result-context";

const InputFormSchema = z.object({
    text : z.string().nonempty(),
    password : z.string().nonempty(),
    email : z.string().nonempty(),
    phone : z.string().nonempty() 
})

type InputFormType = z.infer<typeof InputFormSchema>

export default function UiInputs() {

    const form = useForm<InputFormType>({
        resolver : zodResolver(InputFormSchema)
    })

    const {setResult} = useFormResult()

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
                <CustomFormInput control={form.control} name="text" label="Text Input" className="mb-3" />
                <CustomFormInput control={form.control} name="password" type="password" label="Password Input" className="mb-3" />
                <CustomFormInput control={form.control} name="email" type="email" label="Email Input" className="mb-3" />
                <CustomFormInput control={form.control} name="phone" type="tel" label="Phone Input" className="mb-3" />
           
                <div>
                    <Button type="button" onClick={clear} variant={"outline"}>
                        <Trash2 /> Clear
                    </Button>

                    <Button type="submit" className="ms-1">
                        <Save /> Save
                    </Button>
                </div>
            </form>
        </Form>
    )
}


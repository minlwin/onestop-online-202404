'use client'

import FormsInput from "@/components/forms/forms-input";
import { Button } from "@/components/ui/button";
import { ActivationForm, ActivationFormSchema } from "@/lib/forms";
import { zodResolver } from "@hookform/resolvers/zod";
import { Check, UserCheck } from "lucide-react";
import { useParams, useRouter } from "next/navigation";
import { useForm } from "react-hook-form";

export default function ActivationPage() {

    const router = useRouter()
    const { id } = useParams()

    const form = useForm({
        resolver: zodResolver(ActivationFormSchema),
        defaultValues: {
            otpCode: "",
            password: "",
            confirmPassword: ""
        }
    })

    const onActivate = (form : ActivationForm) => {
        const activationForm = {userId: id, ...form}
        console.log(activationForm)
        router.replace("/member")
    }

    return (
        <div className="space-y-6">
            <h1 className="flex items-center gap-2">
                <UserCheck /> <span className="text-2xl font-semibold">Activate Account</span>
            </h1>

            <form onSubmit={form.handleSubmit(onActivate)} className="space-y-4">
                <FormsInput control={form.control} path="otpCode" label="Code send by email" />
                <FormsInput control={form.control} path="password" type="password" label="Your Password" />
                <FormsInput control={form.control} path="confirmPassword" type="password" label="Confirm Password" />

                <Button type="submit">
                    <Check /> Activate
                </Button>
            </form>
        </div>
    )
}
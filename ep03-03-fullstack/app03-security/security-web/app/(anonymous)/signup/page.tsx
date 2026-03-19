'use client'

import FormsInput from "@/components/forms/forms-input"
import { Button } from "@/components/ui/button"
import { SignUpForm, SignUpFormSchema } from "@/lib/forms"
import { zodResolver } from "@hookform/resolvers/zod"
import { FormInput, UserPlus } from "lucide-react"
import { useRouter } from "next/navigation"
import { useForm } from "react-hook-form"

export default function SignUpPage() {

    const router = useRouter()

    const form = useForm({
        resolver : zodResolver(SignUpFormSchema),
        defaultValues: {
            email: "",
            name: ""
        }
    })

    const onSignUp = (form: SignUpForm) => {
        router.replace(`/activate/1`)
    }

    return (
        <div className="space-y-6">
            <h1 className="flex items-center gap-2">
                <UserPlus /> <span className="text-2xl font-semibold">Sign Up</span>
            </h1>

            <form onSubmit={form.handleSubmit(onSignUp)} className="space-y-4">
                <FormsInput control={form.control} path="name" label="User Name" />
                <FormsInput control={form.control} path="email" label="Email For Login" type="email" />

                <Button type="submit">
                    <UserPlus /> Sign Up
                </Button>
            </form>
        </div>
    )
}
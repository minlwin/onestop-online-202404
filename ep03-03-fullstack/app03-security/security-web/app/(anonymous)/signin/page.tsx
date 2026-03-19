'use client'

import FormsInput from "@/components/forms/forms-input"
import { Button } from "@/components/ui/button"
import { SignInForm, SignInFormSchema } from "@/lib/forms"
import { zodResolver } from "@hookform/resolvers/zod"
import { LogIn, Unlock } from "lucide-react"
import { useRouter } from "next/navigation"
import { useForm } from "react-hook-form"

export default function SignInPage() {

    const router = useRouter()

    const form = useForm<SignInForm>({
        resolver: zodResolver(SignInFormSchema),
        defaultValues: {
            username: "",
            password: ""
        }
    })

    const onSignIn = (form:SignInForm) => {
        const routeUrl = `/${form.password.toLocaleLowerCase()}`
        router.replace(routeUrl)
    } 

    return (
        <div className="space-y-6">
            <h1 className="flex items-center gap-2">
                <LogIn /> <span className="text-2xl font-semibold">Sign In</span>
            </h1>

            <form onSubmit={form.handleSubmit(onSignIn)} className="space-y-4">
                <FormsInput control={form.control} path="username" label="Login ID" type="email" />
                <FormsInput control={form.control} path="password" type="password" label="Password" />

                <nav>
                    <Button type="submit">
                        <Unlock /> Sign In
                    </Button>
                </nav>
            </form>
        </div>
    )
}
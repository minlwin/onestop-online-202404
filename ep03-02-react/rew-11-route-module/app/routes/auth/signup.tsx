import { zodResolver } from "@hookform/resolvers/zod"
import { DoorOpen, UserPlus } from "lucide-react"
import { FormProvider, useForm } from "react-hook-form"
import { Link } from "react-router"
import AppPageTitle from "~/components/custom/app-page-title"
import FormsInput from "~/components/custom/forms-input"
import { Button } from "~/components/ui/button"
import { SignUpSchema, type SignUpForm } from "~/lib/form-schema"

export function meta() {
    return [
        {"title" : "My Shop | Sign Up"}
    ]
}

export default function Signup() {

    const form = useForm<SignUpForm>({
        resolver: zodResolver(SignUpSchema),
        defaultValues: {
            name: '',
            username: '',
            password: ''
        }
    })

    const signUpAction = (form:SignUpForm) => {
        console.log(form)
    }

    return (
        <>
            <header>
                <AppPageTitle title="Sign Up" icon={<UserPlus />} />
                <p>Welcome to MY SHOP!</p>
            </header>
            <FormProvider {...form}>
                <form onSubmit={form.handleSubmit(signUpAction)}>
                    <FormsInput control={form.control} path="name" label="User Name" className="mb-3" />
                    <FormsInput control={form.control} path="username" label="Login ID" className="mb-3" />
                    <FormsInput control={form.control} path="password" label="Password" className="mb-3" type="password" />

                    <div>
                        <Button asChild>
                            <Link to="/signin">
                                <DoorOpen /> Sign In
                            </Link>
                        </Button> 
                        <Button type="submit" className="ms-2">
                            <UserPlus /> Sign Up
                        </Button>
                    </div>
                </form>
            </FormProvider>        
        </>
    )
}
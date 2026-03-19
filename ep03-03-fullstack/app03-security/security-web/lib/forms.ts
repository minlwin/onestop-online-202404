import z from "zod";

export const SignUpFormSchema = z.object({
    name : z.string().nonempty("Please enter user name."),
    email: z.email("Please enter valid email.").nonempty("Please enter email.")
})

export type SignUpForm = z.infer<typeof SignUpFormSchema>

export const SignInFormSchema = z.object({
    username: z.email("Please enter valid email for login.").nonempty("Please enter login id."),
    password : z.string().nonempty("Please enter password."),
})

export type SignInForm = z.infer<typeof SignInFormSchema>

export const ActivationFormSchema = z.object({
    otpCode: z.string().nonempty("Please enter OTP Code."),
    password : z.string().nonempty("Please enter password."),
    confirmPassword: z.string()
}).refine(data => data.password === data.confirmPassword, {
    message: "Passwords don't match",
    path: ["confirmPassword"]
})

export type ActivationForm = z.infer<typeof ActivationFormSchema>
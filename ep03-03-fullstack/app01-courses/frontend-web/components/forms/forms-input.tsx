import { HTMLInputTypeAttribute } from "react";
import { Control, FieldValues, Path } from "react-hook-form";
import { FormControl, FormField, FormItem, FormLabel, FormMessage } from "../ui/form";
import { Input } from "../ui/input";

type FormsInputPops<T extends FieldValues> = {
    control: Control<T>
    path: Path<T>
    label?: string
    type?: HTMLInputTypeAttribute
    className?: string
    placeholder?: string
}

export default function FormsInput<T extends FieldValues>({control, path, label, type, className, placeholder} : FormsInputPops<T>) {
    return (
        <FormField control={control} name={path} render={({field}) => 
            <FormItem className={className}>
                {label && <FormLabel>{label}</FormLabel>}

                <FormControl>
                    <Input {...field} type={type} placeholder={placeholder || `Enter ${label || "input"}`}  />
                </FormControl>
                <FormMessage />
            </FormItem>
        } />
    )
}
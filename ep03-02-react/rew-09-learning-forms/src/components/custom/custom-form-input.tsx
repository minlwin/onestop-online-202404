import type { Control, FieldValues, Path } from "react-hook-form";
import { FormControl, FormField, FormItem, FormLabel, FormMessage } from "../ui/form";
import { Input } from "../ui/input";

type CustomFormInputProps<T extends FieldValues> = {
    control : Control<T>
    name : Path<T>
    label : string
    type? : React.HTMLInputTypeAttribute
    className? : string
}

export default function CustomFormInput<T extends FieldValues>({control, name, label, type, className} :CustomFormInputProps<T>) {
    return (
        <FormField 
            control={control} 
            name={name} 
            render={({field}) => 
                <FormItem className={className}>
                    <FormLabel>{label}</FormLabel>
                    <FormControl>
                        <Input {...field} type={type || 'text'} placeholder={`Enter ${label}`} />
                    </FormControl>
                    <FormMessage />
                </FormItem>
        } />
    )
}
import type { Control, FieldValues, Path } from "react-hook-form";
import { FormControl, FormField, FormItem, FormLabel, FormMessage } from "../ui/form";
import { Input } from "../ui/input";

type CustomFormProps<T extends FieldValues> = {
    control : Control<T>
    path : Path<T>
    label? : string
    type? : React.HTMLInputTypeAttribute
    className? : string,
}

export default function CustomInput<T extends FieldValues>({control, path, label, type, className} :CustomFormProps<T>) {
    return (
        <FormField 
            control={control} 
            name={path} 
            render={({field}) => 
                <FormItem className={className}>
                    {label && <FormLabel>{label}</FormLabel>}
                    <FormControl>
                        <Input {...field} type={type || 'text'} placeholder={`Enter ${label}`} />
                    </FormControl>
                    <FormMessage />
                </FormItem>
        } />
    )
}
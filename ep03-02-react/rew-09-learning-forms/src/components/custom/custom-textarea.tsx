import type { Control, FieldValues, Path } from "react-hook-form";
import { FormField, FormItem, FormLabel } from "../ui/form";
import { Textarea } from "../ui/textarea";

export type CustomTextareaPops<T extends FieldValues> = {
    control : Control<T>
    path : Path<T>
    label? : string
    className? : string
    placeholder? : string
}

export default function CustomTextarea<T extends FieldValues>({
    control, path, label, className, placeholder
} : CustomTextareaPops<T>) {
    return (
        <FormField control={control} name={path} render={({field}) => 
            <FormItem className={className}>
                {label && <FormLabel>{label}</FormLabel>}
                <Textarea {...field} placeholder={placeholder} />
            </FormItem>
        }/>
    )
}
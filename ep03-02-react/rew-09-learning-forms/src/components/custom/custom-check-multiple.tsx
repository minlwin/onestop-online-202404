import type { Option } from "@/lib/types"
import type { Control, FieldValues, Path } from "react-hook-form"
import { FormControl, FormField, FormItem, FormLabel, FormMessage } from "../ui/form"
import { Checkbox } from "../ui/checkbox"

export type CustomCheckMultipleProps<T extends FieldValues> = {
    control : Control<T>
    path : Path<T>
    options : Option[]
    label? : string
    className? : string
}

export default function CustomCheckMultiple<T extends FieldValues>({
    control,
    path,
    label,
    className,
    options
} : CustomCheckMultipleProps<T>) {

    const isChecked = (id:string, value?:string[]) => {
        if(value) {
            return value.includes(id)
        }
        return false
    }

    const filtered = (id:string, value?:string[]) => {
        if(value) {
            return value.filter(a => a != id)
        }
        return []
    }

    return (
        <FormField control={control} name={path} render={() => 
            <FormItem className={className}>
                {label && <FormLabel className="mb-2">{label}</FormLabel>}

                {options.map(option => 
                    <FormField key={option.id} control={control} name={path} render={({field}) => 
                        <FormItem className="flex gap-2 items-center">
                            <FormControl>
                                <Checkbox 
                                    checked={isChecked(option.id, field.value)}
                                    onCheckedChange={checked => checked ? 
                                        field.onChange([...field.value, option.id]) : 
                                        field.onChange(filtered(option.id, field.value))} />
                            </FormControl>
                            <FormLabel>{option.value}</FormLabel>
                        </FormItem>
                    } />
                )}
                <FormMessage />
            </FormItem>
        } />
    )
}
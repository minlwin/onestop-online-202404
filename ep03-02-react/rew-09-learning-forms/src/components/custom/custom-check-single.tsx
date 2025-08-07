import type { Control, FieldValues, Path } from "react-hook-form"
import { FormControl, FormField, FormItem, FormLabel, FormMessage } from "../ui/form"
import { Checkbox } from "../ui/checkbox"

export type CustomCheckSingleProps<T extends FieldValues> = {
    constorl : Control<T>
    path : Path<T>
    label : string
    className? : string
}

export default function CustomCheckSingle<T extends FieldValues>({
    constorl,
    path,
    label,
    className
} : CustomCheckSingleProps<T>) {

    return (
        <FormField control={constorl} name={path} render={({field}) => 
            <FormItem className={className}>
                <div className="flex gap-2 items-center">
                    <FormControl>
                        <Checkbox checked={field.value} onCheckedChange={field.onChange} />
                    </FormControl>
                    <FormLabel>{label}</FormLabel>
                </div>
                <FormMessage />
            </FormItem>
        } />
    )

}
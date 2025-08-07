import type { Option } from "@/lib/types"
import type { Control, FieldValues, Path } from "react-hook-form"
import { FormControl, FormField, FormItem, FormLabel, FormMessage } from "../ui/form"
import { RadioGroup, RadioGroupItem } from "../ui/radio-group"

export type CustomRadioGroupProps<T extends FieldValues> = {
    control : Control<T>
    path : Path<T>,
    options : Option[]
    label? : string
    className? : string
}

export default function CustomRadioGroup<T extends FieldValues>({
    control,
    path,
    options,
    label,
    className
} : CustomRadioGroupProps<T>) {
    return (
        <FormField control={control} name={path} render={({field}) => 
            <FormItem className={className}>
                {label && <FormLabel>{label}</FormLabel>}
                <FormControl>
                    <RadioGroup onValueChange={field.onChange} value={field.value} className="flex flex-col">
                        {options.map(option => 
                            <FormItem className="flex gap-2 items-center">
                                <FormControl>
                                    <RadioGroupItem value={option.id} />
                                </FormControl>
                                <FormLabel>{option.value}</FormLabel>
                            </FormItem>
                        )}
                    </RadioGroup>
                </FormControl>
                <FormMessage />
            </FormItem>
        } />
    )
}
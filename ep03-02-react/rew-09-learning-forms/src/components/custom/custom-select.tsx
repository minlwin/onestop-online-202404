import type { Option } from "@/lib/types";
import type { Control, FieldValues, Path } from "react-hook-form";
import { FormControl, FormField, FormItem, FormLabel, FormMessage } from "../ui/form";
import { Select, SelectContent, SelectItem, SelectTrigger, SelectValue } from "../ui/select";

export type CustomSelectProps<T extends FieldValues> = {
    control : Control<T>
    path : Path<T>
    options : Option[]  
    label? : string
    className? : string,
    widthClass? : string
}

export default function CustomSelect<T extends FieldValues>({
    control,
    path, 
    options,
    label,
    className,
    widthClass
} : CustomSelectProps<T>) {
    return (
        <FormField control={control} name={path} render={({field}) => 
            <FormItem className={className}>
                {label && <FormLabel>{label}</FormLabel>}
                <Select value={field.value} onValueChange={field.onChange}>
                    <FormControl>
                        <SelectTrigger className={widthClass}>
                            <SelectValue placeholder="Select One" />
                        </SelectTrigger>    
                    </FormControl>  
                    <SelectContent>
                        {options.map(option => 
                            <SelectItem key={option.id} value={option.id}>{option.value}</SelectItem>
                        )}
                    </SelectContent>                  
                </Select>
                <FormMessage />
            </FormItem>
        } />
    )
}
import { Control, FieldValues, Path } from "react-hook-form";
import { FormControl, FormField, FormItem, FormLabel, FormMessage } from "../ui/form";
import { Select, SelectContent, SelectItem, SelectTrigger, SelectValue } from "../ui/select";
import { OptionItem } from "@/lib/types";

type FormsSelectPops<T extends FieldValues> = {
    control: Control<T>
    path: Path<T>
    options: OptionItem []
    label?: string
    className?: string
    placeholder?: string
}

export default function FormsSelect<T extends FieldValues>({control, path, label, className, placeholder, options} : FormsSelectPops<T>) {
    return (
        <FormField control={control} name={path} render={({field}) => 
            <FormItem className={className}>
                {label && <FormLabel>{label}</FormLabel>}

                <Select value={field.value} onValueChange={field.onChange}>
                    <FormControl>
                        <SelectTrigger className="w-full">
                            <SelectValue placeholder={placeholder || "Select One"} />
                        </SelectTrigger>
                    </FormControl>

                    <SelectContent>
                        {options.map((item, index) => 
                            <SelectItem key={index} value={item.key}>{item.value}</SelectItem>
                        )}
                    </SelectContent>
                </Select>

                <FormMessage />
            </FormItem>
        } />
    )
}
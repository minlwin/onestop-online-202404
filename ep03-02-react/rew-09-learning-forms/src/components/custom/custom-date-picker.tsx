import type { Control, FieldValues, Path } from "react-hook-form"
import { FormControl, FormField, FormItem, FormLabel, FormMessage } from "../ui/form"
import { Popover, PopoverContent, PopoverTrigger } from "../ui/popover"
import { Button } from "../ui/button"
import { format } from "date-fns"
import { CalendarIcon } from "lucide-react"
import { Calendar } from "../ui/calendar"

export type CustomDatePickerProps<T extends FieldValues> = {
    control : Control<T>
    path : Path<T>
    minDate? : Date
    maxDate? : Date
    label? : string
    className? : string
    widthClassName? :string 
}

export default function CustomDatePicker<T extends FieldValues> ({
    control,
    path,
    label,
    className,
    minDate,
    maxDate,
    widthClassName
} : CustomDatePickerProps<T>) {

    const isDisabled = (date: Date) => {

        if((minDate && date < minDate) || date < new Date('1970-01-01')) {
            return true
        }

        if(maxDate && date > maxDate) {
            return true;
        }

        return false;
    }

    return (
        <FormField control={control} name={path} render={({field}) => 
            <FormItem className={className}>
                {label && <FormLabel>{label}</FormLabel>}
                <Popover>
                    <PopoverTrigger asChild>
                        <FormControl>
                            <Button variant={'outline'} className={`px-3 flex justify-between ${widthClassName || 'w-[240px]'}`} >
                                <span>{field.value ? format(field.value, 'PPP') : "Pick Date"}</span>
                                <CalendarIcon />
                            </Button>
                        </FormControl>
                    </PopoverTrigger>
                    <PopoverContent>
                        <Calendar mode="single" 
                            selected={field.value} 
                            onSelect={field.onChange} 
                            disabled={isDisabled}
                            captionLayout="dropdown" />
                    </PopoverContent>
                    <FormMessage />
                </Popover>
            </FormItem>
        } />
    )
}
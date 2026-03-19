import { HTMLInputTypeAttribute } from "react";
import { Control, Controller, FieldValues, Path } from "react-hook-form";
import { Field, FieldError, FieldLabel } from "../ui/field";
import { Input } from "../ui/input";

type FormsInputProps<T extends FieldValues> = {
    control : Control<T>,
    path : Path<T>,
    label : string,
    type? : HTMLInputTypeAttribute
}

export default function FormsInput<T extends FieldValues>({control, path, label, type} : FormsInputProps<T>) {
    return (
        <Field>
            <FieldLabel>{label}</FieldLabel>
            <Controller name={path} control={control} render={({field, fieldState}) => 
                <>
                    <Input {...field} placeholder={`Enter ${label}`} type={type} />
                    {fieldState.error && 
                        <FieldError>{fieldState.error.message}</FieldError>
                    }
                </>
            } />
            
        </Field>
    )
}
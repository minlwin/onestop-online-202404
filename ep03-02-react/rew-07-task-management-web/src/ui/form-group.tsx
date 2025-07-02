import type React from "react"

export function FormGroup({label, className, children} : FormGroupProps) {
    return (
        <div className={className}>
            <label className="form-label">{label}</label>
            {children}
        </div>
    )
}

type FormGroupProps = {
    label : string
    className? : string
    children? : React.ReactNode
}
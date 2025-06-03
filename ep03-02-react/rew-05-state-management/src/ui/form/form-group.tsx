import type React from "react";

export default function FormGroup({label, children} : {label:string, children:React.ReactNode}) {
    return (
        <div className="mb-3">
            <label className="form-label">{label}</label>
            {children}
        </div>
    )
}
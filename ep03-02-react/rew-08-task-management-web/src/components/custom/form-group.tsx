import type React from "react";
import { Label } from "../ui/label";

export default function FormGroup({label, className, children} : {label : string, className?: string, children? : React.ReactNode}) {
    return (
        <div className={className}>
            <Label className="mb-2 block">{label}</Label>
            {children}
        </div>
    )
}
import { Home } from "lucide-react";
import type React from "react";

export default function PageTitle({title, icon} : {title?:string, icon?:React.ReactNode}) {
    return (
        <h3 className="d-flex align-items-center">
            {icon || <Home />} 
            <span className="d-inline-block ps-2">{title || 'Page Title'}</span>
        </h3>
    )
}
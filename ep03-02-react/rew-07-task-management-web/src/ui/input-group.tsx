import type React from "react";

export default function InputGroup({icon, action, children} : {
    icon? : string,
    action? : VoidFunction,
    children? : React.ReactNode
}) {
    return (
        <div className="input-group">
            {children}
            {icon && 
                <button type="button" onClick={action} className="input-group-text">
                    <i className={icon}></i>
                </button>
            }
        </div>
    )
}
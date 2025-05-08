import type React from "react";

export default function Card({title, children} : {title:string, children?:React.ReactNode}) {
    return (
        <div className="card">
            <div className="card-body">
                <h5 className="card-title">{title}</h5>
                <div className="mt-4">
                    {children}
                </div>
            </div>
        </div>
    )
}
import type React from "react";

export default function Card({children} : {children : React.ReactNode}) {
    return (
        <div className="card">
            <div className="card-body">
                {children}
            </div>
        </div>
    )
}
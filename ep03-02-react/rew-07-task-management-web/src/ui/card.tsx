import type React from "react"

export default function Card({title, children, action} : CardModel) {

    return (
        <div className="card">
            <div className="card-header d-flex justify-content-between align-items-center">
                <h5 className="card-title">{title}</h5>
                {action}
            </div>

            <div className="card-body">
                {children}
            </div>
        </div>
    )
}

type CardModel = {
    title: string
    children: React.ReactNode
    action? : React.ReactNode
}
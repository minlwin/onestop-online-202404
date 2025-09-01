import type React from "react"

type PageTitleProps = {
    title : string
    icon : React.ReactNode
}

export default function AppPageTitle({title, icon} : PageTitleProps) {
    return (
        <h1 className="flex items-center gap-2">
            {icon}
            <span className="text-xl">{title}</span>
        </h1>
    )
}
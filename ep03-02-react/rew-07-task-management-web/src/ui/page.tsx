import type React from "react"

export default function Page({title, icon, children} : PageProps) {
    return (
        <>
            <h4><i className={icon}></i> {title}</h4>

            <section className="mt-3">
                {children}
            </section>
        </>
    )
}

type PageProps = {
    title : string
    icon : string
    children : React.ReactNode
}
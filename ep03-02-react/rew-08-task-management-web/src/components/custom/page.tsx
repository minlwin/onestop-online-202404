import type React from "react";

export default function Page({title, icon, children} : {title: string, icon? : React.ReactNode, children? : React.ReactNode}) {
    return (
        <>
            <h1 className="text-xl flex items-center">{icon && <span className="inline-block me-2">{icon}</span>}{title}</h1>

            <section className="mt-4">
                {children}
            </section>
        </>
    )
}
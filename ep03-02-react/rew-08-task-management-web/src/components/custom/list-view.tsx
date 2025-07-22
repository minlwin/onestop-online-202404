import type React from "react";

export default function ListView({search, children} : {search : React.ReactNode, children : React.ReactNode}) {
    return (
        <>
            {search}

            <section className="pt-4">
                {children}
            </section>
        </>
    )
}
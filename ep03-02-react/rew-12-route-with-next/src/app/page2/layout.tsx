import Link from "next/link";
import React from "react";

export default function Layout({children} : {children : React.ReactNode}) {
    return (
        <div className="flex">
            <nav className="w-1/4 flex flex-col gap-4">
                <Link href={"/page2"}>Page 2</Link>
                <Link href={"/page2/sub1"}>Sub Menu 1</Link>
                <Link href={"/page2/sub2"}>Sub Menu 2</Link>
            </nav>
            <section>
                {children}
            </section>
        </div>
    )
}
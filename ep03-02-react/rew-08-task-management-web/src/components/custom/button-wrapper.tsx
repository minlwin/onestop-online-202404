import type React from "react";

export default function ButtonWrapper({children} : {children : React.ReactNode}) {
    return (
        <div className="pt-[1.4rem]">{children}</div>
    )
}
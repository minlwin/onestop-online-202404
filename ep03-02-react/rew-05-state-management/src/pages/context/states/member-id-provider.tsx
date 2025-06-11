import React, { useState } from "react"
import { MemberIdContext } from "./member-id-context"

export default function MemberIdProvider({children} : {children : React.ReactNode}) {
    const [id, setId] = useState(0)
    return (
        <MemberIdContext value={{id: id, setId: setId}}>
            {children}
        </MemberIdContext>
    )
}


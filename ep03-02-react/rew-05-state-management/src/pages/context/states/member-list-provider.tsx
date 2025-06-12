import React, { useState } from "react";
import { MemberListContext } from "./member-list-context";
import type { Member } from "../../reducer/member-domain";

export default function MemberListProvider({children} : {children : React.ReactNode}) {
    const state = useState<Member[]>([])
    return (
        <MemberListContext value={state}>
            {children}
        </MemberListContext>
    )
}
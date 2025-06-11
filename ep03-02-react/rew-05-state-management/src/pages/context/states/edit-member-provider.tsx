import React, { useState } from "react";
import { DEFAULT_MEMBER } from "../../reducer/domain";
import { EditMemberContext } from "./edit-member-context";

export default function EditMemberProvider({children} : {children: React.ReactNode}) {
    const [member, setMember] = useState(DEFAULT_MEMBER)

    return (
        <EditMemberContext value={{member: member, setMeber: setMember}}>
            {children}
        </EditMemberContext>
    )
}
import { createContext, useContext } from "react";
import type { Member } from "../../reducer/member-domain";

interface EditMemberContextType {
    member: Member
    setMeber : (member: Member) => void
}

const EditMemberContext = createContext<EditMemberContextType | undefined>(undefined)

function useEditMemberContext() {
    const context = useContext(EditMemberContext)
    if(!context) {
        throw new Error("Invalid usage of Edit Member Context.")
    }
    return context
}

function useEditMember() {
    return useEditMemberContext().member
}

function useEditMemberSetter() {
    return useEditMemberContext().setMeber
}

export {
    EditMemberContext,
    useEditMember,
    useEditMemberSetter
}
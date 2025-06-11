import { createContext, useContext } from "react";
import type { Member } from "../../reducer/member-domain";

type MemberListContextType = [Member[], (list : Member[]) => void]

const MemberListContext = createContext<MemberListContextType | undefined>(undefined)

function useMemberListContext() {
    const context = useContext(MemberListContext)

    if(!context) {
        throw new Error("Invalid usage of Member List Context.")
    }

    return context
}

function useMemberList() {
    return useMemberListContext()[0]
}

function useAddMemberAction() {
    const [members, setMembers] = useMemberListContext()
    return (member: Member) => {
        setMembers([...members, member])
    }
}

export {
    MemberListContext,
    useMemberList,
    useAddMemberAction
}
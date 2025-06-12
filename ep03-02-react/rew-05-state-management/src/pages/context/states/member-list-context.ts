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

function useMemberList():Member[] {
    return useMemberListContext()[0]
}

function useAddMemberAction() {
    const [members, setMembers] = useMemberListContext()
    return (member: Member) => {
        setMembers([...members, {...member}])
    }
}

function useUpdateMemberAction() {
    const [members, setMembers] = useMemberListContext()
    return (member:Member) => {
        const index = members.findIndex(a => a.id === member.id)
        members[index] = member
        setMembers([...members.map(a => ({...a}))])
    }
}

function useDeleteMemberAction() {
    const [members, setMembers] = useMemberListContext()
    return (id : number) => {
        setMembers(members.filter(a => a.id !== id).map(a => ({...a})))
    }
}

export {
    MemberListContext,
    useMemberList,
    useAddMemberAction,
    useUpdateMemberAction,
    useDeleteMemberAction
}
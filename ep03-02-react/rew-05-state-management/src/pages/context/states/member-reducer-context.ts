import { createContext, useContext } from "react";
import type { Member } from "../../reducer/member-domain";
import type { MemberAction } from "../../reducer/member-reducer";

type MemberReducerContextType = [Member[], React.Dispatch<MemberAction>]

const MemberReducerContext = createContext<MemberReducerContextType | undefined>(undefined)

function useMemberReducerContext() {
    const context = useContext(MemberReducerContext)

    if(!context) {
        throw new Error("Invalid usage of Member Reducer Context")
    }

    return context
}

function useReducerMembers() {
    return useMemberReducerContext()[0]
}

function useMemberDispatcher() {
    return useMemberReducerContext()[1]
}

export {
    MemberReducerContext,
    useReducerMembers,
    useMemberDispatcher
}
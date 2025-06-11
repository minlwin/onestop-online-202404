import { createContext, useContext } from "react"

interface MemberIdContextType {
    id : number
    setId : (id : number) => void
}

const MemberIdContext = createContext<MemberIdContextType | undefined>(undefined)

function useMemberIdContext() {
    const context = useContext(MemberIdContext)

    if(!context) {
        throw Error("Invalid member id context usage")
    }

    return context
}

function useNextMemberId()  {
    const context = useMemberIdContext()
    const nextId = context.id + 1
    context.setId(nextId)
    return nextId
}

export {
    MemberIdContext, 
    useNextMemberId
}
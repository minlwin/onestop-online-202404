import type { Member } from "./member-domain";

export type MemberAction = {
    type: 'create' | 'update' | 'delete'
    member? : Member
    id? : number
}

export function memberReducer(state: Member[], action: MemberAction) {
    switch(action.type) {
    case 'create':
        return action.member ? [...state, action.member] : [...state]
    case 'delete' : 
        return action.id ? [...state.filter(a => a.id !== action.id)] : [...state]
    case 'update' :
        if(action.member) {
            const pox = state.findIndex(a => a.id == action.member?.id)
            return [...state.splice(0, pox), {...action.member}, ...state.splice(pox)]
        } else {
            return [...state]
        }
    }
}
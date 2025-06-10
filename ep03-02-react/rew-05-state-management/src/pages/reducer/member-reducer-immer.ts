import type { Member } from "./member-domain";
import type { MemberAction } from "./member-reducer";

export function memberReducer(draft:Member[], action : MemberAction) {
    switch(action.type) {
    case 'create' :
        if(action.member) {
            draft.push(action.member)
        }
        break
    case 'update' :
        if(action.member) {
            const index = draft.findIndex(a => a.id == action.member?.id)
            draft[index] = action.member
        }
        break
    case 'delete' :
        if(action.id) {
            return draft.filter(a => a.id !== action.id)
        }     
        break
    }
}
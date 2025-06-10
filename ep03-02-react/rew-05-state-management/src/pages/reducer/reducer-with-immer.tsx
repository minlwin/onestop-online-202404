import { useState } from "react";
import Card from "../../ui/card/card-component";
import type { Member } from "./member-domain";
import MemberEditForm from "./member-edit";
import MemberList from "./member-list";
import { memberReducer } from "./member-reducer-immer";
import { useImmerReducer } from "use-immer";
import type { MemberAction } from "./member-reducer";
import { DEFAULT_MEMBER } from "./domain";
export default function ImmerWithReducer() {

    const [id, setId] = useState(0)
    const [members, dispatch] = useImmerReducer<Member[], MemberAction>(memberReducer, [])
    const [target, setTarget] = useState<Member>(DEFAULT_MEMBER)

    function editMember(id: number) {
        const member = members.find(a => a.id == id)
        if(member) {
            setTarget({...member})
        }
    }

    function clearForm() {
        setTarget({...DEFAULT_MEMBER})
    }

    function saveMember(member:Member) {
        if(member.id == 0) {
            setId(id + 1)
            dispatch({type : 'create', member: {...member , id:id + 1 }})
        } else {
            dispatch({type : 'update', member})
        }
        setTarget({...DEFAULT_MEMBER})
    } 

    return (
        <>
            <div className="d-flex mb-3 justify-content-between">
                <h3>Using Reducer With Immer</h3>
                <button onClick={clearForm} type="button" className="btn btn-primary">Add New Member</button>
            </div>

            <div className="row">
                <div className="col-4">
                    <Card>
                        <MemberEditForm member={target} saveMember={saveMember} clearForm={clearForm}/>
                    </Card>
                </div>

                <div className="col">
                    <Card>
                        <MemberList members={members} editMember={editMember} deleteMember={id => dispatch({type : 'delete', id : id})}/>
                    </Card>
                </div>
            </div>
        </>
    )
}
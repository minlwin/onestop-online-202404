import { useReducer, useState } from "react";
import Card from "../../ui/card/card-component";
import type { Member } from "./member-domain";
import MemberEditForm from "./member-edit";
import MemberList from "./member-list";
import { memberReducer } from "./member-reducer";
import { DEFAULT_MEMBER } from "./domain";

export default function WithReducer() {

    const [id, setId] = useState(0)
    const [members, dispatch] = useReducer(memberReducer, [])
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
        if(!member.id) {
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
                <h3>Using Reducer</h3>
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
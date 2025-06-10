import { useState } from "react";
import Card from "../../ui/card/card-component";
import type { Member } from "./member-domain";
import MemberEditForm from "./member-edit";
import MemberList from "./member-list";
import { DEFAULT_MEMBER } from "./domain";

export default function WithoutReducer() {

    const [id, setId] = useState(0)
    const [members, setMembers] = useState<Member[]>([])
    const [target, setTarget] = useState<Member>({...DEFAULT_MEMBER})

    function addMember(member:Member) {
        setMembers([...members.map(a => ({...a})), member])
    }

    function updateMember(member:Member) {
        const index = members.findIndex(a => a.id == member.id)
        setMembers([
            ...members.splice(0, index).map(a => ({...a})), 
            {...member}, 
            ...members.splice(index + 1).map(a => ({...a}))
        ])
    }

    function deleteMember(id: number) {
        setMembers([...members.filter(a => a.id != id).map(a => ({...a}))])
    }

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
            addMember({...member , id:id + 1 })
            setId(id + 1)
        } else {
            updateMember(member)
        }
        setTarget({...DEFAULT_MEMBER})
    } 

    return (
        <>
            <div className="d-flex mb-3 justify-content-between">
                <h3>Without Reducer</h3>
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
                        <MemberList members={members} editMember={editMember} deleteMember={deleteMember}/>
                    </Card>
                </div>
            </div>
        </>
    )
}
import { useEditMemberSetter } from "../../pages/context/states/edit-member-context"
import { useDeleteMemberAction, useMemberList } from "../../pages/context/states/member-list-context"
import type { Member } from "../../pages/reducer/member-domain"

export default function MemberList() {
    
    const members:Member[] = useMemberList()
    const editMember = useEditMemberSetter()
    const deleteMember = useDeleteMemberAction()
    
    return (
        <>
            <h4>Member List</h4>

            {members.length == 0 ? 
                <div>There is no member</div> : 
                <table className="table table-striped">
                    <thead>
                        <tr>
                            <th>ID</th>
                            <th>Name</th>
                            <th>Phone</th>
                            <th>Email</th>
                            <th></th>
                        </tr>
                    </thead>
                    <tbody>
                        {members.map(member => 
                            <tr key={member.id}>
                                <td>{member.id}</td>
                                <td>{member.name}</td>
                                <td>{member.phone}</td>
                                <td>{member.email}</td>
                                <td>
                                    <a href="#" className="icon-link d-inline-block me-3" onClick={e => {
                                        e.preventDefault()
                                        editMember({...member})
                                    }}>
                                        <i className="bi-pencil"></i>
                                    </a>
                                    <a href="#" className="icon-link d-inline-block" onClick={e => {
                                        e.preventDefault()
                                        deleteMember(member.id)
                                    }}>
                                        <i className="bi-trash"></i>
                                    </a>
                                </td>
                            </tr>
                        )}
                    </tbody>
                </table>
            }
        </>
    )
}
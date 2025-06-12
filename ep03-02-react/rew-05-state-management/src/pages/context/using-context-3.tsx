import Card from "../../ui/card/card-component";
import MemberEditForm from "../../ui/member/member-edit";
import MemberList from "../../ui/member/member-list";
import { DEFAULT_MEMBER } from "../reducer/domain";
import { useEditMemberSetter } from "./states/edit-member-context";
import MemberProvider from "./states/member-provider";

export default function UsingContext3() {
    return (
        <MemberProvider>
            <View />
        </MemberProvider>
    )
}

function View() {
    const setEditMember = useEditMemberSetter()
    return (
        <>
            <div className="d-flex justify-content-between">
                <h3>Context with useState</h3>
                <button onClick={() => setEditMember({...DEFAULT_MEMBER})} className="btn btn-primary">
                    <i className="bi-plus"></i> Add Member
                </button>
            </div>

            <div className="row mt-3">
                <div className="col-4">
                    <Card>
                        <MemberEditForm />
                    </Card>
                </div>
                <div className="col">
                    <Card>
                        <MemberList />
                    </Card>
                </div>
            </div>
        </>
    )
}
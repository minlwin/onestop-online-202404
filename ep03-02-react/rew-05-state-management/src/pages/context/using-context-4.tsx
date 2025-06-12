import MemberEditForm from "../../ui/reducer/member-edit";
import MemberList from "../../ui/reducer/member-list";
import { MemberReducerProvider } from "./states/member-reducer-provider";

export default function UsingContext4() {
    return (
        <MemberReducerProvider>
            <View />
        </MemberReducerProvider>
    )
}

function View() {
    return (
        <>
            <div className="d-flex justify-content-between">
                <h3>Using Context with Immer Reducer</h3>
                <button className="btn btn-primary">
                    <i className="bi-plus"></i> Add Member
                </button>
            </div>

            <div className="row mt-3">
                <div className="col-4">
                    <MemberEditForm />
                </div>
                <div className="col">
                    <MemberList />
                </div>
            </div>
        </>
    )
}
import Card from "../../../ui/card"

export default function ProjectMemberList() {
    return (
        <div className="row">
            <div className="col-8">
                <MembersInProject />
            </div>
            <div className="col">
                <MemberSearch />
            </div>
        </div>
    )
}

function MembersInProject() {
    return (
        <Card title="Members in Project">
            <></>
        </Card>
    )
}

function MemberSearch() {
    return (
        <Card title="Search Member">
            <></>
        </Card>
    )
}


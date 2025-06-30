import { Link, useParams } from "react-router";
import Page from "../../ui/page";
import { useEffect, useState } from "react";
import Card from "../../ui/card";
import { FormGroup } from "../../ui/form-group";
import type { MemberDetails, MemberProjectItem } from "../../model/output/member-details";
import Loading from "../../ui/loading";
import { findMemberById } from "../../model/client/member-client";

export default function MemberDetailsComponent() {

    const params = useParams()
    const [details, setDetails] = useState<MemberDetails | undefined>()

    useEffect(() => {
        const id = params.id 
        async function load() {
            if(id) {
                const response = await findMemberById(Number.parseInt(id))
                setDetails(response)
            }
        }

        load()
    }, [params])

    if(!details) {
        return (
            <Loading />
        )
    }

    const {projects, ...profile} = details

    return (
        <Page title="Member Details" icon="bi-person">
            <div className="row">

                <div className="col-4">
                    <Card title="Profile" action={
                        <Link to={`/member/edit?id=${params.id}`}>
                            <i className="bi-pencil"></i>
                        </Link>
                    }>
                        <Profile data={profile} />
                    </Card>
                </div>

                <div className="col">
                    <Card title="Projects" action={
                        <Link to={''}>
                            <i className="bi-plus-lg"></i>
                        </Link>
                    }>
                        <Projects projects={projects}/>
                    </Card>
                </div>
            </div>
        </Page>
    )
}

function Profile({data} : {data : Omit<MemberDetails, "projects">}) {
    return (
        <section>
            <FormGroup label="Name" className="mb-3">
                <span className="form-control">{data.name}</span>
            </FormGroup>
            <FormGroup label="Position" className="mb-3">
                <span className="form-control">{data.position}</span>
            </FormGroup>
            <FormGroup label="Phone" className="mb-3">
                <span className="form-control">{data.phone}</span>
            </FormGroup>
            <FormGroup label="Email" className="mb-3">
                <span className="form-control">{data.email}</span>
            </FormGroup>
            <FormGroup label="Entry At" className="mb-3">
                <span className="form-control">{data.entryAt}</span>
            </FormGroup>
            {data.retiredAt && 
                <FormGroup label="Retired At" className="mb-3">
                    <span className="form-control">{data.retiredAt}</span>
                </FormGroup>
            }
        </section>
    )
}

function Projects({projects} : {projects : MemberProjectItem[]}) {

    if(projects.length == 0) {
        return (
            <p>There is no project in this member. Please add project to this member.</p>
        )
    }

    return (
        <section>
            <table className="table table-striped">
                <thead>
                    <tr>
                        <th>ID</th>
                        <th>Name</th>
                        <th>Start At</th>
                        <th>Mile Stone</th>
                        <th>Status</th>
                        <th className="text-end">Task</th>
                    </tr>
                </thead>
                <tbody>
                {projects.map(project => 
                    <tr key={project.id}>
                        <td>{project.id}</td>
                        <td>{project.name}</td>
                        <td>{project.startAt}</td>
                        <td>{project.mileStone}</td>
                        <td>{project.status}</td>
                        <td className="text-end">{project.tasks}</td>
                    </tr>
                )}    
                </tbody>
            </table>                
        </section>
    )
}
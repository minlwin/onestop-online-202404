import Page from "@/components/custom/page";
import { Button } from "@/components/ui/button";
import { Card, CardContent, CardDescription, CardHeader, CardTitle } from "@/components/ui/card";
import { findProjectById } from "@/lib/client/project-client";
import type { ProjectDetails } from "@/lib/model/output/project-details";
import { Calendar, Files, Folder, Info, Pencil } from "lucide-react";
import { useEffect, useState } from "react";
import { Outlet, useNavigate, useParams } from "react-router";

export default function ProjectDetails() {

    const params = useParams()
    const id = params.id 

    const [details, setDetails] = useState<ProjectDetails>()

    useEffect(() => {
        async function load() {
            if(id) {
                const response = await findProjectById(id)
                setDetails(response)
            }
        }

        load()
    }, [id])

    if(!details) {
        return (
            <></>
        )
    }

    return (
        <Page icon={<Folder />} title="Project Details">
            <div className="flex gap-6">
                <div className="w-1/4">
                    <ProjectInfo info={details} />
                </div>

                <div className="w-3/4">
                    <TasksInProject />
                </div>
            </div>
        </Page>
    )
}

function ProjectInfo({info} : {info : ProjectDetails}) {

    const navigate = useNavigate()

    function edit(id: unknown) {
        navigate(`/project/edit?id=${id}`)
    }

    return (
        <Card>
            <CardHeader>
                <CardTitle className="flex items-center"><Info className="me-2" /> {info.name}</CardTitle>
                <CardDescription>{info.details}</CardDescription>
            </CardHeader>

            <CardContent>
                <ProjectInfoItem name="Start Date" value={info.startDate} />
                <ProjectInfoItem name="Due Date" value={info.dueDate} />

                <div className="pt-5">
                    <Button onClick={() => edit(info.id)} className="w-full">
                        <Pencil /> Edit Project
                    </Button>
                </div>
            </CardContent>
        </Card>
    )
}

function ProjectInfoItem({name, value} : {name: string, value? : string}) {
    return (
        <div className="flex gap-4 mb-3 items-center">
            <Calendar />
            <div>
                <div className="text-gray-500 text-sm">{name}</div>
                <div>{value}</div>
            </div>
        </div>
    )
}

function TasksInProject() {
    return (
        <Card>
            <CardHeader>
                <CardTitle className="flex justify-between">
                    <div className="flex items-center"><Files className="me-2" /> Tasks in Project</div>
                </CardTitle>
                <CardDescription></CardDescription>
            </CardHeader>

            <CardContent>
                <Outlet />
            </CardContent>
        </Card>
    )
}
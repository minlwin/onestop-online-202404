import FormGroup from "@/components/custom/form-group";
import { Button } from "@/components/ui/button";
import { findTaskById } from "@/lib/client/task-client";
import type { TaskDetails } from "@/lib/model/output/task-details";
import { List, Pencil } from "lucide-react";
import { useEffect, useState } from "react";
import { Link, useParams } from "react-router";

export default function TaskDetails() {

    const {id, taskId} = useParams()
    const [details, setDetails] = useState<TaskDetails>()

    useEffect(() => {
        async function load() {
            if(taskId) {
                const response = await findTaskById(taskId)
                setDetails(response)
            }
        }

        load()

    }, [taskId])

    if(!details) {
        return (
            <></>
        )
    }

    return (
        <>
            <div className="grid grid-cols-2 gap-4 mb-4">
                <FormGroup label="Task Name">
                    <span className="form-control">{details.name}</span>
                </FormGroup>
                <FormGroup label="Assignee">
                    <span className="form-control">{details.assignee}</span>
                </FormGroup>
            </div>

            <div className="grid grid-cols-3 gap-4 mb-4">
                <FormGroup label="Due Date">
                    <span className="form-control">{details.duedate}</span>
                </FormGroup>
                <FormGroup label="Start Date">
                    <span className="form-control">{details.startDate || 'Not Yet'}</span>
                </FormGroup>
                <FormGroup label="End Date">
                    <span className="form-control">{details.endDate || 'Not Yet'}</span>
                </FormGroup>
            </div>

            <FormGroup label="Description" className="mb-4">
                <div className="form-control h-24">
                    {details.description}
                </div>
            </FormGroup>

            <div>
                <Button asChild>
                    <Link to={`/project/${id}`}>
                        <List /> Task List
                    </Link>
                </Button>

                <Button asChild className="ms-2">
                    <Link to={`/project/${id}/task/edit?taskId=${taskId}`}>
                        <Pencil /> Edit
                    </Link>
                </Button>
            </div>

        </>
    )
}
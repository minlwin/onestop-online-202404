import { Link } from "react-router";
import { FormGroup } from "../../../ui/form-group";

export default function ProjectTaskDetails() {
    return (
        <>
            <div className="row mb-3">
                <FormGroup className="col-6" label="Task Name">
                    <span className="form-control">Task Name</span>
                </FormGroup>
            </div>

            <div className="row mb-3">
                <FormGroup className="col-3" label="Category">
                    <span className="form-control">Category Name</span>
                </FormGroup>
                <FormGroup className="col-3" label="Assignee">
                    <span className="form-control">Jhon Doe</span>
                </FormGroup>
                <FormGroup className="col-3" label="Position">
                    <span className="form-control">Programmer</span>
                </FormGroup>
            </div>

            <div className="row mb-3">
                <FormGroup className="col-3" label="Due Date">
                    <span className="form-control">2025-08-10</span>
                </FormGroup>
                <FormGroup className="col-3" label="Start Date">
                    <span className="form-control">Not Now</span>
                </FormGroup>
                <FormGroup className="col-3" label="End Date">
                    <span className="form-control">Not Now</span>
                </FormGroup>
                <FormGroup className="col-3" label="Status">
                    <span className="form-control">Pending</span>
                </FormGroup>
            </div>

            <div className="mb-3">
                <FormGroup label="Description">
                    <div style={{height: 120}} className="form-control"></div>
                </FormGroup>
            </div>

            <Link to={``} className="btn btn-dark">
                <i className="bi-pencil"></i> Edit Task
            </Link>
        </>
    )
}
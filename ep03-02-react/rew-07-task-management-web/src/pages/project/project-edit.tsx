import { useSearchParams } from "react-router";
import Page from "../../ui/page";
import { FormGroup } from "../../ui/form-group";

export default function ProjectEdit() {

    const [queryParams] = useSearchParams()
    const id = queryParams.get('id')

    return (
        <Page icon="bi-pencil" title={id ? 'Edit Project' : 'Create New Project'}>

            <form className="w-50">
                <FormGroup label="Project Name">
                    <input type="text" className="form-control" placeholder="Enter Project Name" />
                </FormGroup>

                <div className="row mt-3">
                    <FormGroup className="col" label="Start Date">
                        <input type="date" className="form-control" />
                    </FormGroup>
                    <FormGroup className="col" label="Mile Stone">
                        <input type="date" className="form-control" />
                    </FormGroup>
                </div>

                <FormGroup label="Description" className="mt-3">
                    <textarea className="form-control"></textarea>
                </FormGroup>

                <div className="mt-3">
                    <button type="submit" className="btn btn-outline-dark">
                        <i className="bi-save"></i> Save Project
                    </button>
                </div>
            </form>

        </Page>
    )
}
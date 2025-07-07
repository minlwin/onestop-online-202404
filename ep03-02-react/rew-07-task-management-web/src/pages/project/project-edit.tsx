import { useNavigate, useSearchParams } from "react-router";
import Page from "../../ui/page";
import { FormGroup } from "../../ui/form-group";
import { useForm } from "react-hook-form";
import type { ProjectEditForm } from "../../model/input/project-edit-form";
import ErrorMessage from "../../ui/error-message";
import { useEffect } from "react";
import { createProject, findProjectForEdit, updateProject } from "../../model/client/project-client";

export default function ProjectEdit() {

    const [queryParams] = useSearchParams()
    const id = queryParams.get('id')
    const navigate = useNavigate()

    const {handleSubmit, register, reset, formState: {errors}} = useForm<ProjectEditForm>()

    useEffect(() => {

        async function load(id:unknown) {
            const response = await findProjectForEdit(id)
            reset(response)
        }

        if(id) {
            load(id)
        }

    }, [id, reset])

    async function save(form:ProjectEditForm) {
        const result = id ? await updateProject(id, form) : await createProject(form)
        navigate(`/project/details/${result.id}/overview`)
    }

    return (
        <Page icon="bi-pencil" title={id ? 'Edit Project' : 'Create New Project'}>

            <form onSubmit={handleSubmit(save)} className="w-50">
                <FormGroup label="Project Name">
                    <input type="text" className="form-control" placeholder="Enter Project Name" {
                        ...register('name', {required : "Please enter project name"})
                    } />
                    {errors.name && <ErrorMessage message={errors.name.message} />}
                </FormGroup>

                <div className="row mt-3">
                    <FormGroup className="col" label="Start Date">
                        <input type="date" className="form-control" {
                            ...register('startDate', {required : "Please enter start date"})
                        }/>
                        {errors.startDate && <ErrorMessage message={errors.startDate.message} />}
                    </FormGroup>
                    <FormGroup className="col" label="Mile Stone">
                        <input type="date" className="form-control" {
                            ...register('mileStone', {required : "Please enter mile stone"})
                        } />
                        {errors.mileStone && <ErrorMessage message={errors.mileStone.message} />}
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
import FormError from "@/components/custom/form-error";
import FormGroup from "@/components/custom/form-group";
import Page from "@/components/custom/page";
import { Button } from "@/components/ui/button";
import { Input } from "@/components/ui/input";
import { Textarea } from "@/components/ui/textarea";
import { createProject } from "@/lib/client/project-client";
import type { ProjectForm } from "@/lib/model/input/project-form";
import { Pencil, Save } from "lucide-react";
import { useForm } from "react-hook-form";
import { useNavigate } from "react-router";

export default function ProjectEdit() {

    const {handleSubmit, register, formState : {errors}} = useForm<ProjectForm>()
    const navigate = useNavigate()

    async function save(form:ProjectForm) {
        await createProject(form)
        navigate('/project')
    }

    return (
        <Page title="Project Edit" icon={<Pencil />}>
            <form onSubmit={handleSubmit(save)} className="w-1/2">
                <FormGroup label="Project Name" className="mb-4">
                    <Input {...register('name', {required: true})} placeholder="Enter Project Name" />
                    {errors.name && <FormError message="Please enter project name" />}
                </FormGroup>

                <div className="columns-2 mb-4">
                    <FormGroup label="Start Date">
                        <Input {...register('startDate', {required : true})} type="date" />
                        {errors.startDate && <FormError message="Please enter start date" />}
                    </FormGroup>
                    <FormGroup label="Due Date">
                        <Input {...register('dueDate', {required : true})} type="date" />
                        {errors.dueDate && <FormError message="Please enter due date" />}
                    </FormGroup>
                </div>

                <FormGroup label="Description" className="mb-4">
                    <Textarea {...register('description')} placeholder="Enter Description of Project"></Textarea>
                </FormGroup>

                <Button type="submit">
                    <Save /> Save Project
                </Button>
            </form>
        </Page>
    )
}
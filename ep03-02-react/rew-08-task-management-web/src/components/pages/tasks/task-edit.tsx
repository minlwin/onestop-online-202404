import FormError from "@/components/custom/form-error"
import FormGroup from "@/components/custom/form-group"
import { Button } from "@/components/ui/button"
import { Input } from "@/components/ui/input"
import { Textarea } from "@/components/ui/textarea"
import { createTask, findTaskById, updateTask } from "@/lib/client/task-client"
import { TaskEditSchema, type TaskEdit } from "@/lib/model/schema/task-schema"
import { zodResolver } from "@hookform/resolvers/zod"
import { List, Save } from "lucide-react"
import { useEffect } from "react"
import { useForm } from "react-hook-form"
import { Link, useNavigate, useParams, useSearchParams } from "react-router"

export default function TaskEdit() {

    const {id} = useParams()
    const [queries] = useSearchParams()
    const taskId = queries.get('taskId')

    const {handleSubmit, register, reset, formState : {errors}} = useForm<TaskEdit>({resolver : zodResolver(TaskEditSchema)})
    const navigate = useNavigate()

    useEffect(() => {
        if(id) {
            reset({
                projectId : id,
            })
        }
    }, [id, reset])

    useEffect(() => {
        async function load(id:unknown) {
            const respose = await findTaskById(id)
            reset({
                projectId: respose.project.id.toString(),
                name: respose.name,
                assignee: respose.assignee,
                dueDate: respose.duedate,
                startDate : respose.startDate,
                endDate: respose.endDate,
                description: respose.description
            })
        }

        if(taskId) {
            load(taskId)
        }
    }, [taskId, reset])

    async function save(form: TaskEdit) {
        const response = taskId ? await updateTask(taskId, form) : await createTask(form)
        if(response.success) {
            navigate(`/project/${id}`)
        }
    }

    return (
        <form onSubmit={handleSubmit(save)}>
            <input type="hidden" {...register('projectId')} />

            <div className="grid grid-cols-2 gap-4 mb-4">
                <FormGroup label="Task Name">
                    <Input {...register('name')} placeholder="Enter task name" />
                    {errors.name && <FormError message="Please enter task name." />}
                </FormGroup>
                <FormGroup label="Assignee">
                    <Input {...register('assignee')} placeholder="Enter assignee" />
                    {errors.assignee && <FormError message="Please enter assignee." />}
                </FormGroup>
            </div>

            <div className="grid grid-cols-3 gap-4 mb-4">
                <FormGroup label="Due Date">
                    <Input {...register('dueDate')} type="date" />
                    {errors.dueDate && <FormError message="Enter due date." />}
                </FormGroup> 
                <FormGroup label="Start Date">
                    <Input {...register('startDate')} type="date" />
                </FormGroup> 
                <FormGroup label="End Date">
                    <Input {...register('endDate')} type="date" />
                </FormGroup> 
            </div>

            <FormGroup label="Description" className="mb-4">
                <Textarea {...register('description')} placeholder="Enter Description" />
            </FormGroup>

            <div>
                <Button type="button" asChild>
                    <Link to={`/project/${id}`}>
                        <List /> Task List
                    </Link>
                </Button>
                <Button type="submit" className="ms-2">
                    <Save /> Save Task
                </Button>
            </div>
        </form>
    )
}
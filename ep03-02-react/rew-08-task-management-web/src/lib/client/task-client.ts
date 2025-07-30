import type { ModificationResult } from "../model/output/modification-result";
import type { TaskDetails } from "../model/output/task-details";
import type { TaskListItem } from "../model/output/task-list-item";
import type { TaskEdit, TaskSearch } from "../model/schema/task-schema";
import { restClient } from "../utils";

export async function searchTasks(params:TaskSearch):Promise<TaskListItem[]> {
    const response = await restClient().get('tasks', {params: params})
    return response.data
}

export async function createTask(form : TaskEdit):Promise<ModificationResult<number>> {
    const response = await restClient().post('tasks', form)
    return response.data
}

export async function findTaskById(id: unknown):Promise<TaskDetails> {
    const response = await restClient().get(`tasks/${id}`)
    return response.data
}

export async function updateTask(id: unknown, form:TaskEdit):Promise<ModificationResult<number>> {
    const respose = await restClient().put(`tasks/${id}`, form)
    return respose.data
}
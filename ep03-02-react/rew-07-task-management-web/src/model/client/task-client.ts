import type { TaskForm } from "../input/task-form";
import type { TaskSearch } from "../input/task-search";
import { DUMMY_PAGE, type ModificationResult } from "../output/_common";
import type { TaskSearchResult } from "../output/task-list-item";

export async function searchTask(form:TaskSearch):Promise<TaskSearchResult> {
    console.log(form)
    return {
        list: [
            {
                id: 1,
                projectId: 1,
                projectName: "POS System",
                categoryId: 1,
                categoryName: "Coding",
                memberId: 1,
                memberName: "Mike",
                startAt: "2025-05-01",
                mileStone: '2025-09-30',
                status: "Progress",
                taskName: "Security Integration"
            }
        ],
        pager: DUMMY_PAGE
    }
}

export async function createTask(form:TaskForm):Promise<ModificationResult> {
    console.log(form)
    return {id : 1}
}

export async function updateTask(id: unknown, form:TaskForm):Promise<ModificationResult> {
    console.log(form)
    return {id : id}
}
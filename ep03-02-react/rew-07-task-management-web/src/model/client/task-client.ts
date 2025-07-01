import type { TaskSearch } from "../input/task-search";
import { DUMMY_PAGE } from "../output/_common";
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
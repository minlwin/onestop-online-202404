import type { ProjectSearch } from "../input/project-search";
import { DUMMY_PAGE } from "../output/_common";
import type { ProjectListItem, ProjectSearchResult } from "../output/project-list.item";

export async function searchProject(form: ProjectSearch) : Promise<ProjectSearchResult> {
    console.log(form)
    return {
        list : DUMMY_PROJECTS,
        pager: DUMMY_PAGE
    }
}

const DUMMY_PROJECTS:ProjectListItem[] = [
    {
        id: 1,
        name: "POS System",
        createAt: "2025-04-01",
        startAt: "2025-05-01",
        mileStone: "2025-09-30",
        status: "On Schedule",
        members: 10, 
        tasks: 50
    }
]
import type { ProjectEditForm } from "../input/project-edit-form";
import type { ProjectSearch } from "../input/project-search";
import { DUMMY_PAGE, type ModificationResult } from "../output/_common";
import type { ProjectListItem, ProjectSearchResult } from "../output/project-list-item";

export async function searchProject(form: ProjectSearch) : Promise<ProjectSearchResult> {
    console.log(form)
    return {
        list : DUMMY_PROJECTS,
        pager: DUMMY_PAGE
    }
}

export async function findProjectForEdit(id:unknown):Promise<ProjectEditForm> {
    console.log(id)
    return {
        name : "Pos Development",
        startDate : "2025-04-01",
        mileStone: "2025-10-30"
    }
}

export async function createProject(form:ProjectEditForm) : Promise<ModificationResult> {
    console.log(form)
    return {
        id : 1
    }
}

export async function updateProject(id : unknown, form:ProjectEditForm) : Promise<ModificationResult> {
    console.log(id)
    console.log(form)
    return {
        id : 1
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
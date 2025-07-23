import type { ProjectForm } from "../model/input/project-form";
import type { ProjectSearch } from "../model/input/project-search";
import type { ModificationResult } from "../model/output/modification-result";
import type { ProjectDetails } from "../model/output/project-details";
import type { ProjectListItem } from "../model/output/project-list-item";
import { restClient } from "../utils";

export async function createProject(form:ProjectForm):Promise<ModificationResult<number>> {
    const response = await restClient().post('projects', form)
    return response.data
}

export async function updateProject(id: unknown,form:ProjectForm):Promise<ModificationResult<number>> {
    const response = await restClient().put(`projects/${id}`, form)
    return response.data
}


export async function searchProject(form:ProjectSearch):Promise<ProjectListItem[]> {
    const response = await restClient().get('projects', {params: form})
    return response.data
}

export async function findProjectById(id: unknown):Promise<ProjectDetails> {
    const response = await restClient().get(`projects/${id}`)
    return response.data
}
import type { ProjectListItem } from "./project-list-item"

export type TaskDetails = {
    id: number
    project: ProjectListItem
    name: string
    assignee: string
    duedate: string
    startDate?: string
    endDate?: string
    description?: string
}
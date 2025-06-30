import type { Pager } from "./_common"

export interface ProjectListItem {
    id: number
    name: string
    createAt: string
    startAt: string
    mileStone: string
    status: string
    members: number
    tasks: number
}

export type ProjectSearchResult = {
    list : ProjectListItem[]
} & {
    pager : Pager
}
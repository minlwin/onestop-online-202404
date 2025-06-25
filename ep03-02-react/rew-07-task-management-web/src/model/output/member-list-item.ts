import type { Pager } from "./_common"

export interface MemberListItem {
    id: number
    name: string
    position: string
    entryAt: string
    projects: number
    created: number
    onSchedule: number
    behind: number
    completed: number
    cancled: number
}

export type MemberSearchResult = {
    list: MemberListItem[]
} & {
    pager: Pager
}
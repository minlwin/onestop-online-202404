export interface MemberDetails {
    id: number
    name : string
    position: string
    phone: string
    email: string
    entryAt: string
    retiredAt?: string
    projects: MemberProjectItem[]
}

export interface MemberProjectItem {
    id: number
    name: string
    createAt: string
    startAt: string
    mileStone: string
    status: string
    tasks: number
}
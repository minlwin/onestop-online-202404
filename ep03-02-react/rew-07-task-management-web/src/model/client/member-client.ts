import type { MemberEditForm } from "../input/member-edit-form";
import type { MemberSearch } from "../input/member-search";
import { DUMMY_PAGE } from "../output/_common";
import type { MemberListItem, MemberSearchResult } from "../output/member-list-item";

export async function searchMember(form: MemberSearch):Promise<MemberSearchResult> {
    console.log(form)
    return {
        list: DUMMY_MEMBERS,
        pager: DUMMY_PAGE
    }
}

export async function findMemberById(id: number) {
    console.log(`Find Member ID : ${id}`)
    return DUMMY_MEMBERS.find(a => a.id == id)
}

export async function findMemberEditForm(id:string):Promise<MemberEditForm> {
    console.log(`Member ID : ${id}`)
    return {
        name: "Mike",
        position: "Programmer",
        phone: "0971817171",
        email: "mike@gmail.com",
        entryAt: "2025-06-20"
    }
}

export async function updateMember(id:string, form:MemberEditForm):Promise<number> {
    console.log({id: id, ...form})
    return 1
}

export async function createMember(form:MemberEditForm):Promise<number> {
    console.log(form)
    return 1
}

const DUMMY_MEMBERS:MemberListItem[] = [
    {
        id: 1,
        name: "Mike",
        position: "Programmer",
        entryAt: "2025-06-20",
        projects: 2,
        created: 20,
        onSchedule: 5,
        behind: 0,
        completed: 3,
        cancled: 0
    },
    {
        id: 2,
        name: "June",
        position: "System Engineer",
        entryAt: "2024-03-15",
        projects: 3,
        created: 10,
        onSchedule: 20,
        behind: 0,
        completed: 7,
        cancled: 3
    },
    {
        id: 3,
        name: "Cake",
        position: "Tester",
        entryAt: "2025-01-20",
        projects: 2,
        created: 0,
        onSchedule: 12,
        behind: 0,
        completed: 15,
        cancled: 0
    },
]
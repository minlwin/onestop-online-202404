import type { MemberEditForm } from "../input/member-edit-form";
import type { MemberSearch } from "../input/member-search";
import { DUMMY_PAGE, type ModificationResult } from "../output/_common";
import type { MemberDetails } from "../output/member-details";
import type { MemberListItem, MemberSearchResult } from "../output/member-list-item";

export async function searchMember(form: MemberSearch):Promise<MemberSearchResult> {
    console.log(form)
    return {
        list: DUMMY_MEMBERS,
        pager: DUMMY_PAGE
    }
}

export async function findMemberById(id: number):Promise<MemberDetails> {
    return {
        id: id,
        name: "Mike",
        position: "Programmer",
        phone: "0971817171",
        email: "mike@gmail.com",
        entryAt: "2025-06-20",
        projects: [
            {
                id: 1,
                name: "POS Development",
                createAt: "2025-04-01",
                startAt: "2025-05-01",
                mileStone: "2025-09-30",
                status: "On Schedule",
                tasks: 5
            }
        ]
    }
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

export async function updateMember(id:string, form:MemberEditForm):Promise<ModificationResult> {
    console.log({id: id, ...form})
    return {id : 1}
}

export async function createMember(form:MemberEditForm):Promise<ModificationResult> {
    console.log(form)
    return {id : 1}
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